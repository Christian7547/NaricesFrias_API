package NaricesFrias_API.NaricesFrias_API.infrastructure.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.ZonedDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class ContractRequestDTO {
    public int v_pet_id;
    public String v_contract_type;
    public String v_price;
    public String v_serial;
    public int v_owner_id;
    public String v_due_date;
    public String v_sub_total;
    public String v_total;
    public String v_subtotal_buy;
    public int v_collar_id;
}
