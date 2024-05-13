package NaricesFrias_API.NaricesFrias_API.domain.ports;

import NaricesFrias_API.NaricesFrias_API.domain.models.Owner;

import java.util.ArrayList;

public interface IOwnerDomainRepository {
    Owner getOwner(int ownerId);
    ArrayList<Owner> getOwners();
}
