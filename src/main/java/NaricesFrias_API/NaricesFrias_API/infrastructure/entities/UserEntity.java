package NaricesFrias_API.NaricesFrias_API.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "email")
    public String email;

    @Column(name = "password")
    public String password;

    @Column(name = "status")
    public short status;

    @Column(name = "role_id")
    public int roleId;
}
