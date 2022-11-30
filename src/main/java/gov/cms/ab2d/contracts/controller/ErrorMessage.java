package gov.cms.ab2d.contracts.controller;

import java.util.Date;
import lombok.Builder;
import lombok.Data;
import org.joda.time.DateTime;

@Data
@Builder
public class ErrorMessage {
    private Date timestamp;
    private String path;
    private int code;
    private String message;
}
