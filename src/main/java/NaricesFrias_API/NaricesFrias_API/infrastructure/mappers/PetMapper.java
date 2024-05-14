package NaricesFrias_API.NaricesFrias_API.infrastructure.mappers;

import NaricesFrias_API.NaricesFrias_API.domain.models.Pet;
import NaricesFrias_API.NaricesFrias_API.infrastructure.entities.PetEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PetMapper {

    Pet toPet(PetEntity petEntity);
    PetEntity toPetEntity(Pet pet);
    ArrayList<Pet> toPets(List<PetEntity> petEntities);
    void updatePet(@MappingTarget PetEntity target, PetEntity source);
}
