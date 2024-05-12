package NaricesFrias_API.NaricesFrias_API.infrastructure.adapters.interfaces;

import NaricesFrias_API.NaricesFrias_API.infrastructure.entities.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOwnerRepository extends JpaRepository<OwnerEntity, Integer> {
}
