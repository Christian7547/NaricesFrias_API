package NaricesFrias_API.NaricesFrias_API.infrastructure.adapters.interfaces;

import NaricesFrias_API.NaricesFrias_API.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IAuthRepository extends JpaRepository<UserEntity, Integer>{
    @Query("SELECT u FROM UserEntity u WHERE u.email = ?1 AND u.password = ?2 AND u.status = 1")
    Optional<UserEntity> findByEmailAndPassword(String email, String password);
}
