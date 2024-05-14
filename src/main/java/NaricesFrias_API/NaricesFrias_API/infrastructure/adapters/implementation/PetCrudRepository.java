package NaricesFrias_API.NaricesFrias_API.infrastructure.adapters.implementation;

import NaricesFrias_API.NaricesFrias_API.domain.models.Owner;
import NaricesFrias_API.NaricesFrias_API.domain.models.Pet;
import NaricesFrias_API.NaricesFrias_API.domain.ports.IPetDomainRepository;
import NaricesFrias_API.NaricesFrias_API.infrastructure.adapters.interfaces.IOwnerRepository;
import NaricesFrias_API.NaricesFrias_API.infrastructure.adapters.interfaces.IPetRepository;
import NaricesFrias_API.NaricesFrias_API.infrastructure.mappers.OwnerMapper;
import NaricesFrias_API.NaricesFrias_API.infrastructure.mappers.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class PetCrudRepository implements IPetDomainRepository {

    @Autowired
    private PetMapper petMapper;

    private final IPetRepository petRepository;

    public PetCrudRepository(IPetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet createPet(Pet pet) {
        var toPetEntity = petMapper.toPetEntity(pet);
        var petCreated = petRepository.save(toPetEntity);
        return petMapper.toPet(petCreated);
    }

    @Override
    public void removePet(int petId) {
        petRepository.deleteById(petId);
    }

    @Override
    public Pet getPet(int petId) {
        var petEntity = petRepository.findById(petId);
        return petEntity.map(entity -> petMapper.toPet(entity)).orElse(null);
    }

    @Override
    public ArrayList<Pet> getPets() {
        return this.petMapper.toPets(this.petRepository.findAll());
    }

    @Override
    public Pet editPet(int petId, Pet pet) {
        var petEntity = petRepository.findById(petId);
        petMapper.updatePet(petEntity.get(), petMapper.toPetEntity(pet));
        var updatedPet = petRepository.save(petEntity.get());
        return petMapper.toPet(updatedPet);
    }
}
