package NaricesFrias_API.NaricesFrias_API.infrastructure.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PetRequestDTO {
    public String name;
    public String breed;
    public String gender;
    public String info;
    public int ownerId;
    public String path1;
    public String path2;
    public String path3;
}


