package opensource.onlinestore.service.logic;

import opensource.onlinestore.config.JPAConfigTest;
import opensource.onlinestore.model.DeliveryType;
import opensource.onlinestore.model.OrderStatus;
import opensource.onlinestore.model.entity.OrderEntity;
import opensource.onlinestore.service.OrdersService;
import opensource.onlinestore.model.util.OrderEntityUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by malex on 26.01.16.
 */

@ActiveProfiles("test")
@DirtiesContext
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAConfigTest.class})
public class OrderServiceImplLogicTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private OrdersService service;

    @Test
    @Rollback
    public void testCreate() {
        // given
        OrderEntity expectEntity = new OrderEntity();
        expectEntity.setAddress("Улица №201");
        expectEntity.setDelivery_type(DeliveryType.COURIER);
        expectEntity.setOrder_status(OrderStatus.BUCKET);
        expectEntity.setStart_date(new Date());
        expectEntity.setGoods(null);

        // when
        OrderEntity actualEntity = service.create(expectEntity);

        //then
        assertNotNull(actualEntity);
        assertEquals(expectEntity, actualEntity);
    }

    @Test
    @Rollback
    public void testUpdate() {
        // given
        OrderEntity expectEntity = new OrderEntity();
        expectEntity.setAddress("Улица №201");
        expectEntity.setDelivery_type(DeliveryType.COURIER);
        expectEntity.setOrder_status(OrderStatus.BUCKET);
        expectEntity.setStart_date(new Date());
        expectEntity.setGoods(null);

        // when
        OrderEntity actualEntity = service.update(expectEntity);

        //then
        assertNotNull(actualEntity);
        assertEquals(expectEntity, actualEntity);
    }

    @Test
    @Rollback
    public void testDelete() {
        // given
        OrderEntity expectEntity = service.create(OrderEntityUtil.createOrderEntity());

        // when
        service.delete(expectEntity.getId());

        //then
        assertTrue(service.findAll().isEmpty());
    }

    @Test
    @Rollback
    public void testFindById() {
        // given
        OrderEntity expectEntity = service.create(OrderEntityUtil.createOrderEntity());

        // when
        OrderEntity actualEntity = service.findById(expectEntity.getId());


        //then
        assertNotNull(actualEntity);
        assertEquals(expectEntity, actualEntity);
    }

    @Test
    @Rollback
    public void testFindAll() {
        // given
        List<OrderEntity> expectEntityList = OrderEntityUtil.createOrderEntitys();
        for (OrderEntity entity : expectEntityList) {
            service.create(entity);
        }

        // when
        List<OrderEntity> actualEntityList = service.findAll();

        // then
        assertFalse(actualEntityList.isEmpty());
        assertEquals(expectEntityList, expectEntityList);
    }
}
