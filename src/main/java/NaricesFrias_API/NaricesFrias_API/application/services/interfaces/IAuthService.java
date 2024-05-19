package NaricesFrias_API.NaricesFrias_API.application.services.interfaces;

import NaricesFrias_API.NaricesFrias_API.domain.models.User;

public interface IAuthService {
    User authenticate(User user);
}
