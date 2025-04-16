package lib;

public class Employee {

    public enum Gender {
        MALE, FEMALE
    }

    private PersonalInfo personalInfo;
    private EmploymentInfo employmentInfo;
    private FamilyInfo familyInfo;

    public static class Child {
        private String name;
        private String idNumber;

        public Child(String name, String idNumber) {
            this.name = name;
            this.idNumber = idNumber;
        }
    }

    public Employee(PersonalInfo personalInfo, EmploymentInfo employmentInfo) {
		this.personalInfo = personalInfo;
		this.employmentInfo = employmentInfo;
		this.familyInfo = new FamilyInfo();
	}
	

    public void setMonthlySalary(int grade) {
        employmentInfo.setMonthlySalary(grade, personalInfo.isForeigner());
    }

    public void setAnnualDeductible(int deductible) {
        employmentInfo.setAnnualDeductible(deductible);
    }

    public void setAdditionalIncome(int income) {
        employmentInfo.setAdditionalIncome(income);
    }

    public void setSpouse(String name, String id) {
        familyInfo.setSpouse(name, id);
    }

    public void addChild(String name, String id) {
        familyInfo.addChild(name, id);
    }

    public int getAnnualIncomeTax() {
        return TaxFunction.calculateTax(
                employmentInfo.getMonthlySalary(),
                employmentInfo.getOtherMonthlyIncome(),
                employmentInfo.calculateMonthsWorkedThisYear(),
                employmentInfo.getAnnualDeductible(),
                !familyInfo.hasSpouse(),
                familyInfo.getNumberOfChildren()
        );
    }
}
