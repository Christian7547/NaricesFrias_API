package NaricesFrias_API.NaricesFrias_API.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pet", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "name")
    public String name;

    @Column(name = "breed")
    public String breed;

    @Column(name = "gender")
    public String gender;

    @Column(name = "info")
    public String info;

    @Column(name = "status")
    public short status;

    @Column(name = "owner_id")
    public int ownerId;
}
