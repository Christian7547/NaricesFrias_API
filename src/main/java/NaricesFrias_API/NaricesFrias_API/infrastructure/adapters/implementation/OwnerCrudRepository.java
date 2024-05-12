package NaricesFrias_API.NaricesFrias_API.infrastructure.adapters.implementation;

import NaricesFrias_API.NaricesFrias_API.domain.models.Owner;
import NaricesFrias_API.NaricesFrias_API.domain.ports.IOwnerDomainRepository;
import NaricesFrias_API.NaricesFrias_API.infrastructure.adapters.interfaces.IOwnerRepository;
import NaricesFrias_API.NaricesFrias_API.infrastructure.mappers.OwnerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class OwnerCrudRepository implements IOwnerDomainRepository {

    @Autowired
    private OwnerMapper ownerMapper;

    private final IOwnerRepository ownerRepository;

    public OwnerCrudRepository(IOwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner createOwner(Owner owner) {
        var toOwnerEntity = ownerMapper.toOwnerEntity(owner);
        var ownerCreated = ownerRepository.save(toOwnerEntity);
        return ownerMapper.toOwner(ownerCreated);
    }

    @Override
    public void removeOwner(int ownerId) {
        ownerRepository.deleteById(ownerId);
    }

    @Override
    public Owner getOwner(int ownerId) {
        var ownerEntity = ownerRepository.findById(ownerId);
        return ownerEntity.map(entity -> ownerMapper.toOwner(entity)).orElse(null);
    }

    @Override
    public ArrayList<Owner> getOwners() {
        return this.ownerMapper.toOwners(this.ownerRepository.findAll());
    }

    @Override
    public Owner editOwner(int ownerId, Owner owner) {
        var ownerEntity = ownerRepository.findById(ownerId);
        ownerMapper.updateOwner(ownerEntity.get(), ownerMapper.toOwnerEntity(owner));
        var updatedOwner = ownerRepository.save(ownerEntity.get());
        return ownerMapper.toOwner(updatedOwner);
    }
}
