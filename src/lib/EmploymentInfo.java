package lib;

import java.time.LocalDate;

public class EmploymentInfo {
    private LocalDate joinDate;
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    public EmploymentInfo(int year, int month, int day) {
        this.joinDate = LocalDate.of(year, month, day);
    }

    public void setMonthlySalary(int grade, boolean isForeigner) {
        int baseSalary;
        switch (grade) {
            case 1: baseSalary = 3000000; break;
            case 2: baseSalary = 5000000; break;
            case 3: baseSalary = 7000000; break;
            default:
                throw new IllegalArgumentException("Invalid grade: " + grade);
        }
        this.monthlySalary = isForeigner ? (int) (baseSalary * 1.5) : baseSalary;
    }

    public void setAdditionalIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public int calculateMonthsWorkedThisYear() {
        LocalDate now = LocalDate.now();
        return (now.getYear() == joinDate.getYear())
                ? Math.max(0, now.getMonthValue() - joinDate.getMonthValue())
                : 12;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public int getOtherMonthlyIncome() {
        return otherMonthlyIncome;
    }

    public int getAnnualDeductible() {
        return annualDeductible;
    }
}