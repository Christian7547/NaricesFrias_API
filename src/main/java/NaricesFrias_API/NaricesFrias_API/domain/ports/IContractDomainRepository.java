package NaricesFrias_API.NaricesFrias_API.domain.ports;

import NaricesFrias_API.NaricesFrias_API.domain.models.Contract;

import java.sql.Timestamp;
import java.time.ZonedDateTime;


public interface IContractDomainRepository {
    Contract createContract(Contract contract);

    int uspContract(int v_pet_id, String v_contract_type, String v_price, String v_serial, int v_owner_id,
                    String v_due_date, String v_sub_total, String v_total, String v_subtotal_buy,
                    int v_collar_id);
}
