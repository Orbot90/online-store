package opensource.onlinestore.model.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * Created by maks(avto12@i.ua) on 27.01.2016.
 */

@Entity
@Table(name = "accounts")
public class AccountEntity extends BaseEntity{
    @OneToOne
    @JoinColumn(name="userId")
    UserEntity user;
}
