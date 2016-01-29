package opensource.onlinestore.model;

/**
 * Created by malex on 27.01.16.
 */

import org.springframework.security.core.GrantedAuthority;

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
