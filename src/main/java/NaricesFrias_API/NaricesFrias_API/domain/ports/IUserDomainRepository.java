package NaricesFrias_API.NaricesFrias_API.domain.ports;

import NaricesFrias_API.NaricesFrias_API.domain.models.Owner;
import NaricesFrias_API.NaricesFrias_API.domain.models.User;

public interface IUserDomainRepository {
    User createUser(User user, Owner owner);
    void removeUser(User user);
    User getUser(int userId);
    User editUser(int userId, User user, Owner owner);
}
