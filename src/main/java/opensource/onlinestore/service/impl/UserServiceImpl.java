package opensource.onlinestore.service.impl;

import opensource.onlinestore.model.entity.UserEntity;
import opensource.onlinestore.repository.UserRepository;
import opensource.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by malex on 26.01.16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserEntity create(UserEntity userEntity) {
        return repository.saveAndFlush(userEntity);
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        return repository.saveAndFlush(userEntity);
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
