package repository;

import entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface OrderRepository extends JpaRepository<OrdersEntity, Integer> {

    public ArrayList<OrdersEntity> findOrdersEntitiesByProcessedIsFalse();
    public OrdersEntity findById(int id);
}
