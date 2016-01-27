package opensource.onlinestore.Utils;

import opensource.onlinestore.model.dto.UserTo;
import opensource.onlinestore.model.entity.UserEntity;

/**
 * Created by maks(avto12@i.ua) on 27.01.2016.
 */
public class UserUtils {
    public static UserTo asTo(UserEntity user) {
        return new UserTo(user.getId(), user.getUserName(), user.getFirtstName(), user.getLastName(),
                user.getEmail(), user.getPassword());
    }

    public static UserEntity updateFromTo(UserEntity user, UserTo userTo) {
        user.setUserName(userTo.getUsername());
        user.setEmail(userTo.getEmail());
        user.setPassword(userTo.getPassword());
        return prepareToSave(user);
    }

    public static UserEntity prepareToSave(UserEntity user) {
        user.setPassword(PasswordUtil.encode(user.getPassword()));
        user.setEmail(user.getEmail().toLowerCase());
        return user;
    }
}
