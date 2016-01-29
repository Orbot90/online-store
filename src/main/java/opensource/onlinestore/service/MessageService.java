package opensource.onlinestore.service;

import opensource.onlinestore.model.entity.MessageEntity;

import java.util.List;

/**
 * Created by malex on 28.01.16.
 */

public interface MessageService {

    MessageEntity create(MessageEntity entity);

    MessageEntity update(MessageEntity entity);

    void delete(Long id);

    MessageEntity findById(Long id);

    List<MessageEntity> findAll();
}
