package opensource.onlinestore.service.entityUtil;

import opensource.onlinestore.model.entity.Role;
import opensource.onlinestore.model.entity.UserEntity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by malex on 26.01.16.
 */
public class UserEntityUtil {

    public static UserEntity createUser() {
        UserEntity entity = new UserEntity();
        entity.setId(1L);
        entity.setName("Max");
        entity.setPassword("123456");
        entity.setEmail("www@emai.com");
        entity.setRole(Role.ROLE_USER);
        entity.setRegistered(new Date());
        return entity;
    }

    public static List<UserEntity> createUsers() {
        List<UserEntity> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            UserEntity entity = new UserEntity();
            entity.setId(1L + i);
            entity.setName("Max_" + i);
            entity.setPassword("000000_" + i);
            entity.setEmail("www@emai.com_" + i);
            entity.setRole(Role.ROLE_USER);
            entity.setRegistered(new Date());
            list.add(entity);
        }
        return list;
    }

}
