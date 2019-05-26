package repository;

import entity.DriversEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<DriversEntity, Integer> {
    public DriversEntity findByIdCar(int idCar);
    public DriversEntity findById(int id);
}
