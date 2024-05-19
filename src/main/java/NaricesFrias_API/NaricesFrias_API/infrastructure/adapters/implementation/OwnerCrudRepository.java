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
    public Owner getOwner(int ownerId) {
        var ownerEntity = ownerRepository.findById(ownerId);
        return ownerEntity.map(entity -> ownerMapper.toOwner(entity)).orElse(null);
    }

    @Override
    public ArrayList<Owner> getOwners() {
        return this.ownerMapper.toOwners(this.ownerRepository.findAll());
    }

    @Override
    public Owner getOwnerByUserId(int userId) {
        var ownerExists = ownerRepository.findByUserId(userId);
        return ownerExists.map(ownerEntity -> ownerMapper.toOwner(ownerEntity)).orElse(null);
    }
}
