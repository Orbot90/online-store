package opensource.onlinestore;

import opensource.onlinestore.model.dto.UserDTO;
import opensource.onlinestore.model.entity.ActivityStatus;
import opensource.onlinestore.model.entity.UserEntity;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import static java.util.Objects.requireNonNull;

/**
 * Created by maks(avto12@i.ua) on 27.01.2016.
 */
public class LoggedUser extends org.springframework.security.core.userdetails.User {
    private UserDTO userDTO;

    Mapper userMapper= DozerBeanMapperSingletonWrapper.getInstance();

    public LoggedUser(UserEntity user) {
        super(user.getUsername(), user.getPassword(),true, true, true,
                (!user.getActivityStatus().equals(ActivityStatus.BANNED)), user.getRoles());
        this.userDTO = userMapper.map(user,UserDTO.class);
    }

    public static LoggedUser safeGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object user = auth.getPrincipal();
        return (user instanceof LoggedUser) ? (LoggedUser) user : null;
    }

    public static LoggedUser get() {
        LoggedUser user = safeGet();
        requireNonNull(user, "No authorized user found");
        return user;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void update(UserDTO newTo) {
        userDTO = newTo;
    }

    @Override
    public String toString() {
        return userDTO.toString();
    }
}
