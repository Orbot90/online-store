package opensource.onlinestore.model.util;

import opensource.onlinestore.model.DeliveryType;
import opensource.onlinestore.model.OrderStatus;
import opensource.onlinestore.model.entity.OrderEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by malex on 26.01.16.
 */
public class OrderEntityUtil {

    public static OrderEntity createOrderEntity() {
        OrderEntity entity = new OrderEntity();
        entity.setId(1L);
        entity.setAddress("Улица №201");
        entity.setDelivery_type(DeliveryType.COURIER);
        entity.setOrder_status(OrderStatus.BUCKET);
        entity.setStart_date(new Date());
        entity.setGoods(null);
        return entity;
    }

    public static List<OrderEntity> createOrderEntitys() {
        List<OrderEntity> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            OrderEntity entity = new OrderEntity();
            entity.setId(1L + i);
            entity.setAddress("Улица №201"+i);
            entity.setDelivery_type(DeliveryType.COURIER);
            entity.setOrder_status(OrderStatus.BUCKET);
            entity.setStart_date(new Date());
            entity.setGoods(null);
            list.add(entity);
        }
        return list;
    }


}
