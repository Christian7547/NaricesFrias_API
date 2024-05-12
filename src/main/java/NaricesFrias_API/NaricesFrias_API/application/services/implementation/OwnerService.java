package NaricesFrias_API.NaricesFrias_API.application.services.implementation;

import NaricesFrias_API.NaricesFrias_API.application.services.interfaces.IOwnerService;
import NaricesFrias_API.NaricesFrias_API.domain.models.Owner;
import NaricesFrias_API.NaricesFrias_API.domain.ports.IOwnerDomainRepository;

import java.util.ArrayList;

public class OwnerService implements IOwnerService {

    private final IOwnerDomainRepository ownerRepository;

    public OwnerService(IOwnerDomainRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner createOwner(Owner owner) {
        return ownerRepository.createOwner(owner);
    }

    @Override
    public void removeOwner(int ownerId) {
        ownerRepository.removeOwner(ownerId);
    }

    @Override
    public Owner getOwner(int ownerId) {
        return ownerRepository.getOwner(ownerId);
    }

    @Override
    public ArrayList<Owner> getOwners() {
        return ownerRepository.getOwners();
    }

    @Override
    public Owner editOwner(int ownerId, Owner owner) {
        owner.id = ownerId;
        return ownerRepository.editOwner(ownerId, owner);
    }
}
