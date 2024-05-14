package NaricesFrias_API.NaricesFrias_API.infrastructure.adapters.interfaces;

import NaricesFrias_API.NaricesFrias_API.infrastructure.entities.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPetRepository extends JpaRepository<PetEntity, Integer>{
}
