package gov.cms.ab2d.contracts.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@Table(name = "properties", schema = "property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "propertiesSequenceGenerator")
    @SequenceGenerator(name = "propertiesSequenceGenerator",
            sequenceName = "property.property_sequence",
            allocationSize = 1)
    private Long id;

    @NotNull
    private String key;

    @NotNull
    private String value;

    @CreationTimestamp
    private OffsetDateTime created;

    @UpdateTimestamp
    private OffsetDateTime modified;
}
