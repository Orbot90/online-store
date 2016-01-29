package opensource.onlinestore.service;

import opensource.onlinestore.model.entity.OrderEntity;

import java.util.List;

/**
 * Created by malex on 28.01.16.
 */
public interface OrdersService {

    OrderEntity create(OrderEntity entity);

    OrderEntity update(OrderEntity entity);

    void delete(Long id);

    OrderEntity findById(Long id);

    List<OrderEntity> findAll();

}
