package NaricesFrias_API.NaricesFrias_API.application.services.implementation;

import NaricesFrias_API.NaricesFrias_API.application.services.interfaces.IPetService;
import NaricesFrias_API.NaricesFrias_API.domain.models.Pet;
import NaricesFrias_API.NaricesFrias_API.domain.ports.IPetDomainRepository;

import java.util.ArrayList;

public class PetService implements IPetService {
    private final IPetDomainRepository petRepository;

    public PetService(IPetDomainRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet createPet(Pet pet) {
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
}
