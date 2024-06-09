package NaricesFrias_API.NaricesFrias_API.infrastructure.controllers;

import NaricesFrias_API.NaricesFrias_API.application.services.interfaces.IPetService;
import NaricesFrias_API.NaricesFrias_API.domain.models.Pet;
import NaricesFrias_API.NaricesFrias_API.infrastructure.dtos.PetDetail;
import NaricesFrias_API.NaricesFrias_API.infrastructure.dtos.PetRequestDTO;
import NaricesFrias_API.NaricesFrias_API.infrastructure.dtos.Pets;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @DeleteMapping("/removePet/{id}")
    public ResponseEntity<?> removePet(@PathVariable int id){
        petService.removePet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/insetWithImages")
    public ResponseEntity<Integer> createPetWithImages(@RequestBody PetRequestDTO petDTO) {
        var result = petService.uspInsertPetImages(petDTO.name, petDTO.breed,
                petDTO.gender, petDTO.info,
                petDTO.ownerId, petDTO.path1,
                petDTO.path2, petDTO.path3);

        if(result >= 1)
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/PetDetail/{v_pet_id}")
    public ResponseEntity<PetDetail> uspDetailPet(@PathVariable int v_pet_id) {
        var result = petService.uspDetailPet(v_pet_id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/PetsbyOwner/{v_owner_id}")
    public  ResponseEntity<List<Pets>> uspPetsOwner(@PathVariable int v_owner_id){
        return new ResponseEntity<>(petService.uspPetsOwner(v_owner_id), HttpStatus.OK);
    }
}
