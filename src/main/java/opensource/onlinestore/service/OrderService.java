package opensource.onlinestore.service;

import opensource.onlinestore.model.entity.OrderEntity;

import java.util.List;

/**
 * Created by malex on 26.01.16.
 */
public interface OrderService {

    OrderEntity create (OrderEntity orderEntity);

    OrderEntity update (OrderEntity orderEntity);

    void delete (Long id);

    OrderEntity findById(Long id);

    List<OrderEntity> findAll();
}
