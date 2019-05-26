package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import entity.FlightsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.FlightService;

import java.util.Map;

@RestController
public class FlightController {

    @Autowired
    private FlightService flightService;

    @RequestMapping("/api/flight")
    @PostMapping
    public boolean createFlight(@RequestParam Map<String, String> requestParams){
       return flightService.createFlight(Integer.parseInt(requestParams.get("idOrder")),
                Integer.parseInt(requestParams.get("idDriver")));
    }


    @RequestMapping(value = "/api/flight/{idDriver}", method = RequestMethod.GET)
    public ResponseEntity<String> getFlightForDriver(@PathVariable("idDriver") int idDriver) {
        try {
            String flightInfo = flightService.findFlightForDriver(idDriver);
            return new ResponseEntity<>(flightInfo, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/api/flight/{idFlight}", method = RequestMethod.PUT)
    public void updateStatusFlight(@RequestParam Map<String, String> requestParams, @PathVariable("idFlight") int idFlight){
        flightService.updateStatusFlightAndStatusDriver(idFlight,
                Integer.parseInt(requestParams.get("idDriver")),
                        Boolean.parseBoolean(requestParams.get("statusFlight")));

    }

}
