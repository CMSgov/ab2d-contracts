package gov.cms.ab2d.contracts;

import gov.cms.ab2d.contracts.util.AB2DSQSMockConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"gov.cms.ab2d.contracts", "gov.cms.ab2d.eventclient.clients"})
@EntityScan(basePackages = {"gov.cms.ab2d.contracts"})
@EnableJpaRepositories("gov.cms.ab2d.contracts.repository")
@PropertySource("classpath:application.properties")
@Import(AB2DSQSMockConfig.class)
public class SpringBootTestApp {

    public static void main(String [] args) {
        SpringApplication.run(SpringBootTestApp.class, args);
    }
}
