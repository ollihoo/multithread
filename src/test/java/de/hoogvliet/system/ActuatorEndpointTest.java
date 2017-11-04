package de.hoogvliet.system;

import org.json.simple.parser.JSONParser;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class ActuatorEndpointTest {

    private RestTemplate restClient;

    @Before
    public void setup() {
        restClient = new RestTemplate();
    }

    @Test @Ignore
    public void jolokia_endpoint_is_present_and_answers_with_json() throws Exception {
        ResponseEntity<String> response = restClient.getForEntity("http://localhost:8080/jolokia", String.class);
        JSONParser jsonParser = new JSONParser();
        jsonParser.parse(response.getBody());
    }

}
