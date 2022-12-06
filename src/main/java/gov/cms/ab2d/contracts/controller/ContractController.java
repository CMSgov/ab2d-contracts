package gov.cms.ab2d.contracts.controller;

import gov.cms.ab2d.contracts.model.Contract;
import gov.cms.ab2d.contracts.service.ContractService;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
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
    public Contract getContractByNumber(@RequestParam("contractNumber") Optional<String> contractNumber) {
        if (contractNumber.isPresent())
            return contractService.getContractByContractNumber(contractNumber.get());
        throw new InvalidContractParamException("Must supply contract information");

    }

    @Override
    public Contract getContractByID(Optional<Long> contractId) {
        if(contractId.isPresent())
            return contractService.getContractByContractId(contractId.get());
        throw new InvalidContractParamException("Must supply contract information");
    }
}
