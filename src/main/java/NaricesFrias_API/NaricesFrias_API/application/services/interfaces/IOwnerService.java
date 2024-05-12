package NaricesFrias_API.NaricesFrias_API.application.services.interfaces;

import NaricesFrias_API.NaricesFrias_API.domain.models.Owner;

import java.util.ArrayList;

public interface IOwnerService {
    Owner createOwner(Owner owner);
    void removeOwner(int ownerId);
    Owner getOwner(int ownerId);
    ArrayList<Owner> getOwners();
    Owner editOwner(int ownerId, Owner owner);
}
