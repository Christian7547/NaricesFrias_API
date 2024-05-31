package NaricesFrias_API.NaricesFrias_API.infrastructure.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
//@AllArgsConstructor
@Data
public class PetDetail {
    public String name;
    public String breed;
    public String gender;
    public String info;
    public String path;

    public PetDetail(String name, String breed, String gender, String info, String path) {
        this.name = name;
        this.breed = breed;
        this.gender = gender;
        this.info = info;
        this.path = path;
    }
}


