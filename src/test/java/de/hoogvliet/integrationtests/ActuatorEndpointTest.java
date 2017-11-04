package de.hoogvliet.integrationtests;

import de.hoogvliet.IntegrationTest;
import org.json.simple.parser.JSONParser;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
@Category(IntegrationTest.class)
public class ActuatorEndpointTest {

    private RestTemplate restClient;

    @Before
    public void setup() {
        restClient = new RestTemplate();
    }

    @Test
    public void jolokia_endpoint_is_present_and_answers_with_json() throws Exception {
        ResponseEntity<String> response = restClient.getForEntity("http://localhost:8080/jolokia", String.class);
        JSONParser jsonParser = new JSONParser();
        jsonParser.parse(response.getBody());
    }

}
