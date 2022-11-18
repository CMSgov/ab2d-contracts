package gov.cms.ab2d.contracts.repository;

import gov.cms.ab2d.contracts.model.Property;
import java.util.Optional;
import java.util.Properties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertiesRepository extends JpaRepository<Property, Long> {

    Optional<Property> findByKey(String key);
}
