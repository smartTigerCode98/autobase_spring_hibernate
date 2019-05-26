package repository;

import entity.FlightsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<FlightsEntity, Integer>{

    public FlightsEntity findFlightsEntitiesByIdDriverAndStatusIsFalse(int idDriver);
    public FlightsEntity findFlightsEntitiesById(int idFlight);
}
