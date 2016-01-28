package opensource.onlinestore.model.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.*;

/**
 * Created by maks(avto12@i.ua) on 24.01.2016.
 */

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "unique_email")})
public class UserEntity extends BaseEntity {

    @NotEmpty
    @Column(name = "name", nullable = false)
    protected String userName;

    @Column(name = "password", nullable = false)
    @NotEmpty
    protected String password;

    @NotEmpty
    @Column(name = "firtstName", nullable = false)
    protected String firtstName;

    @NotEmpty
    @Column(name = "lastName", nullable = false)
    protected String lastName;

    @NotEmpty
    @Column(name = "address")
    protected String address;

    @Column(name = "registered", columnDefinition = "timestamp default now()")
    protected Date registered = new Date();

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotEmpty
    protected String email;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "user")
    @OrderBy("creationDate DESC")
    protected List<OrderEntity> orders;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    protected Set<Role> roles;


    protected byte[] avatar;


    AccountEntity eAccount;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "user")
    @OrderBy("creationDate DESC")
    List<MessageEntity> opinions;

    @Enumerated(EnumType.STRING)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    ActivityStatus activityStatus;

    public UserEntity() {
    }

    public UserEntity(long id, String userName, String password, String firtstName, String lastName, String address, Date registered, String email, List<OrderEntity> orders, Set<Role> roles, byte[] avatar, AccountEntity eAccount, List<MessageEntity> opinions, ActivityStatus activityStatus) {
        super(id);
        this.userName = userName;
        this.password = password;
        this.firtstName = firtstName;
        this.lastName = lastName;
        this.address = address;
        this.registered = registered;
        this.email = email;
        this.orders = orders;
        this.roles = roles;
        this.avatar = avatar;
        this.eAccount = eAccount;
        this.opinions = opinions;
        this.activityStatus = activityStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirtstName() {
        return firtstName;
    }

    public void setFirtstName(String firtstName) {
        this.firtstName = firtstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public AccountEntity geteAccount() {
        return eAccount;
    }

    public void seteAccount(AccountEntity eAccount) {
        this.eAccount = eAccount;
    }

    public List<MessageEntity> getOpinions() {
        return opinions;
    }

    public void setOpinions(List<MessageEntity> opinions) {
        this.opinions = opinions;
    }

    public ActivityStatus getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(ActivityStatus activityStatus) {
        this.activityStatus = activityStatus;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = EnumSet.copyOf(roles);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;

        UserEntity that = (UserEntity) o;

        if (!getUserName().equals(that.getUserName())) return false;
        if (!getPassword().equals(that.getPassword())) return false;
        if (!getFirtstName().equals(that.getFirtstName())) return false;
        if (!getLastName().equals(that.getLastName())) return false;
        if (getAddress() != null ? !getAddress().equals(that.getAddress()) : that.getAddress() != null) return false;
        if (!getRegistered().equals(that.getRegistered())) return false;
        if (!getEmail().equals(that.getEmail())) return false;
        if (getOrders() != null ? !getOrders().equals(that.getOrders()) : that.getOrders() != null) return false;
        if (getRoles() != null ? !getRoles().equals(that.getRoles()) : that.getRoles() != null) return false;
        if (!Arrays.equals(getAvatar(), that.getAvatar())) return false;
        if (geteAccount() != null ? !geteAccount().equals(that.geteAccount()) : that.geteAccount() != null)
            return false;
        if (getOpinions() != null ? !getOpinions().equals(that.getOpinions()) : that.getOpinions() != null)
            return false;
        return getActivityStatus() == that.getActivityStatus();

    }

    @Override
    public int hashCode() {
        int result = getUserName().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getFirtstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + getRegistered().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + (getOrders() != null ? getOrders().hashCode() : 0);
        result = 31 * result + (getRoles() != null ? getRoles().hashCode() : 0);
        result = 31 * result + (getAvatar() != null ? Arrays.hashCode(getAvatar()) : 0);
        result = 31 * result + (geteAccount() != null ? geteAccount().hashCode() : 0);
        result = 31 * result + (getOpinions() != null ? getOpinions().hashCode() : 0);
        result = 31 * result + getActivityStatus().hashCode();
        return result;
    }
}

