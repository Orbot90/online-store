package opensource.onlinestore.service.impl;

import opensource.onlinestore.LoggedUser;
import opensource.onlinestore.Utils.Exceptions.NotFoundException;
import opensource.onlinestore.Utils.UserUtils;
import opensource.onlinestore.model.dto.UserTo;
import opensource.onlinestore.model.entity.UserEntity;
import opensource.onlinestore.repository.UserRepository;
import opensource.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Objects;

/**
 * Created by maks(avto12@i.ua) on 27.01.2016.
 */
@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public LoggedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity u = repository.getByEmail(email.toLowerCase());
        if (u == null) throw new UsernameNotFoundException("User " + email + " is not found");

        return new LoggedUser(u);
    }


    public UserEntity save(UserEntity user) {
        return repository.save(user);
    }


    public void delete(int id) throws NotFoundException {
        repository.delete(id);
    }


    public UserEntity get(int id) throws NotFoundException {
        return repository.getOne(id);
    }


    public UserEntity getByEmail(String email) throws NotFoundException {
        Objects.requireNonNull(email, "Email must not be empty");
        return repository.getByEmail(email);
    }


    public Collection<UserEntity> getAll() {
        return repository.findAll();
    }

    @Transactional
    public void update(UserTo userTo) {
        UserEntity user = get((int)userTo.getId());
        repository.save(UserUtils.updateFromTo(user, userTo));
    }

    @Transactional
    public void update(UserEntity user) {
        repository.save(user);
    }


    public UserEntity getWithOrders(int id) {
        return repository.getWithOrders(id);
    }
}


