package lib;

public class PersonalInfo {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
    private boolean isForeigner;
    private Employee.Gender gender;

    public PersonalInfo(String employeeId, String firstName, String lastName, String idNumber,
                        String address, boolean isForeigner, boolean isMale) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.isForeigner = isForeigner;
        this.gender = isMale ? Employee.Gender.MALE : Employee.Gender.FEMALE;
    }

    public boolean isForeigner() {
        return isForeigner;
    }
}
