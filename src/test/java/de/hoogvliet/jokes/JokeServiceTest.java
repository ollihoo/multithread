package de.hoogvliet.jokes;

import de.hoogvliet.RestTemplateProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JokeServiceTest {
    private static final String EXPECTED_JOKE_URL =
            "https://08ad1pao69.execute-api.us-east-1.amazonaws.com/dev/random_joke";
    private static final Joke ANY_JOKE = new Joke();

    @Mock
    private RestTemplateProvider restTemplateProvider;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private JokeService jokeService;

    @Test
    public void getJokeUsesRestTemplate() throws JokeException {
        when(restTemplateProvider.getRestTemplate()).thenReturn(restTemplate);

        jokeService.getJoke();
        verify(restTemplateProvider).getRestTemplate();
    }

    @Test
    public void getJokeUsesCorrectUrlAndJokeClass() throws JokeException {
        when(restTemplateProvider.getRestTemplate()).thenReturn(restTemplate);

        jokeService.getJoke();
        verify(restTemplate).getForObject(EXPECTED_JOKE_URL, Joke.class);
    }

    @Test
    public void getJokeReturnsOneJoke() throws JokeException {
        when(restTemplateProvider.getRestTemplate()).thenReturn(restTemplate);
        when(restTemplate.getForObject(anyString(), any())).thenReturn(ANY_JOKE);

        Joke actualJoke = jokeService.getJoke();
        assertEquals(ANY_JOKE, actualJoke);
    }

    @Test(expected = JokeException.class)
    public void whenJokeServiceForbidsAccessAJokeExceptionIsThrown () throws JokeException {
        when(restTemplateProvider.getRestTemplate()).thenReturn(restTemplate);
        when(restTemplate.getForObject(anyString(), any())).thenThrow(new HttpClientErrorException(HttpStatus.FORBIDDEN));

        jokeService.getJoke();
    }
}