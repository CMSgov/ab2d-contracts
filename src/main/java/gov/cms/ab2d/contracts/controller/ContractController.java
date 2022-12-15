package gov.cms.ab2d.contracts.controller;

import gov.cms.ab2d.contracts.model.ContractAPI;
import gov.cms.ab2d.contracts.model.ContractDTO;
import gov.cms.ab2d.contracts.service.ContractService;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ContractDTO getContractByNumber(String contractNumber) {
        if (contractNumber != null) {
            return contractService.getContractByContractNumber(contractNumber).toDTO();
        }
        throw new InvalidContractParamException("Must supply contract information");

    }
}
