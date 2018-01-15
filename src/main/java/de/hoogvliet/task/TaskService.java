package de.hoogvliet.task;

import de.hoogvliet.jeopardy.JeopardyService;
import de.hoogvliet.jokes.JokeException;
import de.hoogvliet.jokes.JokeService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TaskService {
    private final JokeService jokeService;
    private final JeopardyService jeopardyService;
    private final GaugeService gaugeService;

    public TaskService (JokeService jokeService, JeopardyService jeopardyService, GaugeService gaugeService) {
        this.jokeService = jokeService;
        this.jeopardyService = jeopardyService;
        this.gaugeService = gaugeService;
    }


    public Map<String, Object> doTask() throws TaskServiceException {
        long start = System.currentTimeMillis();
        Map<String, Object> response = new HashMap<>();
        try {
            response.put("joke", jokeService.getJoke());
        } catch (JokeException e) {
            throw new TaskServiceException("Joke could not be executed. Check connection and service");
        }
        long jokeFinished = System.currentTimeMillis();
        response.put("jeopardy", jeopardyService.getQuestion());
        long jeopardyFinished = System.currentTimeMillis();

        long jokeDuration = jokeFinished - start;
        long jeopardyDuration = jeopardyFinished - jokeFinished;
        long summaryDuration = jeopardyFinished - start;

        gaugeService.submit("doTask.jokeduration", jokeDuration);
        gaugeService.submit("doTask.jeopardyduration", jeopardyDuration);
        gaugeService.submit("doTask.summaryduration", summaryDuration);

        return response;
    }

}
