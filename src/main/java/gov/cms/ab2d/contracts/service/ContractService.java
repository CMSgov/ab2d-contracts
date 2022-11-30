package gov.cms.ab2d.contracts.service;

import gov.cms.ab2d.contracts.model.Contract;
import java.util.List;
import java.util.Optional;

public interface ContractService {
    void updateContract(Contract contract);
    List<Contract> getAllContracts();
    Contract getContractByContractId(Long contractId);
    Contract getContractByContractNumber(String contractNumber);
}
