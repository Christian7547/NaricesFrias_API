package NaricesFrias_API.NaricesFrias_API.infrastructure.mappers;

import NaricesFrias_API.NaricesFrias_API.domain.models.User;
import NaricesFrias_API.NaricesFrias_API.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserEntity entity);
    UserEntity toUserEntity(User user);
    void saveChanges(@MappingTarget UserEntity target, UserEntity source);
}
