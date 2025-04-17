package lib;

import java.time.LocalDate;

public class EmploymentInfo {
    private static final int GRADE_1_SALARY = 3_000_000;
    private static final int GRADE_2_SALARY = 5_000_000;
    private static final int GRADE_3_SALARY = 7_000_000;
    private static final double FOREIGNER_SALARY_MULTIPLIER = 1.5;

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
            case 1:
                baseSalary = GRADE_1_SALARY;
                break;
            case 2:
                baseSalary = GRADE_2_SALARY;
                break;
            case 3:
                baseSalary = GRADE_3_SALARY;
                break;
            default:
                throw new IllegalArgumentException("Invalid grade: " + grade);
        }
        this.monthlySalary = isForeigner ? (int) (baseSalary * FOREIGNER_SALARY_MULTIPLIER) : baseSalary;
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