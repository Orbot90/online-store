package opensource.onlinestore.service.logic;

import opensource.onlinestore.config.JPAConfigTest;
import opensource.onlinestore.model.ActivityStatus;
import opensource.onlinestore.model.entity.UserEntity;
import opensource.onlinestore.service.UserService;
import opensource.onlinestore.model.util.UserEntityUtil;
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
public class UserServiceImplLogicTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private UserService service;

    @Test
    @Rollback
    public void testCreate() {
        // given
        UserEntity expectEntity = new UserEntity();
        expectEntity.setUsername("UserName_E");
        expectEntity.setPassword("123456789");
        expectEntity.setFirst_name("NameFirst_E");
        expectEntity.setLast_name("NameLast_E");
        expectEntity.setAddress("Улица №2");
        expectEntity.setRegistration_date(new Date());
        expectEntity.setEmail("xxxx@xxxxxx.ru");
        expectEntity.setAccount(null);
        expectEntity.setActivity_status(ActivityStatus.SILENCE);
        expectEntity.setOrders(null);

        // when
        UserEntity actualUser = service.create(expectEntity);

        //then
        assertNotNull(actualUser);
        assertEquals(expectEntity, actualUser);
    }

    @Test
    @Rollback
    public void testUpdate() {
        // given
        UserEntity expectEntity = new UserEntity();
        expectEntity.setUsername("UserName_E");
        expectEntity.setPassword("123456789");
        expectEntity.setFirst_name("NameFirst_E");
        expectEntity.setLast_name("NameLast_E");
        expectEntity.setAddress("Улица №2");
        expectEntity.setRegistration_date(new Date());
        expectEntity.setEmail("xxxx@xxxxxx.ru");
        expectEntity.setAccount(null);
        expectEntity.setActivity_status(ActivityStatus.SILENCE);
        expectEntity.setOrders(null);

        // when
        UserEntity actualEntity = service.update(expectEntity);

        //then
        assertNotNull(actualEntity);
        assertEquals(expectEntity, actualEntity);
    }

    @Test
    @Rollback
    public void testDelete() {
        // given
        UserEntity expectEntity = service.create(UserEntityUtil.createUser());

        // when
        service.delete(expectEntity.getId());

        //then
        assertTrue(service.findAll().isEmpty());
    }

    @Test
    @Rollback
    public void testFindById() {
        // given
        UserEntity expectEntity = service.create(UserEntityUtil.createUser());

        // when
        UserEntity actualEntity = service.findById(expectEntity.getId());

        //then
        assertNotNull(actualEntity);
        assertEquals(expectEntity, actualEntity);
    }


    @Test
    @Rollback
    public void testFindAll() {
        // given
        List<UserEntity> expectEntityList = UserEntityUtil.createUsers();
        for (UserEntity entity : expectEntityList) {
            service.create(entity);
        }

        // when
        List<UserEntity> actualEntityList = service.findAll();

        // then
        assertFalse(actualEntityList.isEmpty());
        assertEquals(expectEntityList, expectEntityList);
    }
}
