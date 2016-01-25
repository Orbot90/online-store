package opensource.onlinestore.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by malex on 25.01.16.
 */
@Entity
@Table(name = "orders")
public class OrderEntity {

    @NotNull
    @Column(name = "data_create", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @NotNull
    @Column(name = "is_new", nullable = false)
    private boolean isNew;

    @NotNull
    @Column(name = "completed", nullable = false)
    private boolean completed;

    @Transient
    private UserEntity user;

    @Transient
    private List<GoodsEntity> entityList;

    public OrderEntity() {
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<GoodsEntity> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<GoodsEntity> entityList) {
        this.entityList = entityList;
    }
}
