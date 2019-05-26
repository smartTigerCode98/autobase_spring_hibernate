package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.CarsEntity;
import entity.DriversEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CarRepository;
import repository.DriverRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private CarRepository carRepository;

    public String findFreeDriversForNecessaryCarCriteria(String markaAuto, String bodyType, int countOfSits) throws JsonProcessingException {
        String driversInfo = "";
        ArrayList<DriversEntity> driversEntities = new ArrayList<>();
        ArrayList<CarsEntity> carsEntities = carRepository.findCarsEntitiesByMarkaAndTypeAndNumberOfSeatsAndIsBrokeIsFalse(markaAuto, bodyType, countOfSits);
        if(carsEntities.size() > 0){
            for(CarsEntity carsEntity: carsEntities){
                DriversEntity driversEntity = driverRepository.findByIdCar(carsEntity.getId());
                if(driversEntity != null){
                    if(driversEntity.getIsFree()){
                        driversEntities.add(driversEntity);
                    }
                }
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        driversInfo = objectMapper.writeValueAsString(driversEntities);

        return driversInfo;
    }

    public String findDriver(int idDriver) throws JsonProcessingException {
        DriversEntity driversEntity = driverRepository.findById(idDriver);
        String driverInfo = "";
        ObjectMapper objectMapper = new ObjectMapper();
        driverInfo = objectMapper.writeValueAsString(driversEntity);
        return driverInfo;
    }
}
