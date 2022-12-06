package gov.cms.ab2d.contracts.controller;

import gov.cms.ab2d.contracts.model.Contract;
import gov.cms.ab2d.contracts.service.ContractService;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ContractController implements ContractAPI {
    private final ContractService contractService;

    @Override
    public List<Contract> getAllAttestedContracts() {
        return contractService.getAllContracts();
    }

    @Override
    public void updateContract(@RequestBody Contract contract) {
        contractService.updateContract(contract);
    }

    @Override
    public Contract getContractByValue(@RequestParam("contractId") Optional<Long> contractId, @RequestParam("contractNumber") Optional<String> contractNumber) {
        if (contractId.isPresent() && contractNumber.isPresent())
            throw new InvalidContractParamException("Can't have contractId and contractNumber in the same call");
        else if (contractId.isPresent())
                return contractService.getContractByContractId(contractId.get());
        else if (contractNumber.isPresent())
            return contractService.getContractByContractNumber(contractNumber.get());
        else {
            throw new InvalidContractParamException("Must supply contract information");
        }
    }
}
