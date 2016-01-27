package opensource.onlinestore;

import opensource.onlinestore.Utils.UserUtils;
import opensource.onlinestore.model.dto.UserTo;
import opensource.onlinestore.model.entity.ActivityStatus;
import opensource.onlinestore.model.entity.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import static java.util.Objects.requireNonNull;

/**
 * Created by maks(avto12@i.ua) on 27.01.2016.
 */
public class LoggedUser extends org.springframework.security.core.userdetails.User {
    private UserTo userTo;

    public LoggedUser(UserEntity user) {
        super(user.getUserName(), user.getPassword(),true, true, true,
                (!user.getActivityStatus().equals(ActivityStatus.BANNED)), user.getRoles());
        this.userTo = UserUtils.asTo(user);
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

    public UserTo getUserTo() {
        return userTo;
    }

    public static long id() {
        return get().userTo.getId();
    }

    public void update(UserTo newTo) {
        userTo = newTo;
    }

    @Override
    public String toString() {
        return userTo.toString();
    }
}
