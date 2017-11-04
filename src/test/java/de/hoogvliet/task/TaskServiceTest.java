package de.hoogvliet.task;

import de.hoogvliet.jeopardy.Jeopardy;
import de.hoogvliet.jeopardy.JeopardyService;
import de.hoogvliet.jokes.Joke;
import de.hoogvliet.jokes.JokeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.actuate.metrics.GaugeService;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {
  private static final Joke ANY_JOKE = new Joke();
  private static final Jeopardy ANY_JEOPARDY = new Jeopardy();

  @Mock
  private JokeService jokeService;

  @Mock
  private JeopardyService jeopardyService;

  @Mock
  private GaugeService gaugeService;

  @InjectMocks
  private TaskService taskService;

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
  public void ensureThatDemonstrationMetricIsWritten() {
    taskService.doTask();
    verify(gaugeService).submit(eq("de.hoogvliet.task.doTask.duration"), anyDouble());
  }

}