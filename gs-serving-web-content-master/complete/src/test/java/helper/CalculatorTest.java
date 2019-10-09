package helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Flight;
import models.FlightsResponse;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void testAdd() {
        String str = "{ \"airline\": \"Air India\", \"flightNumber\": \"AI123\"}";
        ObjectMapper om = new ObjectMapper();
        try {
            Flight f = om.readValue(str, Flight.class);

            String serializedStr = om.writeValueAsString(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
