package opensource.onlinestore.service;

import opensource.onlinestore.Utils.Exception.NotFoundException;
import opensource.onlinestore.model.dto.UserTo;
import opensource.onlinestore.model.entity.User;

import java.util.Collection;

/**
 * Created by maks(avto12@i.ua) on 24.01.2016.
 */
public interface UserService {

    User save(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    Collection<User> getAll();

    void update(UserTo user);

    void update(User user);

    void enable(int id, boolean enable);

    User getWithOrders(int id);
}
