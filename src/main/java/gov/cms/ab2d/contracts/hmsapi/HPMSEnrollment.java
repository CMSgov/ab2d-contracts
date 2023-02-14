package gov.cms.ab2d.contracts.hmsapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor  // Needed for Jackson
@AllArgsConstructor
public class HPMSEnrollment {
    private String enrollmentYear;
    private String enrollmentMonth;
    private String contractId;
    private String totalEnrollment;
    private String medicareEligible;

    public HPMSEnrollment(int enrollmentYear, int enrollmentMonth, String contractId, int totalEnrollment, int medicareEligible) {
        this.enrollmentYear = "" + enrollmentYear;
        this.enrollmentMonth = "" + enrollmentMonth;
        this.contractId = contractId;
        this.totalEnrollment = "" + totalEnrollment;
        this.medicareEligible = "" + medicareEligible;
    }
    public int getEnrollmentMonthInt() {
        return getInt(enrollmentMonth);
    }

    public int getEnrollmentYearInt() {
        return getInt(enrollmentYear);
    }

    public int getTotalEnrollmentInt() {
        return getInt(totalEnrollment);
    }

    public int getMedicareEligibleInt() {
        return getInt(medicareEligible);
    }

    private int getInt(String val) {
        try {
            return Integer.parseInt(val);
        } catch (Exception ex) {
            return 0;
        }
    }
}
