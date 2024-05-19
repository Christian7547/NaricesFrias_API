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

    @GetMapping("/getOwner/{id}")
    public ResponseEntity<Owner> getOwner(@PathVariable int id){
        return new ResponseEntity<>(ownerService.getOwner(id), HttpStatus.OK);
    }

    @GetMapping("/getOwnerByUserId/{id}")
    public  ResponseEntity<Owner> getOwnerByUserId(@PathVariable int id){
        var owner = ownerService.getOwnerByUserId(id);
        if(owner != null)
            return new ResponseEntity<>(owner, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
