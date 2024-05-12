package NaricesFrias_API.NaricesFrias_API.domain.ports;

import NaricesFrias_API.NaricesFrias_API.domain.models.Owner;
import NaricesFrias_API.NaricesFrias_API.infrastructure.entities.OwnerEntity;

import java.util.ArrayList;

public interface IOwnerDomainRepository {
    Owner createOwner(Owner owner);
    void removeOwner(int ownerId);
    Owner getOwner(int ownerId);
    ArrayList<Owner> getOwners();
    Owner editOwner(int ownerId, Owner owner);
}
