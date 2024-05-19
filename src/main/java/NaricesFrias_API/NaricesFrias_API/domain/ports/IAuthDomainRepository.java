package NaricesFrias_API.NaricesFrias_API.domain.ports;

import NaricesFrias_API.NaricesFrias_API.domain.models.User;

public interface IAuthDomainRepository {
    User authenticate(User authUser);
}
