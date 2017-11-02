package de.hoogvliet;


import de.hoogvliet.jeopardy.JeopardyService;
import de.hoogvliet.jokes.JokeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TaskServiceTest {
  private static final Joke ANY_JOKE = new Joke();
  private static final Jeopardy ANY_JEOPARDY = new Jeopardy();

  @Mock
  private RestTemplateProvider restTemplateProvider;

  @Mock
  private RestTemplate restTemplate;

  @Mock
  private JokeService jokeService;

  @Mock
  private JeopardyService jeopardyService;


  @InjectMocks
  private TaskService taskService;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void doTaskUsesJokeService() {
    taskService.doTask();
    verify(jokeService).getJoke();
  }

  @Test
  public void doTaskUsesJeopardyService() {
    taskService.doTask();
    verify(jeopardyService).getQuestion();
  }

  @Test
  public void doTaskReturnsMapWithTwoServiceResponses() {
    when(jokeService.getJoke()).thenReturn(ANY_JOKE);
    when(jeopardyService.getQuestion()).thenReturn(ANY_JEOPARDY);
    Map<String, Object> actualResponse = taskService.doTask();
    assertEquals(ANY_JEOPARDY, actualResponse.get("jeopardy"));
    assertEquals(ANY_JOKE, actualResponse.get("joke"));
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