package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CarService;

import java.util.Map;

@RestController
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    private CarService carService;

    @PutMapping
    public void updateStatusCar(@RequestParam Map<String, String> requestParams){
        carService.updateStatusCar(Integer.parseInt(requestParams.get("idCar")), Boolean.parseBoolean(requestParams.get("statusCar")));
    }
}
