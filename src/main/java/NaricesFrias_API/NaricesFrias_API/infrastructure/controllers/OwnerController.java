package NaricesFrias_API.NaricesFrias_API.infrastructure.controllers;

import NaricesFrias_API.NaricesFrias_API.application.services.interfaces.IOwnerService;
import NaricesFrias_API.NaricesFrias_API.domain.models.Owner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    private final IOwnerService ownerService;

    public OwnerController(IOwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<ArrayList<Owner>> getOwners(){
        return new ResponseEntity<>(ownerService.getOwners(), HttpStatus.OK);
    }

    @PostMapping("/newOwner")
    public ResponseEntity<Owner> newOwner(@RequestBody Owner owner){
        return new ResponseEntity<>(ownerService.createOwner(owner), HttpStatus.CREATED);
    }

    @GetMapping("/getOwner/{id}")
    public ResponseEntity<Owner> getOwner(@PathVariable int id){
        return new ResponseEntity<>(ownerService.getOwner(id), HttpStatus.OK);
    }

    @PatchMapping("/editOwner/{id}")
    public ResponseEntity<Owner> editOwner(@PathVariable int id, @RequestBody Owner owner){
        return new ResponseEntity<>(ownerService.editOwner(id, owner), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/removeOwner/{id}")
    public ResponseEntity<?> removeOwner(@PathVariable int id){
        ownerService.removeOwner(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
