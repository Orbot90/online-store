package opensource.onlinestore.model.entity;

import opensource.onlinestore.model.MessageType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by malex on 28.01.16.
 */

@Entity
@Table(name = "messages")
public class MessageEntity extends BaseEntity {

    @NotNull
    @Column(name = "message", nullable = false)
    private String message;

    @NotNull
    @Column(name = "message_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private MessageType messageType;


    @ManyToOne(fetch = FetchType.EAGER)

    @JoinTable(name = "users_messages",
            joinColumns = @JoinColumn(name = "messages_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", unique = false))
    private UserEntity user;

    public MessageEntity() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity entity = (MessageEntity) o;

        if (message != null ? !message.equals(entity.message) : entity.message != null) return false;
        if (messageType != entity.messageType) return false;
        return user != null ? user.equals(entity.user) : entity.user == null;

    }

    @Override
    public int hashCode() {
        int result = message != null ? message.hashCode() : 0;
        result = 31 * result + (messageType != null ? messageType.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

}
