package opensource.onlinestore.model.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by Alexei Huryanchyk
 */
public class OrderEntity {
    private Long id;
    private UserEntity user;
    private List<GoodsEntity> goods;
    private Date startDate;
//    private DeliveryType deliveryType;
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
