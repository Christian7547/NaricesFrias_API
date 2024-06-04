package NaricesFrias_API.NaricesFrias_API.infrastructure.adapters.interfaces;

import NaricesFrias_API.NaricesFrias_API.infrastructure.entities.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;


public interface IContractRepository extends JpaRepository<ContractEntity, Integer> {

    @Procedure(name = "uspContract")
    int uspContract(int v_pet_id, String v_contract_type, String v_price, String v_serial, int v_owner_id,
                    String v_due_date, String v_sub_total, String v_total, String v_subtotal_buy,
                    int v_collar_id);
}
