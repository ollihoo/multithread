package de.hoogvliet;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TaskService {
  private static String RANDOM_JOKE_URL = "https://08ad1pao69.execute-api.us-east-1.amazonaws.com/dev/random_joke";

  public Joke getJoke() {
    RestTemplate restTemplate = new RestTemplate();

    return restTemplate.getForObject(RANDOM_JOKE_URL, Joke.class);
  }

  public Jeopardy getJeopardyQuestion() {
    RestTemplate restTemplate = new RestTemplate();

    Jeopardy[] results = restTemplate.getForObject("http://jservice.io/api/random", Jeopardy[].class);
    return results[0];
  }


}
