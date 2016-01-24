package opensource.onlinestore.Utils;

import opensource.onlinestore.model.dto.UserTo;
import opensource.onlinestore.model.entity.User;

/**
 * Created by maks(avto12@i.ua) on 24.01.2016.
 */
public class UserUtils {

    public static UserTo asTo(User user) {
        return new UserTo(user.getId(), user.getName(), user.getEmail(), user.getPassword());
    }

    public static User updateFromTo(User user, UserTo userTo) {
        user.setName(userTo.getName());
        user.setEmail(userTo.getEmail());
        user.setPassword(userTo.getPassword());
        return prepareToSave(user);
    }

    public static User prepareToSave(User user) {
        user.setPassword(PasswordUtil.encode(user.getPassword()));
        user.setEmail(user.getEmail().toLowerCase());
        return user;
    }
}
