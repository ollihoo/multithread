package de.hoogvliet.task;

import de.hoogvliet.jeopardy.JeopardyService;
import de.hoogvliet.jokes.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TaskService {
  @Autowired
  private JokeService jokeService;

  @Autowired
  private JeopardyService jeopardyService;

  public Map<String, Object> doTask() {
    Map<String, Object> response = new HashMap<>();
    response.put("joke", jokeService.getJoke());
    response.put("jeopardy", jeopardyService.getQuestion());
    return response;
  }

}
