package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CarService;

import java.util.Map;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping("/api/cars/{idCar}")
    @PutMapping
    public void updateStatusCar(@PathVariable("idCar") int idCar, @RequestParam Map<String, String> requestParams){
        carService.updateStatusCar(idCar, Boolean.parseBoolean(requestParams.get("statusCar")));
    }
}
