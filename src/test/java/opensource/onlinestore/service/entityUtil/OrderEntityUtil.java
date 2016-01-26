package opensource.onlinestore.service.entityUtil;

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
        entity.setCompleted(true);
        entity.setDate(new Date());
        entity.setNew(false);
        return entity;
    }

    public static List<OrderEntity> createOrderEntitys() {
        List<OrderEntity> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            OrderEntity entity = new OrderEntity();
            entity.setId(1L + i);
            entity.setCompleted(boo(i));
            entity.setDate(new Date());
            entity.setNew(!boo(i));
            list.add(entity);
        }
        return list;
    }

    private static boolean boo(int i) {
        return i % 2 == 0;
    }
}
