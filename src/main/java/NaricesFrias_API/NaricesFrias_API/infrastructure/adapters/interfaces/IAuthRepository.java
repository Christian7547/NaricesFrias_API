package NaricesFrias_API.NaricesFrias_API.infrastructure.adapters.interfaces;

import NaricesFrias_API.NaricesFrias_API.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IAuthRepository extends JpaRepository<UserEntity, Integer>{
    @Query("SELECT u FROM UserEntity u WHERE u.email = :email AND u.password = :password AND u.status = 1")
    Optional<UserEntity> findByEmailAndPassword(@Param("email") String email,@Param("password") String password);
}
