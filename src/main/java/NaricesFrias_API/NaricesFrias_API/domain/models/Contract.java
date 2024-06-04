package NaricesFrias_API.NaricesFrias_API.domain.models;

import lombok.Data;

@Data
public class Contract {
    public int id;
    public String contract_type;
    public Double price;
    public String serial_number_contract;
}
