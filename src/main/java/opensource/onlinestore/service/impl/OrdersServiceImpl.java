package opensource.onlinestore.service.impl;

import opensource.onlinestore.model.entity.OrderEntity;
import opensource.onlinestore.repository.OrderRepository;
import opensource.onlinestore.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by malex on 28.01.16.
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrderRepository repository;

    @Override
    public OrderEntity create(OrderEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public OrderEntity update(OrderEntity entity) {
        return repository.saveAndFlush(entity);
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
