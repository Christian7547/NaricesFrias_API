package NaricesFrias_API.NaricesFrias_API.infrastructure.adapters.interfaces;


import NaricesFrias_API.NaricesFrias_API.infrastructure.dtos.PetDetail;
import NaricesFrias_API.NaricesFrias_API.infrastructure.dtos.Pets;
import NaricesFrias_API.NaricesFrias_API.infrastructure.entities.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface IPetRepository extends JpaRepository<PetEntity, Integer>{

    @Procedure(name = "uspInsertPetImages")
    int uspInsertPetImages(String petName, String petBreed, String petGender, String petInfo,
                            int petOwnerId, String petPath1, String petPath2, String petPath3
    );
    @Procedure(name = "uspDetailPet")
    PetDetail uspDetailPet(int v_pet_id);

    @Query(value = "SELECT * FROM usppetsowner(:v_owner_id)", nativeQuery = true)
    List<Pets> uspPetsOwner(@Param("v_owner_id") int v_owner_id);

}
