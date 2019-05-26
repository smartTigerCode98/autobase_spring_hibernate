package repository;

import entity.CarsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CarRepository extends JpaRepository<CarsEntity, Integer> {
    public ArrayList<CarsEntity> findCarsEntitiesByMarkaAndTypeAndNumberOfSeatsAndIsBrokeIsFalse(String markaAuto, String type, int countOfSeats);
    public CarsEntity findCarsEntitiesById(int id);
}
