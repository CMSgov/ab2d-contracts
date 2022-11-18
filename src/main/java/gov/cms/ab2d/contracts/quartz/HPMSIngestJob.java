package gov.cms.ab2d.contracts.quartz;

import com.amazonaws.services.sns.model.ResourceNotFoundException;
import gov.cms.ab2d.contracts.model.Property;
import gov.cms.ab2d.contracts.repository.PropertiesRepository;
import gov.cms.ab2d.contracts.service.AttestationUpdaterService;
import gov.cms.ab2d.contracts.service.FeatureEngagement;
import gov.cms.ab2d.properties.client.PropertiesClient;
import gov.cms.ab2d.properties.client.PropertiesClientImpl;
import java.util.Optional;
import java.util.Properties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.quartz.QuartzJobBean;



@Slf4j
@RequiredArgsConstructor
@DisallowConcurrentExecution
public class HPMSIngestJob extends QuartzJobBean {
    public static final String HPMS_INGESTION_ENGAGEMENT = "hpms.ingest.engaged";
    private final AttestationUpdaterService aus;
    private final PropertiesRepository propertiesRepository;

    @Value("${property.service.url}")
    private String propertyServiceUrl;

    @Value("${feature.property.service.enabled}")
    private boolean propertiesFlag;

    private final PropertiesClient propertiesClient = new PropertiesClientImpl(propertyServiceUrl);


    @SuppressWarnings("NullableProblems")
    @Override
    protected void executeInternal(JobExecutionContext context) {
        // todo additionally filter hpms engagement by tracking the environment ab2d is running in.
        //      if the environment is not sandbox or prod do not poll hpms
        if (FeatureEngagement.IN_GEAR == getEngagement()) {
            aus.pollOrganizations();
        }
    }

    public FeatureEngagement getEngagement() {
        if(propertiesFlag) {
            //TODO Enable when properties service is available
            return FeatureEngagement.fromString(propertiesClient.getProperty(HPMS_INGESTION_ENGAGEMENT).toString());
        }
        else {
            //TODO Delete when properties service is available
            return FeatureEngagement.fromString(propertiesRepository.findByKey(HPMS_INGESTION_ENGAGEMENT).toString());
        }
    }
}
