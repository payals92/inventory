package controller;

import dataproviders.FlightsDataProvider;
import models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class FlightsController {

    private FlightsDataProvider flightsDataProvider;

    @Autowired
    public FlightsController(FlightsDataProvider flightsDataProvider){
        this.flightsDataProvider = flightsDataProvider;
    }

    @GetMapping("/flights")
    public List<Flight> searchFlights() throws ExecutionException, InterruptedException {
       Future<List<Flight>> f1 = this.flightsDataProvider.listFlights();
       List<Flight> flights1 = f1.get();

       return  flights1;
    }
}
