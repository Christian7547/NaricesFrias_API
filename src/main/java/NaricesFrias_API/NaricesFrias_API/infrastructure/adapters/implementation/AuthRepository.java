package NaricesFrias_API.NaricesFrias_API.infrastructure.adapters.implementation;

import NaricesFrias_API.NaricesFrias_API.domain.models.User;
import NaricesFrias_API.NaricesFrias_API.domain.ports.IAuthDomainRepository;
import NaricesFrias_API.NaricesFrias_API.infrastructure.adapters.interfaces.IAuthRepository;
import NaricesFrias_API.NaricesFrias_API.infrastructure.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthRepository implements IAuthDomainRepository {

    @Autowired
    private UserMapper userMapper;

    private final IAuthRepository authRepository;

    public AuthRepository(IAuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public User authenticate(User authUser) {
        var toUserEntity = userMapper.toUserEntity(authUser);
        var auth = authRepository.findByEmailAndPassword(toUserEntity.email, toUserEntity.password);
        return auth.map(userEntity -> userMapper.toUser(userEntity)).orElse(null);
    }
}
