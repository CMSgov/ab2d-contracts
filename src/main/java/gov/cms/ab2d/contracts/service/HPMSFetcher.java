package gov.cms.ab2d.contracts.service;

import gov.cms.ab2d.contracts.hmsapi.HPMSAttestation;
import gov.cms.ab2d.contracts.hmsapi.HPMSOrganizationInfo;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public interface HPMSFetcher {

    void retrieveSponsorInfo(Consumer<List<HPMSOrganizationInfo>> hpmsOrgCallback);

    void retrieveAttestationInfo(Consumer<Set<HPMSAttestation>> hpmsAttestationCallback, List<String> contractIds);
}
