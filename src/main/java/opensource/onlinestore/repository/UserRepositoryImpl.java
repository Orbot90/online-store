package opensource.onlinestore.repository;

import opensource.onlinestore.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maks(avto12@i.ua) on 21.01.2016.
 */
@Repository
public class UserRepositoryImpl{

    @Autowired
    UserRepository repository;

    private static final Sort SORT_NAME_EMAIL = new Sort("name", "email");

    public User save(User user) {
        return repository.save(user);
    }


    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }


    public User get(int id) {
        return repository.findOne(id);
    }


    public User getByEmail(String email) {
        return repository.getByEmail(email);
    }


    public List<User> getAll() {
        return repository.findAll(SORT_NAME_EMAIL);
    }


    public User getWithOrders(int id) {
        return repository.getWithOrders(id);
    }
}
