package NaricesFrias_API.NaricesFrias_API.infrastructure.adapters.implementation;

import NaricesFrias_API.NaricesFrias_API.domain.models.Owner;
import NaricesFrias_API.NaricesFrias_API.domain.models.User;
import NaricesFrias_API.NaricesFrias_API.domain.ports.IUserDomainRepository;
import NaricesFrias_API.NaricesFrias_API.infrastructure.adapters.interfaces.IOwnerRepository;
import NaricesFrias_API.NaricesFrias_API.infrastructure.adapters.interfaces.IUserRepository;
import NaricesFrias_API.NaricesFrias_API.infrastructure.mappers.OwnerMapper;
import NaricesFrias_API.NaricesFrias_API.infrastructure.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserCrudRepository implements IUserDomainRepository {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OwnerMapper ownerMapper;

    private final IUserRepository userRepository;
    private final IOwnerRepository ownerRepository;

    public UserCrudRepository(IUserRepository userRepository, IOwnerRepository ownerRepository) {
        this.userRepository = userRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public User createUser(User user, Owner owner) {
        var toUserEntity = userMapper.toUserEntity(user);
        var toOwnerEntity = ownerMapper.toOwnerEntity(owner);
        var userCreated = userRepository.save(toUserEntity);
        toOwnerEntity.userId = userCreated.id;
        ownerRepository.save(toOwnerEntity);
        return userMapper.toUser(userCreated);
    }

    @Override
    public void removeUser(User user) {
        var userEntity = userRepository.findById(user.id);
        userMapper.saveChanges(userEntity.get(), userMapper.toUserEntity(user));
        userRepository.save(userEntity.get());
    }

    @Override
    public User getUser(int userId) {
        var userEntity = userRepository.findById(userId);
        return userMapper.toUser(userEntity.get());
    }

    @Override
    public User editUser(int userId, User user, Owner owner) {
        var userEntity = userRepository.findById(userId);
        var ownerEntity = ownerRepository.findByUserId(userId);
        userMapper.saveChanges(userEntity.get(), userMapper.toUserEntity(user));
        ownerMapper.saveChanges(ownerEntity.get(), ownerMapper.toOwnerEntity(owner));
        var updatedUser = userRepository.save(userEntity.get());
        ownerRepository.save(ownerEntity.get());
        return userMapper.toUser(updatedUser);
    }
}
