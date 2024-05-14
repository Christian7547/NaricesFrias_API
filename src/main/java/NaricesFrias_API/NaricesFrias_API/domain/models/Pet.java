package NaricesFrias_API.NaricesFrias_API.domain.models;

import lombok.Data;

@Data
public class Pet {
    public int id;
    public String name;
    public String breed;
    public String gender;
    public String info;
    public short status;
    public int ownerId;
}
