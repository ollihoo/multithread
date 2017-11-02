package de.hoogvliet;

import de.hoogvliet.jeopardy.JeopardyService;
import de.hoogvliet.jokes.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
  @Autowired
  private JokeService jokeService;

  @Autowired
  private JeopardyService jeopardyService;

  public Joke getJoke() {
    return jokeService.getJoke();
  }

  public Jeopardy getJeopardyQuestion() {
    return jeopardyService.getQuestion();
  }

}
