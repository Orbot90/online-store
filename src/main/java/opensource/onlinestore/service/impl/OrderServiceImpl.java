package opensource.onlinestore.service.impl;

import opensource.onlinestore.model.entity.OrderEntity;
import opensource.onlinestore.repository.OrderRepository;
import opensource.onlinestore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by malex on 26.01.16.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public OrderEntity create(OrderEntity orderEntity) {
        return repository.saveAndFlush(orderEntity);
    }

    @Override
    public OrderEntity update(OrderEntity orderEntity) {
        return repository.saveAndFlush(orderEntity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public OrderEntity findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<OrderEntity> findAll() {
        return repository.findAll();
    }
}
