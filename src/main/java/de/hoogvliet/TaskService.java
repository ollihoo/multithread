package de.hoogvliet;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TaskService {

  public String getJoke() {
    String jokeUrl = "https://08ad1pao69.execute-api.us-east-1.amazonaws.com/dev/random_joke";
    RestTemplate restTemplate = new RestTemplate();

    ResponseEntity<String> response = restTemplate.getForEntity(jokeUrl, String.class);
    return response.getBody();
  }

}
