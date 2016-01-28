package opensource.onlinestore.model.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by maks(avto12@i.ua) on 26.01.2016.
 */

public enum Role implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN,
    CONTENT_MANGER,
    SUPPORT;

    @Override
    public String getAuthority() {
        return name();
    }

}
