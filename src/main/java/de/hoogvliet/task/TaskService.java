package de.hoogvliet.task;

import de.hoogvliet.jeopardy.JeopardyService;
import de.hoogvliet.jokes.Joke;
import de.hoogvliet.jokes.JokeException;
import de.hoogvliet.jokes.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TaskService {
  @Autowired
  private JokeService jokeService;

  @Autowired
  private JeopardyService jeopardyService;

  @Autowired
  private GaugeService gaugeService;

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
