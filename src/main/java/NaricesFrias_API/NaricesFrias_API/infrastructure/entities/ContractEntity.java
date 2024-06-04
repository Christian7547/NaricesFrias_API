package NaricesFrias_API.NaricesFrias_API.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contract", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "contract_type")
    public String contract_type;

    @Column(name = "price")
    public Double price;

    @Column(name = "serial_number_contract")
    public String serial_number_contract;
}
