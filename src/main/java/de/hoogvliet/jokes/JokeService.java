package de.hoogvliet.jokes;

import de.hoogvliet.Joke;
import de.hoogvliet.RestTemplateProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {
  private static final String RANDOM_JOKE_URL = "https://08ad1pao69.execute-api.us-east-1.amazonaws.com/dev/random_joke";

  @Autowired
  private RestTemplateProvider restTemplateProvider;


  public Joke getJoke() {
    RestTemplate restTemplate = restTemplateProvider.getRestTemplate();
    return restTemplate.getForObject(RANDOM_JOKE_URL, Joke.class);
  }
}
