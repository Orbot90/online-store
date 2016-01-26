package opensource.onlinestore.service;

import opensource.onlinestore.config.JPAConfigTest;
import opensource.onlinestore.model.entity.Role;
import opensource.onlinestore.model.entity.UserEntity;
import opensource.onlinestore.service.entityUtil.UserEntityUtil;
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
public class UserServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private UserService service;

    @Test
    @Rollback
    public void testCreate() {
        // given
        UserEntity expectUser = new UserEntity();
        expectUser.setName("WwW");
        expectUser.setPassword("654321");
        expectUser.setEmail("xxx@xxxxx.xxx");
        expectUser.setRole(Role.ROLE_ADMIN);
        expectUser.setRegistered(new Date());

        // when
        UserEntity actualUser = service.create(expectUser);

        //then
        assertNotNull(actualUser);
        assertEquals(expectUser, actualUser);
    }

    @Test
    @Rollback
    public void testUpdate() {
        // given
        UserEntity expectEntity = new UserEntity();
        expectEntity.setName("WwW");
        expectEntity.setPassword("654321");
        expectEntity.setEmail("xxx@xxxxx.xxx");
        expectEntity.setRole(Role.ROLE_ADMIN);
        expectEntity.setRegistered(new Date());

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
