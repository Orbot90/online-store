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

    @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY)
    private List<GoodsEntity> goodsEntities;

    @Column(name = "creationDate", columnDefinition = "timestamp default now()")
    private Date creationDate=new Date();

    //String paymentType;
    //String deliveryType;

    @Column(name = "isNew")
    private boolean isNew;

    @Column(name = "isCompleted")
    private boolean isCompleted;
}
