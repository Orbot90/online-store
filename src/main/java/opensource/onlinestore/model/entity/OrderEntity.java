package opensource.onlinestore.model.entity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by maks(avto12@i.ua) on 26.01.2016.
 */


@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {

    @ManyToOne
    UserEntity user;
}
