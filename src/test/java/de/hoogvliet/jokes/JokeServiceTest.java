package de.hoogvliet.jokes;

import de.hoogvliet.Joke;
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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class JokeServiceTest {
  private static final String EXPECTED_JOKE_URL = "https://08ad1pao69.execute-api.us-east-1.amazonaws.com/dev/random_joke";
  private static final Joke ANY_JOKE = new Joke();

  @Mock
  private RestTemplateProvider restTemplateProvider;

  @Mock
  private RestTemplate restTemplate;

  @InjectMocks
  private JokeService jokeService;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void getJokeUsesRestTemplate() {
    when(restTemplateProvider.getRestTemplate()).thenReturn(restTemplate);

    jokeService.getJoke();
    verify(restTemplateProvider).getRestTemplate();
  }

  @Test
  public void getJokeUsesCorrectUrlAndJokeClass() {
    when(restTemplateProvider.getRestTemplate()).thenReturn(restTemplate);

    jokeService.getJoke();
    verify(restTemplate).getForObject(EXPECTED_JOKE_URL, Joke.class);
  }

  @Test
  public void getJokeReturnsOneJoke() {
    when(restTemplateProvider.getRestTemplate()).thenReturn(restTemplate);
    when(restTemplate.getForObject(anyString(), any())).thenReturn(ANY_JOKE);

    Joke actualJoke = jokeService.getJoke();
    assertEquals(ANY_JOKE, actualJoke);
  }
}