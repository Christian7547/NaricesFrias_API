package NaricesFrias_API.NaricesFrias_API.infrastructure.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
//@AllArgsConstructor
@Data
public class Pets {

    public int id;
    public String name;
    public String breed;
    public String gender;
    public String path;

    public Pets(int id, String name, String breed, String gender, String path) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.gender = gender;
        this.path = path;
    }
}
