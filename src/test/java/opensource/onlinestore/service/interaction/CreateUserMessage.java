package opensource.onlinestore.service.interaction;

import opensource.onlinestore.config.JPAConfigTest;
import opensource.onlinestore.model.MessageType;
import opensource.onlinestore.model.entity.MessageEntity;
import opensource.onlinestore.model.entity.UserEntity;
import opensource.onlinestore.model.util.MessageEntityUtil;
import opensource.onlinestore.model.util.UserEntityUtil;
import opensource.onlinestore.service.GoodsService;
import opensource.onlinestore.service.MessageService;
import opensource.onlinestore.service.UserService;
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

import java.util.LinkedList;
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
public class CreateUserMessage extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private GoodsService goodsService;

    @Test
    @Rollback
    public void testCreateUserMessage() {
        // given
        //1. Create user
        UserEntity expectUser = userService.create(UserEntityUtil.createUser());

        //2. Create message
        MessageEntity expectMessageEntity = MessageEntityUtil.createMessageEntity();
        expectMessageEntity.setMessage("Самый крутой телефон. Всем советую!!!");

        //2.1. Add user to message
        expectMessageEntity.setUser(expectUser);

        // when
        MessageEntity actualMessageEntity = messageService.create(expectMessageEntity);

        //then
        assertNotNull(actualMessageEntity);
        assertEquals(expectMessageEntity, actualMessageEntity);
    }

    @Test
    @Rollback
    public void testCreateUserMessages() {
        // given
        //1. Create user
        UserEntity user = userService.create(UserEntityUtil.createUser());

        //2. Create message
        MessageEntity message_01 = new MessageEntity();
        message_01.setMessageType(MessageType.OPINION);
        message_01.setMessage("Самый крутой телефон. Всем советую!!!");

        MessageEntity message_02 = new MessageEntity();
        message_02.setMessageType(MessageType.OPINION);
        message_02.setMessage("Хреновы телефон!!!!!!!!!!");

        MessageEntity message_03 = new MessageEntity();
        message_03.setMessageType(MessageType.SUPPORT);
        message_03.setMessage("Телефон сгорел сегодня!!! Срочно нужен номер сервисного центра!");


        //2.1. Add user to message
        message_01.setUser(user);
        message_02.setUser(user);
        message_03.setUser(user);

        //2.2. write message to db
        messageService.create(message_01);
        messageService.create(message_02);
        messageService.create(message_03);

        List<MessageEntity> expectMessageList = new LinkedList<>();
        expectMessageList.add(message_01);
        expectMessageList.add(message_02);
        expectMessageList.add(message_03);

        // when
        List<MessageEntity> actualMessageList = messageService.findAll();


        //then
        assertNotNull(actualMessageList);
        assertFalse(actualMessageList.isEmpty());
        System.err.println(actualMessageList);
        assertEquals(expectMessageList, actualMessageList);
    }


    @Test
    @Rollback(value = false)
    public void testCreateUserAfterDeleteMessage() {
        // given
        //1. Create user
        UserEntity expectUser = userService.create(UserEntityUtil.createUser());

        //2. Create message
        MessageEntity expectMessageEntity = MessageEntityUtil.createMessageEntity();
        expectMessageEntity.setMessage("Самый крутой телефон. Всем советую!!!");

        //2.1. Add user to message
        expectMessageEntity.setUser(expectUser);
        MessageEntity messageEntity = messageService.create(expectMessageEntity);

        // when
        //3. Write message to db
        MessageEntity actualMessageEntity = messageService.create(expectMessageEntity);

        //3.1 delete message
        messageService.delete(actualMessageEntity.getId());


        //then
        //4.1 get user
        UserEntity actualUser = userService.findById(expectUser.getId());
        assertNotNull(actualUser);
        assertEquals(expectUser, actualUser);

        //4.2 get message
        List<MessageEntity> messageServices = messageService.findAll();
        assertTrue(messageServices.isEmpty());
    }
}
