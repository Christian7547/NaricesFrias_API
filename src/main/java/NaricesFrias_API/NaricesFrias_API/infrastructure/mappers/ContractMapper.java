package NaricesFrias_API.NaricesFrias_API.infrastructure.mappers;

import NaricesFrias_API.NaricesFrias_API.domain.models.Contract;

import NaricesFrias_API.NaricesFrias_API.infrastructure.entities.ContractEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContractMapper {

    Contract toContract(ContractEntity contractEntity);
    ContractEntity toContractEntity(Contract contract);
}
