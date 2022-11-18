package gov.cms.ab2d.hpms.service;

import gov.cms.ab2d.hpms.hmsapi.HPMSAttestation;
import gov.cms.ab2d.hpms.hmsapi.HPMSOrganizationInfo;
import java.net.URI;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@Service
public class HPMSFetcherImpl extends AbstractHPMSService implements HPMSFetcher {

    //https://confluence.cms.gov/display/HPMSMCTAPI/CDA+CY+2022+API+Data+Contract+and+Validations#CDACY2022APIDataContractandValidations-GetAttestationHistoryforContracts
    @Value("${hpms.base.path}")
    private String hpmsBasePath;

    @Value("${hpms.base.url}")
    private String hpmsBaseURI;

    private URI organizationBaseUri;
    private URI attestationBaseUri;

    private final HPMSAuthService authService;

    private final WebClient webClient;

    @Autowired
    public HPMSFetcherImpl(HPMSAuthService authService, WebClient webClient) {
        this.authService = authService;
        this.webClient = webClient;
    }

    @PostConstruct
    private void buildURI() {
        organizationBaseUri = UriComponentsBuilder.fromUriString(hpmsBaseURI + hpmsBasePath + "/orgs/info").build().toUri();
        attestationBaseUri = UriComponentsBuilder.fromUriString(hpmsBaseURI + hpmsBasePath + "/contracts/status").build().toUri();
    }

    @Override
    public void retrieveSponsorInfo(Consumer<List<HPMSOrganizationInfo>> hpmsOrgCallback) {
        Mono<List<HPMSOrganizationInfo>> orgInfoMono = webClient
                .get().uri(organizationBaseUri)
                .headers(authService::buildAuthHeaders)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });

        orgInfoMono.subscribe(hpmsOrgCallback);
    }

    @Override
    public void retrieveAttestationInfo(Consumer<Set<HPMSAttestation>> hpmsAttestationCallback, List<String> contractIds) {
        Mono<Set<HPMSAttestation>> contractsMono = webClient
                .get().uri(buildAttestationURI(contractIds))
                .headers(authService::buildAuthHeaders)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });

        contractsMono.subscribe(hpmsAttestationCallback);
    }

    private URI buildAttestationURI(List<String>  contractIds) {
        return UriComponentsBuilder
                .fromUri(attestationBaseUri)
                .queryParam("contractId", contractIds)
                .build().toUri();
    }
}
