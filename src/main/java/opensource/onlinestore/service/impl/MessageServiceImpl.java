package opensource.onlinestore.service.impl;

import opensource.onlinestore.model.entity.MessageEntity;
import opensource.onlinestore.repository.MessageRepository;
import opensource.onlinestore.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by malex on 28.01.16.
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository repository;

    @Override
    public MessageEntity create(MessageEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public MessageEntity update(MessageEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public MessageEntity findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<MessageEntity> findAll() {
        return repository.findAll();
    }
}
