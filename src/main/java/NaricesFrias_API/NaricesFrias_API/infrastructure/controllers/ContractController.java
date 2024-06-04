package NaricesFrias_API.NaricesFrias_API.infrastructure.controllers;

import NaricesFrias_API.NaricesFrias_API.application.services.interfaces.IContractService;
import NaricesFrias_API.NaricesFrias_API.domain.models.Contract;
import NaricesFrias_API.NaricesFrias_API.infrastructure.dtos.ContractRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {
    private final IContractService contractService;

    public ContractController(IContractService contractService)  {
        this.contractService = contractService;
    }

    @PostMapping("/newContract")
    public ResponseEntity<Contract> newContract(@RequestBody Contract contract){
        return new ResponseEntity<>(contractService.createContract(contract), HttpStatus.CREATED);
    }
    @PostMapping("/newContractFull")
    public ResponseEntity<Integer> newContractFull(@RequestBody ContractRequestDTO contractDto) {
        var result = contractService.uspContract(contractDto.v_pet_id , contractDto.v_contract_type,
                contractDto.v_price, contractDto.v_serial,
                contractDto.v_owner_id, contractDto.v_due_date,
                contractDto.v_sub_total, contractDto.v_total,
                contractDto.v_subtotal_buy, contractDto.v_collar_id);

        if(result >= 1)
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
}
