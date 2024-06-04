package NaricesFrias_API.NaricesFrias_API.application.services.implementation;

import NaricesFrias_API.NaricesFrias_API.application.services.interfaces.IContractService;
import NaricesFrias_API.NaricesFrias_API.domain.models.Contract;
import NaricesFrias_API.NaricesFrias_API.domain.ports.IContractDomainRepository;



import java.sql.Timestamp;
import java.time.ZonedDateTime;


public class ContractService implements IContractService {
    private final IContractDomainRepository contractRepository;

    public ContractService(IContractDomainRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public Contract createContract(Contract contract) {
        return contractRepository.createContract(contract);
    }

    @Override
    public int uspContract(int v_pet_id, String v_contract_type, String v_price, String v_serial, int v_owner_id,
                           String v_due_date, String v_sub_total, String v_total, String v_subtotal_buy,
                           int v_collar_id){
        return contractRepository.uspContract(v_pet_id, v_contract_type, v_price, v_serial, v_owner_id, v_due_date,
                                              v_sub_total, v_total, v_subtotal_buy, v_collar_id);
    }
}
