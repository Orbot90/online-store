package opensource.onlinestore.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import opensource.onlinestore.model.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by maks(avto12@i.ua) on 27.01.2016.
 */
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    UserEntity save(UserEntity user);

    @Override
    UserEntity findOne(Integer id);

    @Override
    List<UserEntity> findAll(Sort sort);

    UserEntity getByEmail(String email);

    @Query("SELECT u FROM User u JOIN FETCH u.orders WHERE u.id = ?1")
    UserEntity getWithOrders(Integer id);

}
