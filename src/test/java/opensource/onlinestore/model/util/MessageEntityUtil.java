package opensource.onlinestore.model.util;

import opensource.onlinestore.model.MessageType;
import opensource.onlinestore.model.entity.MessageEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by malex on 29.01.16.
 */
public class MessageEntityUtil {

    public static MessageEntity createMessageEntity() {
        MessageEntity entity = new MessageEntity();
        entity.setId(1L);
        entity.setMessage("Комитарий к заказу №23");
        entity.setMessageType(MessageType.OPINION);
        return entity;
    }

    public static List<MessageEntity> createMessageEntityList(){
        List<MessageEntity> list =  new ArrayList<>();
        for (int i =0; i<10; i++){
            MessageEntity entity = new MessageEntity();
            entity.setId(1L+i);
            entity.setMessage("Комитарий к заказу №23"+i);
            entity.setMessageType(MessageType.OPINION);
            list.add(entity);
        }
        return list;
    }
}
