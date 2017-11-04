package de.hoogvliet.task;

import de.hoogvliet.jeopardy.JeopardyService;
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

  public Map<String, Object> doTask() {
    long start = System.currentTimeMillis();
    Map<String, Object> response = new HashMap<>();
    response.put("joke", jokeService.getJoke());
    response.put("jeopardy", jeopardyService.getQuestion());
    long duration = System.currentTimeMillis() - start;
    gaugeService.submit("de.hoogvliet.task.doTask.duration", duration);
    return response;
  }

}
