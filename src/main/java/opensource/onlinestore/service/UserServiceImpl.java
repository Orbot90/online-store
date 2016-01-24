package opensource.onlinestore.service;

import opensource.onlinestore.LoggedUser;
import opensource.onlinestore.Utils.Exception.NotFoundException;
import opensource.onlinestore.Utils.UserUtils;
import opensource.onlinestore.model.dto.UserTo;
import opensource.onlinestore.model.entity.User;
import opensource.onlinestore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Objects;

/**
 * Created by maks(avto12@i.ua) on 24.01.2016.
 */
@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public LoggedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User u =repository.getByEmail(email.toLowerCase());
        if(u==null) throw  new UsernameNotFoundException("User " + email + " is not found");

        return new LoggedUser(u);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        repository.delete(id);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return repository.getOne(id);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        Objects.requireNonNull(email, "Email must not be empty");
        return repository.getByEmail(email);
    }

    @Override
    public Collection<User> getAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public void update(UserTo userTo) {
        User user = get(userTo.getId());
        repository.save(UserUtils.updateFromTo(user, userTo));
    }

    @Transactional
    @Override
    public void update(User user) {
        repository.save(user);
    }

    @Override
    public void enable(int id, boolean enable) {
        User user=get(id);
        user.setEnabled(enable);
        repository.save(user);
    }

    @Override
    public User getWithOrders(int id) {
        return repository.getWithOrders(id);
    }




}
