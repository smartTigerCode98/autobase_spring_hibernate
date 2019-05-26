package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.OrdersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.OrderRepository;

import java.util.ArrayList;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public String getUnprocessedOrders() throws JsonProcessingException {
        ArrayList<OrdersEntity> ordersEntities = orderRepository.findOrdersEntitiesByProcessedIsFalse();
        if(ordersEntities != null){
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(ordersEntities);
        }
        return "";
    }
}
