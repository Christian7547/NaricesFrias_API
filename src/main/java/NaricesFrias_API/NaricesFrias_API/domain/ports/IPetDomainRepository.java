package NaricesFrias_API.NaricesFrias_API.domain.ports;

import NaricesFrias_API.NaricesFrias_API.domain.models.Pet;

import java.util.ArrayList;

public interface IPetDomainRepository {
    Pet createPet(Pet pet);
    void removePet(int petId);
    Pet getPet(int ownerId);
    ArrayList<Pet> getPets();
    Pet editPet(int petId, Pet pet);
}
