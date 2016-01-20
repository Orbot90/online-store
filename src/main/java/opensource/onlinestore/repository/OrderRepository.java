package opensource.onlinestore.repository;

import opensource.onlinestore.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by maks(avto12@i.ua) on 21.01.2016.
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
