package opensource.onlinestore.service.impl;

import opensource.onlinestore.model.entity.UserEntity;
import opensource.onlinestore.repository.UserRepository;
import opensource.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by malex on 28.01.16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserEntity create(UserEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public UserEntity update(UserEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public UserEntity findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return repository.findAll();
    }
}
