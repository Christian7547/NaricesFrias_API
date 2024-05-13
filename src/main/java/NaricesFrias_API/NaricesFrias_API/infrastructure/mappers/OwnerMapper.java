package NaricesFrias_API.NaricesFrias_API.infrastructure.mappers;

import NaricesFrias_API.NaricesFrias_API.domain.models.Owner;
import NaricesFrias_API.NaricesFrias_API.infrastructure.entities.OwnerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    Owner toOwner(OwnerEntity ownerEntity);
    OwnerEntity toOwnerEntity(Owner owner);
    ArrayList<Owner> toOwners(List<OwnerEntity> ownerEntities);
    void saveChanges(@MappingTarget OwnerEntity target, OwnerEntity source);
}
