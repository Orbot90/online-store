package opensource.onlinestore.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by maks(avto12@i.ua) on 19.01.2016.
 * basket for goods
 */
@Entity
@Table(name = "basket")
public class Basket extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "registered", columnDefinition = "timestamp default now()")
    private Date created;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="basket_goods", joinColumns=@JoinColumn(name="basket_id"), inverseJoinColumns=@JoinColumn(name="goods_id"))
    private List<GoodsEntity> goodsEntities;

    @Column(name = "cleared")
    private boolean cleared;

    public Basket(){}

    public Basket(User user, Date created, List<GoodsEntity> goodsEntities, boolean cleared) {
        this.user = user;
        this.created = created;
        this.goodsEntities = goodsEntities;
        this.cleared = cleared;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<GoodsEntity> getGoodsEntities() {
        return goodsEntities;
    }

    public void setGoodsEntities(List<GoodsEntity> goodsEntities) {
        this.goodsEntities = goodsEntities;
    }

    public boolean isCleared() {
        return cleared;
    }

    public void setCleared(boolean cleared) {
        this.cleared = cleared;
    }
}
