package opensource.onlinestore.service;

import opensource.onlinestore.model.entity.UserEntity;

import java.util.List;

/**
 * Created by malex on 26.01.16.
 */
public interface UserService {

    UserEntity create(UserEntity userEntity);

    UserEntity update(UserEntity userEntity);

    void delete(Long id);

    UserEntity findById(Long id);

    List<UserEntity> findAll();
}
