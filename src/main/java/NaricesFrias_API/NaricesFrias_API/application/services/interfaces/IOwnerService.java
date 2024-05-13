package NaricesFrias_API.NaricesFrias_API.application.services.interfaces;

import NaricesFrias_API.NaricesFrias_API.domain.models.Owner;

import java.util.ArrayList;

public interface IOwnerService {
    Owner getOwner(int ownerId);
    ArrayList<Owner> getOwners();
}
