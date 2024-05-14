package NaricesFrias_API.NaricesFrias_API.infrastructure.controllers;

import NaricesFrias_API.NaricesFrias_API.application.services.interfaces.IPetService;
import NaricesFrias_API.NaricesFrias_API.domain.models.Pet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final IPetService petService;

    public PetController(IPetService petService) {
        this.petService = petService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<ArrayList<Pet>> getPets(){
        return new ResponseEntity<>(petService.getPets(), HttpStatus.OK);
    }

    @PostMapping("/newPet")
    public ResponseEntity<Pet> newPet(@RequestBody Pet pet){
        return new ResponseEntity<>(petService.createPet(pet), HttpStatus.CREATED);
    }

    @GetMapping("/getPet/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable int id){
        return new ResponseEntity<>(petService.getPet(id), HttpStatus.OK);
    }

    @PatchMapping("/editPet/{id}")
    public ResponseEntity<Pet> editPet(@PathVariable int id, @RequestBody Pet pet){
        return new ResponseEntity<>(petService.editPet(id, pet), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/removeOwner/{id}")
    public ResponseEntity<?> removeOwner(@PathVariable int id){
        petService.removePet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
