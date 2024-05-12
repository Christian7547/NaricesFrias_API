package NaricesFrias_API.NaricesFrias_API.domain.models;

import lombok.Data;

@Data
public class Owner {

    public int id;
    public String name;
    public String lastName;
    public String secondLastName;
    public String ci;
    public String phoneNumber;
    public String address;
    public int userId;
}
