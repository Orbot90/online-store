package opensource.onlinestore.service;

import opensource.onlinestore.Utils.Exceptions.NotFoundException;
import opensource.onlinestore.model.entity.UserEntity;

import java.util.Collection;

/**
 * Created by maks(avto12@i.ua) on 27.01.2016.
 */
public interface UserService {

    UserEntity save(UserEntity user);

    void delete(int id) throws NotFoundException;

    UserEntity get(int id) throws NotFoundException;

    UserEntity getByEmail(String email) throws NotFoundException;

    Collection<UserEntity> getAll();

    void update(UserEntity user);

    UserEntity getWithOrders(int id);
}
