package opensource.onlinestore.model.entity;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {

    @Id
    private Long id;

    public BaseEntity() {
    }

    protected BaseEntity(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isNew() {
        return id == null;
    }
}
