package gov.cms.ab2d.contracts.controller;

import gov.cms.ab2d.contracts.model.Contract;
import gov.cms.ab2d.contracts.service.ContractService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ContractController implements ContractAPI {
    private final ContractService contractService;

    @Override
    public List<Contract> getContracts(Optional<Long> contractId) {
        if(contractId.isPresent()) {
            ArrayList<Contract> contracts = new ArrayList<>();
            contracts.add(contractService.getContractByContractId(contractId.get()));
            return contracts;
        }
        return contractService.getAllContracts();
    }

    @Override
    public void updateContract(@RequestBody Contract contract) {
        contractService.updateContract(contract);
    }

    @Override
    public List<Contract> getContractByNumber(Optional<String> contractNumber) {
        if (contractNumber.isPresent()) {
            ArrayList<Contract> contracts = new ArrayList<>();
            contracts.add(contractService.getContractByContractNumber(contractNumber.get()));
            return contracts;
        }
        throw new InvalidContractParamException("Must supply contract information");

    }
}
