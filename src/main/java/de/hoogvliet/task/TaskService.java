package de.hoogvliet.task;

import de.hoogvliet.jeopardy.Jeopardy;
import de.hoogvliet.jeopardy.JeopardyService;
import de.hoogvliet.jokes.Joke;
import de.hoogvliet.jokes.JokeException;
import de.hoogvliet.jokes.JokeService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

@Service
public class TaskService {
    private final JokeService jokeService;
    private final JeopardyService jeopardyService;
    private final GaugeService gaugeService;

    public TaskService(JokeService jokeService, JeopardyService jeopardyService, GaugeService gaugeService) {
        this.jokeService = jokeService;
        this.jeopardyService = jeopardyService;
        this.gaugeService = gaugeService;
    }


    public Map<String, Object> doTask() throws TaskServiceException {
        CompletableFuture<Jeopardy> jeopardyFuture = new CompletableFuture<>();
        CompletableFuture<Joke> jokeFuture = new CompletableFuture<>();

        long start = System.currentTimeMillis();


        jeopardyFuture.complete(getJeopardyAndMeasureDuration());
        try {
            jokeFuture.complete(getJokeAndMeasureDuration());
        } catch (TaskServiceException e) {
            jokeFuture.cancel(false);
        }

        try {
            Map<String, Object> response = new HashMap<>();
            response.put("joke", jokeFuture.get());
            response.put("jeopardy", jeopardyFuture.get());
            long duration = System.currentTimeMillis() - start;
            gaugeService.submit("doTask.summaryduration", duration);
            return response;
        } catch (ExecutionException | InterruptedException e) {
            throw new TaskServiceException("Task was interrupted.");
        } catch (CancellationException e) {
            throw new TaskServiceException("Could not finish task.");
        }

    }

    private Jeopardy getJeopardyAndMeasureDuration() {
        long start = System.currentTimeMillis();
        Jeopardy jeopardy = jeopardyService.getQuestion();
        gaugeService.submit("doTask.jeopardyduration", (System.currentTimeMillis() - start));
        return jeopardy;
    }

    private Joke getJokeAndMeasureDuration() throws TaskServiceException {
        long start = System.currentTimeMillis();
        try {
            Joke joke = jokeService.getJoke();
            gaugeService.submit("doTask.jokeduration", (System.currentTimeMillis() - start));
            return joke;
        } catch (JokeException e) {
            throw new TaskServiceException("Joke could not be executed. Check connection and service");
        }
    }


}
