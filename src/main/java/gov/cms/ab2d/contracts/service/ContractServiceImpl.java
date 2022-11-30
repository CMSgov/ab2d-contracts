package gov.cms.ab2d.contracts.service;

import gov.cms.ab2d.contracts.controller.InvalidContractException;
import gov.cms.ab2d.contracts.model.Contract;
import gov.cms.ab2d.contracts.repository.ContractRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;


import static java.util.stream.Collectors.toList;

@AllArgsConstructor
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;

    @Override
    public void updateContract(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll()
                .stream().filter(Contract::hasAttestation).collect(toList());
    }

    @Override
    public Contract getContractByContractId(Long contractId) {
        Optional<Contract> contract = contractRepository.findById(contractId);
        if (contract.isPresent()) {
            return contract.get();
        }

        throw new InvalidContractException("Invalid Contract Given");
    }

    @Override
    public Contract getContractByContractNumber(String contractNumber) {
        Optional<Contract> contract = contractRepository.findContractByContractNumber(contractNumber);

        if (contract.isPresent()) {
            return contract.get();
        }
        throw new InvalidContractException("Invalid Contract Given");
    }
}
