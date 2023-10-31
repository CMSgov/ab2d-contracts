package gov.cms.ab2d.contracts.service;

public class HPMSRemoteTimeoutException extends IllegalStateException {

    public HPMSRemoteTimeoutException(String message) {
        super(message);
    }

}