package dataproviders;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Flight;
import models.FlightsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;

public class FlightsDataProvider {
    private ExecutorService executorService;

    public FlightsDataProvider() {
        this.executorService = Executors.newCachedThreadPool();
    }

    public Future<List<Flight>> listFlights() {

      Callable<List<Flight>> listFlightCallable = new Callable<List<Flight>>() {
          @Override
          public List<Flight> call() throws Exception {
              RestTemplate restTemplate = new RestTemplate();
                // Hi This is Pooja Payal.
              ResponseEntity<String> response = restTemplate.getForEntity(
                      "",
                      String.class);

              ObjectMapper objectMapper = new ObjectMapper();
              FlightsResponse flightsResponse = objectMapper.readValue(response.getBody(), FlightsResponse.class);
              return flightsResponse.getFlights();
          }
      };

      return this.executorService.submit(listFlightCallable);
    }
}
