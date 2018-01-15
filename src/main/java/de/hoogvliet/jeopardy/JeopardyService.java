package de.hoogvliet.jeopardy;

import de.hoogvliet.RestTemplateProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JeopardyService {
  private static final String RANDOM_JEOPARDY_QUESTION_URL = "http://jservice.io/api/random";

  private final RestTemplateProvider restTemplateProvider;


  public JeopardyService(RestTemplateProvider restTemplateProvider) {
    this.restTemplateProvider = restTemplateProvider;
  }

  public Jeopardy getQuestion() {
    RestTemplate restTemplate = restTemplateProvider.getRestTemplate();
    Jeopardy[] results = restTemplate.getForObject(RANDOM_JEOPARDY_QUESTION_URL, Jeopardy[].class);
    return results[0];
  }


}
