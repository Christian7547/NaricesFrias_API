package NaricesFrias_API.NaricesFrias_API.application.services.implementation;

import NaricesFrias_API.NaricesFrias_API.application.services.interfaces.IPetService;
import NaricesFrias_API.NaricesFrias_API.domain.models.Pet;
import NaricesFrias_API.NaricesFrias_API.domain.ports.IPetDomainRepository;
import NaricesFrias_API.NaricesFrias_API.infrastructure.dtos.PetDetail;
import NaricesFrias_API.NaricesFrias_API.infrastructure.dtos.Pets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class PetService implements IPetService {
    private final IPetDomainRepository petRepository;

    public PetService(IPetDomainRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet createPet(Pet pet) {
        pet.status = 1;
        return petRepository.createPet(pet);
    }

    @Override
    public void removePet(int petId) {
        petRepository.removePet(petId);
    }

    @Override
    public Pet getPet(int petId) {
        return petRepository.getPet(petId);
    }

    @Override
    public ArrayList<Pet> getPets() {
        return petRepository.getPets();
    }

    @Override
    public Pet editPet(int petId, Pet pet) {
        pet.id = petId;
        return petRepository.editPet(petId, pet);
    }

    @Override
    public int uspInsertPetImages(String petName, String petBreed, String petGender, String petInfo, int petOwnerId, String petPath1, String petPath2, String petPath3) {
        return  petRepository.uspInsertPetImages(petName, petBreed, petGender, petInfo, petOwnerId, petPath1, petPath2, petPath3);
    }

    @Override
    public PetDetail uspDetailPet(int v_pet_id) {
        return petRepository.uspDetailPet(v_pet_id);
    }

    @Override
    public List<Pets> uspPetsOwner(int v_owner_id) {
        return petRepository.uspPetsOwner(v_owner_id);
    }
}
