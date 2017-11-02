package de.hoogvliet;

import de.hoogvliet.jokes.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TaskService {
  private static final String RANDOM_JEOPARDY_QUESTION_URL = "http://jservice.io/api/random";
  private static final String RANDOM_JOKE_URL = "https://08ad1pao69.execute-api.us-east-1.amazonaws.com/dev/random_joke";

  @Autowired
  private RestTemplateProvider restTemplateProvider;

  @Autowired
  private JokeService jokeService;

  public Joke getJoke() {
    return jokeService.getJoke();
  }

  public Jeopardy getJeopardyQuestion() {
    RestTemplate restTemplate = restTemplateProvider.getRestTemplate();
    Jeopardy[] results = restTemplate.getForObject(RANDOM_JEOPARDY_QUESTION_URL, Jeopardy[].class);
    return results[0];
  }


}