package opensource.onlinestore.repository;

import opensource.onlinestore.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by malex on 26.01.16.
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
