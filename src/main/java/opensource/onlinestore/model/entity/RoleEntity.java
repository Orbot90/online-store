package opensource.onlinestore.model.entity;

import opensource.onlinestore.model.Role;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by malex on 27.01.16.
 */

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

    @NotNull
    @Column(name = "name", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
    private List<UserEntity> users;

    public RoleEntity() {
    }

    public Role getName() {
        return name;
    }

    public void setName(Role name) {
        this.name = name;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (name != that.name) return false;
        return users != null ? users.equals(that.users) : that.users == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (users != null ? users.hashCode() : 0);
        return result;
    }
}
