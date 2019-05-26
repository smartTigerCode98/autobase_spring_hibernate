package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.DriverService;

import java.util.Map;

@RestController
public class DriversController {

    @Autowired
    private DriverService driverService;

    @RequestMapping("/api/drivers")
    @GetMapping
    public ResponseEntity<String> getFreeDriversByAutoCriteria(@RequestParam Map<String, String> requestParams) {
        try {
            String driverInfo = driverService.findFreeDriversForNecessaryCarCriteria(requestParams.get("markaAuto"),
                    requestParams.get("bodyType"),
                    Integer.parseInt(requestParams.get("countOfSits")));
            System.out.println(driverInfo);
            return new ResponseEntity<>(driverInfo, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping("/api/drivers/{idDriver}")
    @GetMapping
    public ResponseEntity<String> getDriver(@PathVariable("idDriver") int idDriver){
        try {
            String driverInfo = driverService.findDriver(idDriver);
             return new ResponseEntity<>(driverInfo, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }

    }
}
