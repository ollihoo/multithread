package de.hoogvliet;


import de.hoogvliet.jokes.JokeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TaskServiceTest {
  private static final String EXPECTED_JOKE_URL = "https://08ad1pao69.execute-api.us-east-1.amazonaws.com/dev/random_joke";
  private static final Joke ANY_JOKE = new Joke();

  @Mock
  private RestTemplateProvider restTemplateProvider;

  @Mock
  private RestTemplate restTemplate;

  @Mock
  private JokeService jokeService;

  @InjectMocks
  private TaskService taskService;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void getJokeUsesJokeService() {
    when(jokeService.getJoke()).thenReturn(ANY_JOKE);
    taskService.getJoke();
    verify(jokeService).getJoke();
  }

  @Test
  public void getJokeReturnsJoke() {
    when(jokeService.getJoke()).thenReturn(ANY_JOKE);
    Joke actualJoke = taskService.getJoke();
    assertEquals(ANY_JOKE, actualJoke);
  }

}