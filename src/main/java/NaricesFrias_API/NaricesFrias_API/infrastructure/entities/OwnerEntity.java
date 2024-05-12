package NaricesFrias_API.NaricesFrias_API.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "owner")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "name")
    public String name;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "second_last_name")
    public String secondLastName;

    @Column(name = "ci")
    public String ci;

    @Column(name = "phone_number")
    public String phoneNumber;

    @Column(name = "address")
    public String address;

    @Column(name = "user_id")
    public int userId;
}
