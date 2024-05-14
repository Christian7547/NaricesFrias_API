package NaricesFrias_API.NaricesFrias_API.application.services.interfaces;

import NaricesFrias_API.NaricesFrias_API.domain.models.Pet;

import java.util.ArrayList;

public interface IPetService {
    Pet createPet(Pet pet);
    void removePet(int petId);
    Pet getPet(int petId);
    ArrayList<Pet> getPets();
    Pet editPet(int petId, Pet pet);
}
