package controller;

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

    @RequestMapping("/api/flights")
    @PostMapping
    public boolean createFlight(@RequestParam Map<String, String> requestParams){
       return flightService.createFlight(Integer.parseInt(requestParams.get("idOrder")),
                Integer.parseInt(requestParams.get("idDriver")));
    }


    @RequestMapping(value = "/api/flights/drivers/{idDriver}", method = RequestMethod.GET)
    public ResponseEntity<FlightsEntity> getFlightForDriver(@PathVariable("idDriver") int idDriver) {
            return new ResponseEntity<>(flightService.findFlightForDriver(idDriver), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/flights/{idFlight}", method = RequestMethod.PUT)
    public void updateStatusFlight(@RequestParam Map<String, String> requestParams, @PathVariable("idFlight") int idFlight){
        flightService.updateStatusFlightAndStatusDriver(idFlight,
                Integer.parseInt(requestParams.get("idDriver")),
                        Boolean.parseBoolean(requestParams.get("statusFlight")));

    }

}
