package lib;

public class PersonalInfo {
    private String employeeId;
    private String idNumber;
    private boolean isForeigner;

    public PersonalInfo(String employeeId, String idNumber, boolean isForeigner) {
        this.employeeId = employeeId;
        this.idNumber = idNumber;
        this.isForeigner = isForeigner;
    }

    public boolean isForeigner() {
        return isForeigner;
    }
}
