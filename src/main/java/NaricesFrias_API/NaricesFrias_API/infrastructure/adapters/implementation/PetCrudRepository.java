package NaricesFrias_API.NaricesFrias_API.infrastructure.adapters.implementation;

import NaricesFrias_API.NaricesFrias_API.domain.models.Pet;
import NaricesFrias_API.NaricesFrias_API.domain.ports.IPetDomainRepository;
import NaricesFrias_API.NaricesFrias_API.infrastructure.adapters.interfaces.IPetRepository;
import NaricesFrias_API.NaricesFrias_API.infrastructure.mappers.PetMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class PetCrudRepository implements IPetDomainRepository {

    @Autowired
    private PetMapper petMapper;
    @PersistenceContext
    private EntityManager entityManager;

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

//petName, :petBreed, :petGender, :petInfo, :petOwnerId, :petPath1, :petPath2, :petPath3)")

    @Override
    public int uspInsertPetImages(String petName, String petBreed, String petGender, String petInfo,
                                   int petOwnerId, String petPath1, String petPath2, String petPath3) {
        int value = 0;
        StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("uspInsertPetImages");
        procedureQuery.registerStoredProcedureParameter("petName", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("petBreed", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("petGender", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("petInfo", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("petOwnerId", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("petPath1", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("petPath2", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("petPath3", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("insert_count", Integer.class, ParameterMode.OUT);


        procedureQuery.setParameter("petName", petName);
        procedureQuery.setParameter("petBreed", petBreed);
        procedureQuery.setParameter("petGender", petGender);
        procedureQuery.setParameter("petInfo", petInfo);
        procedureQuery.setParameter("petOwnerId", petOwnerId);
        procedureQuery.setParameter("petPath1", petPath1);
        procedureQuery.setParameter("petPath2", petPath2);
        procedureQuery.setParameter("petPath3", petPath3);
        procedureQuery.setParameter("insert_count", value);


        procedureQuery.execute();
        var x = procedureQuery.getOutputParameterValue("insert_count");
        return Integer.parseInt(x.toString());
    }
}
