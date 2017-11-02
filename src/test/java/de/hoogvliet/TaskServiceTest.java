package de.hoogvliet;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TaskServiceTest {
  private static final String EXPECTED_JOKE_URL = "https://08ad1pao69.execute-api.us-east-1.amazonaws.com/dev/random_joke";

  @Mock
  private RestTemplateProvider restTemplateProvider;

  @Mock
  private RestTemplate restTemplate;

  @InjectMocks
  private TaskService taskService;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void getJokeUsesRestTemplate() {
    when(restTemplateProvider.getRestTemplate()).thenReturn(restTemplate);
    taskService.getJoke();
    verify(restTemplateProvider).getRestTemplate();
  }

  @Test
  public void getJokeUsesCorrectUrlAndJokeClass() {
    when(restTemplateProvider.getRestTemplate()).thenReturn(restTemplate);
    taskService.getJoke();
    verify(restTemplate).getForObject(EXPECTED_JOKE_URL, Joke.class);
  }

}