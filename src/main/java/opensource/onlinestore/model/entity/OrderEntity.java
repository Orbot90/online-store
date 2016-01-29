package opensource.onlinestore.model.entity;

import opensource.onlinestore.model.DeliveryType;
import opensource.onlinestore.model.OrderStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by malex on 27.01.16.
 */

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "goods_orders",
            joinColumns = @JoinColumn(name = "goods_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "orders_id", referencedColumnName = "id"))
    @OrderBy("creationDate ASC")
    private List<GoodsEntity> goods;

    @NotNull
    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date start_date;


    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_type", nullable = false)
    private DeliveryType delivery_type;

    @Column(name = "address")
    private String address;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private OrderStatus order_status;

    public OrderEntity() {
    }

    public List<GoodsEntity> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsEntity> goods) {
        this.goods = goods;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public DeliveryType getDelivery_type() {
        return delivery_type;
    }

    public void setDelivery_type(DeliveryType delivery_type) {
        this.delivery_type = delivery_type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public OrderStatus getOrder_status() {
        return order_status;
    }

    public void setOrder_status(OrderStatus order_status) {
        this.order_status = order_status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity entity = (OrderEntity) o;

        if (goods != null ? !goods.equals(entity.goods) : entity.goods != null) return false;
        if (start_date != null ? !start_date.equals(entity.start_date) : entity.start_date != null) return false;
        if (delivery_type != entity.delivery_type) return false;
        if (address != null ? !address.equals(entity.address) : entity.address != null) return false;
        return order_status == entity.order_status;

    }

    @Override
    public int hashCode() {
        int result = goods != null ? goods.hashCode() : 0;
        result = 31 * result + (start_date != null ? start_date.hashCode() : 0);
        result = 31 * result + (delivery_type != null ? delivery_type.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (order_status != null ? order_status.hashCode() : 0);
        return result;
    }

}
