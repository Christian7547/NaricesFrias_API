package NaricesFrias_API.NaricesFrias_API.application.services.implementation;

import NaricesFrias_API.NaricesFrias_API.application.services.interfaces.IUserService;
import NaricesFrias_API.NaricesFrias_API.domain.models.Owner;
import NaricesFrias_API.NaricesFrias_API.domain.models.User;
import NaricesFrias_API.NaricesFrias_API.domain.ports.IUserDomainRepository;

public class UserService implements IUserService {

    private final IUserDomainRepository userDomainRepository;

    public UserService(IUserDomainRepository userDomainRepository) {
        this.userDomainRepository = userDomainRepository;
    }

    @Override
    public User createUser(User user, Owner owner) {
        user.roleId = 2;
        user.status = 1;
        return userDomainRepository.createUser(user, owner);
    }

    @Override
    public void removeUser(User user) {
        user.status = 0;
        userDomainRepository.removeUser(user);
    }

    @Override
    public User getUser(int userId) {
        return userDomainRepository.getUser(userId);
    }

    @Override
    public User editUser(int userId, User user, Owner owner) {
        return userDomainRepository.editUser(userId, user, owner);
    }
}
