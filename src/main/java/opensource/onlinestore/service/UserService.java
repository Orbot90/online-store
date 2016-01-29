package opensource.onlinestore.service;

import opensource.onlinestore.model.entity.UserEntity;

import java.util.List;

/**
 * Created by malex on 28.01.16.
 */

public interface UserService {

    UserEntity create(UserEntity entity);

    UserEntity update(UserEntity entity);

    void delete(Long id);

    UserEntity findById(Long id);

    List<UserEntity> findAll();

    // UserEntity getByEmail(String email)

    //UserEntity getWithOrders(int id);

}
