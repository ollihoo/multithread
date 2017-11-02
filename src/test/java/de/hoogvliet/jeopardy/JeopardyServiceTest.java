package de.hoogvliet.jeopardy;

import de.hoogvliet.Jeopardy;
import de.hoogvliet.RestTemplateProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class JeopardyServiceTest {
  private static final Jeopardy ANY_JEOPARDY = new Jeopardy();
  private static final Jeopardy[] ANY_JEOPARDIES = { ANY_JEOPARDY };

  @Mock
  private RestTemplateProvider restTemplateProvider;

  @Mock
  private RestTemplate restTemplate;

  @InjectMocks
  private JeopardyService jeopardyService;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void getQuestionUsesRestTemplateProvider() {
    when(restTemplateProvider.getRestTemplate()).thenReturn(restTemplate);
    when(restTemplate.getForObject(anyString(), any())).thenReturn(ANY_JEOPARDIES);

    jeopardyService.getQuestion();
    verify(restTemplateProvider).getRestTemplate();
  }

  @Test
  public void getQuestionUsesJeopardyAPI() {
    when(restTemplateProvider.getRestTemplate()).thenReturn(restTemplate);
    when(restTemplate.getForObject(anyString(), any())).thenReturn(ANY_JEOPARDIES);

    jeopardyService.getQuestion();
    verify(restTemplate).getForObject("http://jservice.io/api/random", Jeopardy[].class);
  }

  @Test
  public void getQuestionReturnsOneJeopardy() {
    when(restTemplateProvider.getRestTemplate()).thenReturn(restTemplate);
    when(restTemplate.getForObject(anyString(), any())).thenReturn(ANY_JEOPARDIES);
    Jeopardy actualJeopardy = jeopardyService.getQuestion();
    assertEquals(ANY_JEOPARDY, actualJeopardy);
  }


}