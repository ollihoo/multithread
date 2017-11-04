package de.hoogvliet.integrationtests;

import de.hoogvliet.IntegrationTest;
import org.json.simple.parser.JSONParser;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
@Category(IntegrationTest.class)
public class ActuatorEndpointTest {
    private static String applicationPort;

    private String applicationUrl = "http://localhost:"+ applicationPort;
    private String jokoliaUrl = applicationUrl + "/jokolia";

    private RestTemplate restClient;

    @BeforeClass
    public static void beforeAll() {
        applicationPort = System.getProperty("test.server.port");
        if (applicationPort == null || "".equals(applicationPort)) {
            applicationPort = "8080";
        }
    }

    @Before
    public void setup() {
        restClient = new RestTemplate();

        System.out.println("Application Port: " + applicationPort);
    }

    @Test
    public void jolokia_endpoint_is_present_and_answers_with_json() throws Exception {
        ResponseEntity<String> response = restClient.getForEntity(jokoliaUrl, String.class);
        JSONParser jsonParser = new JSONParser();
        jsonParser.parse(response.getBody());
    }

}
