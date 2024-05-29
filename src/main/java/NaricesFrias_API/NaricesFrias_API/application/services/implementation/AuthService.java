package NaricesFrias_API.NaricesFrias_API.application.services.implementation;

import NaricesFrias_API.NaricesFrias_API.application.services.interfaces.IAuthService;
import NaricesFrias_API.NaricesFrias_API.domain.models.User;
import NaricesFrias_API.NaricesFrias_API.domain.ports.IAuthDomainRepository;

public class AuthService implements IAuthService {

    private final IAuthDomainRepository authDomainRepository;

    public AuthService(IAuthDomainRepository authDomainRepository) {
        this.authDomainRepository = authDomainRepository;
    }

    @Override
    public User authenticate(User user) {
        user.password = Encrypt.encrypt(user.password);
        return authDomainRepository.authenticate(user);
    }
}
