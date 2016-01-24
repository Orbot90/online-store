package opensource.onlinestore;


import opensource.onlinestore.Utils.UserUtils;
import opensource.onlinestore.model.dto.UserTo;
import opensource.onlinestore.model.entity.User;

/**
 * Created by maks(avto12@i.ua) on 24.01.2016.
 */
public class LoggedUser extends org.springframework.security.core.userdetails.User {

    private UserTo userTo;

    public LoggedUser(User user) {
        super(user.getName(), user.getPassword(), user.isEnabled(), user.isEnabled(), user.isEnabled(), user.isEnabled(), user.getRoles());
        this.userTo = UserUtils.asTo(user);
    }
}
