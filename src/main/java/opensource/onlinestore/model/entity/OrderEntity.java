package opensource.onlinestore.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by malex on 25.01.16.
 */
@Entity
@Table(name = "ORDERS")
public class OrderEntity extends BaseEntity {

    @NotNull
    @Column(name = "is_new", nullable = false)
    private boolean isNew;

    @NotNull
    @Column(name = "data_create", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @NotNull
    @Column(name = "completed", nullable = false)
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private UserEntity userEntity;

    // TODO need to implement -> MTM GoodsEntity
    @Transient
    private List<GoodsEntity> goodsEntities;

    public OrderEntity() {
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<GoodsEntity> getGoodsEntities() {
        return goodsEntities;
    }

    public void setGoodsEntities(List<GoodsEntity> goodsEntities) {
        this.goodsEntities = goodsEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        OrderEntity that = (OrderEntity) o;

        if (isNew != that.isNew) return false;
        if (completed != that.completed) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (userEntity != null ? !userEntity.equals(that.userEntity) : that.userEntity != null) return false;
        return goodsEntities != null ? goodsEntities.equals(that.goodsEntities) : that.goodsEntities == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (isNew ? 1 : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (completed ? 1 : 0);
        result = 31 * result + (userEntity != null ? userEntity.hashCode() : 0);
        result = 31 * result + (goodsEntities != null ? goodsEntities.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "isNew=" + isNew +
                ", date=" + date +
                ", completed=" + completed +
                (userEntity != null ? ", userEntity=" + userEntity : " ") +
                (goodsEntities != null ? ", goodsEntities=" + goodsEntities : " ") +
                '}';
    }
}
