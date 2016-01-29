package opensource.onlinestore.model.entity;

import opensource.onlinestore.model.ActivityStatus;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by malex on 27.01.16.
 */

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "unique_email"),
        @UniqueConstraint(columnNames = "username", name = "unique_username")})
public class UserEntity extends BaseEntity {

    @NotNull
    @Column(name = "username", nullable = false)
    private String username;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "registration_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date registration_date;

    @NotNull
    @Email
    @Column(name = "email", nullable = false)
    protected String email;

    @OneToMany
    @JoinTable(name = "users_orders",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"))
    @OrderBy("creationDate DESC")
    protected List<OrderEntity> orders;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    protected Set<RoleEntity> roles;

    @Transient
    protected byte[] avatar;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    protected AccountEntity account;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "user")
    @OrderBy("creationDate DESC")
    protected List<MessageEntity> messages;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "activity_status", nullable = false)
    protected ActivityStatus activity_status;

    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
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

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public List<MessageEntity> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageEntity> messages) {
        this.messages = messages;
    }

    public ActivityStatus getActivity_status() {
        return activity_status;
    }

    public void setActivity_status(ActivityStatus activity_status) {
        this.activity_status = activity_status;
    }

    @Override
    public boolean equals(Object o) {


        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity entity = (UserEntity) o;

        if (username != null ? !username.equals(entity.username) : entity.username != null) return false;
        if (password != null ? !password.equals(entity.password) : entity.password != null) return false;
        if (first_name != null ? !first_name.equals(entity.first_name) : entity.first_name != null) return false;
        if (last_name != null ? !last_name.equals(entity.last_name) : entity.last_name != null) return false;
        if (address != null ? !address.equals(entity.address) : entity.address != null) return false;
        if (registration_date != null ? !registration_date.equals(entity.registration_date) : entity.registration_date != null)
            return false;
        if (email != null ? !email.equals(entity.email) : entity.email != null) return false;
        if (orders != null ? !orders.equals(entity.orders) : entity.orders != null) return false;
        if (roles != null ? !roles.equals(entity.roles) : entity.roles != null) return false;
        if (!Arrays.equals(avatar, entity.avatar)) return false;
        if (account != null ? !account.equals(entity.account) : entity.account != null) return false;
        if (messages != null ? !messages.equals(entity.messages) : entity.messages != null) return false;
        if (activity_status != entity.activity_status) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (first_name != null ? first_name.hashCode() : 0);
        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (registration_date != null ? registration_date.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (orders != null ? orders.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(avatar);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (messages != null ? messages.hashCode() : 0);
        result = 31 * result + (activity_status != null ? activity_status.hashCode() : 0);
        return result;
    }

}
