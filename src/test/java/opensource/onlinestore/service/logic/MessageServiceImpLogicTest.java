package opensource.onlinestore.service.logic;

import opensource.onlinestore.config.JPAConfigTest;
import opensource.onlinestore.model.MessageType;
import opensource.onlinestore.model.entity.MessageEntity;
import opensource.onlinestore.service.MessageService;
import opensource.onlinestore.model.util.MessageEntityUtil;
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

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by malex on 29.01.16.
 */
@ActiveProfiles("test")
@DirtiesContext
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAConfigTest.class})
public class MessageServiceImpLogicTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private MessageService service;

    @Test
    @Rollback
    public void testCreate() {
        // given
        MessageEntity expectEntity = new MessageEntity();
        expectEntity.setMessage("Комитарий к заказу №333333333333333333333");
        expectEntity.setMessageType(MessageType.SUPPORT);

        // when
        MessageEntity actualEntity = service.create(expectEntity);

        //then
        assertNotNull(actualEntity);
        assertEquals(expectEntity, actualEntity);
    }

    @Test
    @Rollback
    public void testUpdate() {
        // given
        MessageEntity expectEntity = new MessageEntity();
        expectEntity.setMessage("Комитарий к заказу №000000000000111");
        expectEntity.setMessageType(MessageType.OPINION);

        // when
        MessageEntity actualEntity = service.update(expectEntity);

        //then
        assertNotNull(actualEntity);
        assertEquals(expectEntity, actualEntity);
    }

    @Test
    @Rollback
    public void testDelete() {
        // given
        MessageEntity expectEntity = service.create(MessageEntityUtil.createMessageEntity());

        // when
        service.delete(expectEntity.getId());

        //then
        assertTrue(service.findAll().isEmpty());
    }

    @Test
    @Rollback
    public void testFindById() {
        // given
        MessageEntity expectEntity = service.create(MessageEntityUtil.createMessageEntity());

        // when
        MessageEntity actualEntity = service.findById(expectEntity.getId());

        //then
        assertNotNull(actualEntity);
        assertEquals(expectEntity, actualEntity);
    }

    @Test
    @Rollback
    public void testFindAll() {
        // given
        List<MessageEntity> expectEntityList = MessageEntityUtil.createMessageEntityList();
        for (MessageEntity entity : expectEntityList) {
            service.create(entity);
        }

        // when
        List<MessageEntity> actualEntityList = service.findAll();

        // then
        assertFalse(actualEntityList.isEmpty());
        assertEquals(expectEntityList, expectEntityList);
    }

}
