package gov.cms.ab2d.contracts.controller;

import gov.cms.ab2d.contracts.model.Contract;
import gov.cms.ab2d.contracts.model.ContractDTO;
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
    public List<ContractDTO> getContracts(Long contractId) {
        if(contractId != null) {
            ArrayList<ContractDTO> contracts = new ArrayList<>();
            contracts.add(contractService.getContractByContractId(contractId).toDTO());
            return contracts;
        }
        return contractService.getAllContracts();
    }

    @Override
    public void updateContract(@RequestBody ContractDTO contract) {
        contractService.updateContract(contract);
    }

    @Override
    public List<ContractDTO> getContractByNumber(String contractNumber) {
        if (contractNumber != null) {
            ArrayList<ContractDTO> contracts = new ArrayList<>();
            contracts.add(contractService.getContractByContractNumber(contractNumber).toDTO());
            return contracts;
        }
        throw new InvalidContractParamException("Must supply contract information");

    }
}
