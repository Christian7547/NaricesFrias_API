package NaricesFrias_API.NaricesFrias_API.domain.models;

import lombok.Data;

@Data
public class User {
    public int id;
    public String email;
    public String password;
    public short status;
    public int roleId;
}
