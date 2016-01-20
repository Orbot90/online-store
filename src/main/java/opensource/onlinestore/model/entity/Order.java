package opensource.onlinestore.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by maks(avto12@i.ua) on 19.01.2016.
 */

@Entity
@Table(name = "orders")
public class Order extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="orders_goods", joinColumns=@JoinColumn(name="orders_id"), inverseJoinColumns=@JoinColumn(name="goods_id"))
    private List<GoodsEntity> goodsEntities;

    @Column(name = "creationDate", columnDefinition = "timestamp default now()")
    private Date creationDate=new Date();

    //String paymentType;
    //String deliveryType;

    @Column(name = "newOrder")
    private boolean newOrder;

    @Column(name = "Completed")
    private boolean Completed;

    public Order(){}

    public Order(User user, List<GoodsEntity> goodsEntities, Date creationDate, boolean newOrder, boolean completed) {
        this.user = user;
        this.goodsEntities = goodsEntities;
        this.creationDate = creationDate;
        this.newOrder = newOrder;
        Completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<GoodsEntity> getGoodsEntities() {
        return goodsEntities;
    }

    public void setGoodsEntities(List<GoodsEntity> goodsEntities) {
        this.goodsEntities = goodsEntities;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isNewOrder() {
        return newOrder;
    }

    public void setNewOrder(boolean newOrder) {
        this.newOrder = newOrder;
    }

    public boolean isCompleted() {
        return Completed;
    }

    public void setCompleted(boolean completed) {
        Completed = completed;
    }
}
