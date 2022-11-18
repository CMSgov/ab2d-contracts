package gov.cms.ab2d.contracts.quartz;

import gov.cms.ab2d.contracts.service.AttestationUpdaterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;



@Slf4j
@RequiredArgsConstructor
@DisallowConcurrentExecution
public class HPMSIngestJob extends QuartzJobBean {

    private final AttestationUpdaterService aus;
//    private final PropertiesAPIService propertiesApiService;

    @SuppressWarnings("NullableProblems")
    @Override
    protected void executeInternal(JobExecutionContext context) {
        // todo additionally filter hpms engagement by tracking the environment ab2d is running in.
        //      if the environment is not sandbox or prod do not poll hpms
//        if (FeatureEngagement.IN_GEAR == getEngagement()) {
//            aus.pollOrganizations();
//        }
    }

//    public FeatureEngagement getEngagement() {
//        return FeatureEngagement.fromString(propertiesApiService.getProperty(HPMS_INGESTION_ENGAGEMENT));
//    }
}
