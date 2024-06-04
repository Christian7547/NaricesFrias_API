package NaricesFrias_API.NaricesFrias_API.infrastructure.adapters.implementation;

import NaricesFrias_API.NaricesFrias_API.domain.models.Contract;

import NaricesFrias_API.NaricesFrias_API.domain.ports.IContractDomainRepository;
import NaricesFrias_API.NaricesFrias_API.infrastructure.adapters.interfaces.IContractRepository;

import NaricesFrias_API.NaricesFrias_API.infrastructure.mappers.ContractMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContractRepository implements IContractDomainRepository {
    @Autowired
    private ContractMapper contractMapper;
    @PersistenceContext
    private EntityManager entityManager;

    private final IContractRepository contractRepository;

    public ContractRepository(IContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public Contract createContract(Contract contract) {
        var toContractEntity = contractMapper.toContractEntity(contract);
        var contractCreated = contractRepository.save(toContractEntity);
        return contractMapper.toContract(contractCreated);
    }

    @Override
    public int uspContract(int v_pet_id, String v_contract_type, String v_price, String v_serial, int v_owner_id,
                           String v_due_date, String v_sub_total, String v_total, String v_subtotal_buy,
                           int v_collar_id){
        //int value = 0;
        StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("uspContract");
        procedureQuery.registerStoredProcedureParameter("v_pet_id", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("v_contract_type", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("v_price", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("v_serial", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("v_owner_id", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("v_due_date", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("v_sub_total", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("v_total", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("v_subtotal_buy", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("v_collar_id", Integer.class, ParameterMode.IN);
        //procedureQuery.registerStoredProcedureParameter("insert_count", Integer.class, ParameterMode.OUT);

        procedureQuery.setParameter("v_pet_id", v_pet_id);
        procedureQuery.setParameter("v_contract_type", v_contract_type);
        procedureQuery.setParameter("v_price", v_price);
        procedureQuery.setParameter("v_serial", v_serial);
        procedureQuery.setParameter("v_owner_id", v_owner_id);
        procedureQuery.setParameter("v_due_date", v_due_date);
        procedureQuery.setParameter("v_sub_total", v_sub_total);
        procedureQuery.setParameter("v_total", v_total);
        procedureQuery.setParameter("v_subtotal_buy", v_subtotal_buy);
        procedureQuery.setParameter("v_collar_id", v_collar_id);
        //procedureQuery.setParameter("insert_count", value);


        procedureQuery.execute();
        //var x = procedureQuery.getOutputParameterValue("insert_count");
        return 1;   //Integer.parseInt(x.toString());
    }
}
