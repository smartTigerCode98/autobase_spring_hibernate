package repository;

import entity.CarsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CarRepository extends JpaRepository<CarsEntity, Integer> {
    ArrayList<CarsEntity> findCarsEntitiesByMarkaAndTypeAndNumberOfSeatsAndIsBrokeIsFalse(String markaAuto, String type, int countOfSeats);
    CarsEntity findCarsEntitiesById(int id);
}
