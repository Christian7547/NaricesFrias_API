package NaricesFrias_API.NaricesFrias_API.infrastructure.controllers;

import NaricesFrias_API.NaricesFrias_API.application.services.interfaces.IUserService;
import NaricesFrias_API.NaricesFrias_API.domain.models.Owner;
import NaricesFrias_API.NaricesFrias_API.domain.models.User;
import NaricesFrias_API.NaricesFrias_API.infrastructure.dtos.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/newUser")
    public ResponseEntity<User> createUser(@RequestBody UserDto request){
        User user = new User();
        Owner owner = new Owner();
        user.email = request.email;
        user.password = request.password;
        owner.name = request.name;
        owner.lastName = request.lastName;
        owner.secondLastName = request.secondLastName;
        owner.ci = request.ci;
        owner.phoneNumber = request.phoneNumber;
        owner.address = request.address;
        return new ResponseEntity<>(userService.createUser(user, owner), HttpStatus.CREATED);
    }

    @PatchMapping("/editUser/{id}")
    public  ResponseEntity<User> editUser(@PathVariable int id, @RequestBody UserDto request){
        User user = new User();
        Owner owner = new Owner();
        user.email = request.email;
        user.password = request.password;
        owner.name = request.name;
        owner.lastName = request.lastName;
        owner.secondLastName = request.secondLastName;
        owner.ci = request.ci;
        owner.phoneNumber = request.phoneNumber;
        owner.address = request.address;
        return new ResponseEntity<>(userService.editUser(id, user, owner), HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/removeUser")
    public ResponseEntity<?> removeUser(@RequestBody User user){
        userService.removeUser(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id){
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }
}
