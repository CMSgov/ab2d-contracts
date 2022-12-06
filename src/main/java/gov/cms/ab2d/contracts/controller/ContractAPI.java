package gov.cms.ab2d.contracts.controller;

import gov.cms.ab2d.contracts.model.Contract;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface ContractAPI {
    @GetMapping("/contract/all")
    List<Contract> getAllAttestedContracts();

    @PostMapping("/contract")
    void updateContract(@RequestBody Contract contract);

    @GetMapping("/contract")
    Contract getContractByValue(@RequestParam("contractId") Optional<Long> contractId, @RequestParam("contractNumber") Optional<String> contractNumber);
}
