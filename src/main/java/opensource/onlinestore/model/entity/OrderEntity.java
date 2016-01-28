package opensource.onlinestore.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Alexei Huryanchyk
 */
@Entity
@Table(name="ORDER", uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})
public class OrderEntity implements Serializable{

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity user;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy="order")
    private List<GoodsEntity> goods;

    @Column(name="DATE")
    private Date startDate;
//    private DeliveryType deliveryType;

    @Column(name="ADDRESS")
    private String address;
//    private OrderStatus orderStatus;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<GoodsEntity> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsEntity> goods) {
        this.goods = goods;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

//    public DeliveryType getDeliveryType() {
//        return deliveryType;
//    }

//    public void setDeliveryType(DeliveryType deliveryType) {
//        this.deliveryType = deliveryType;
//    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public OrderStatus getOrderStatus() {
//        return orderStatus;
//    }

//    public void setOrderStatus(OrderStatus orderStatus) {
//        this.orderStatus = orderStatus;
//    }
}
