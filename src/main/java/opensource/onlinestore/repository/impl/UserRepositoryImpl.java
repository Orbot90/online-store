package opensource.onlinestore.repository.impl;

import opensource.onlinestore.model.entity.UserEntity;
import opensource.onlinestore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maks(avto12@i.ua) on 27.01.2016.
 */
@Repository
public class UserRepositoryImpl {

    @Autowired
    UserRepository repository;

    private static final Sort SORT_NAME_EMAIL = new Sort("name", "email");

    public UserEntity save(UserEntity user) {
        return repository.save(user);
    }


    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }


    public UserEntity get(int id) {
        return repository.findOne(id);
    }


    public UserEntity getByEmail(String email) {
        return repository.getByEmail(email);
    }


    public List<UserEntity> getAll() {
        return repository.findAll(SORT_NAME_EMAIL);
    }


    public UserEntity getWithOrders(int id) {
        return repository.getWithOrders(id);
    }
}
