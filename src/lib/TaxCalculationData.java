package lib;

public final class TaxCalculationData {
    private final int monthlySalary;
    private final int otherMonthlyIncome;
    private final int numberOfMonthWorking;
    private final int deductible;
    private final boolean isMarried;
    private final int numberOfChildren;

    public TaxCalculationData(int monthlySalary, int otherMonthlyIncome, 
                            int numberOfMonthWorking, int deductible,
                            boolean isMarried, int numberOfChildren) {
        this.monthlySalary = monthlySalary;
        this.otherMonthlyIncome = otherMonthlyIncome;
        this.numberOfMonthWorking = numberOfMonthWorking;
        this.deductible = deductible;
        this.isMarried = isMarried;
        this.numberOfChildren = numberOfChildren;
    }

    public int monthlySalary() { return monthlySalary; }
    public int otherMonthlyIncome() { return otherMonthlyIncome; }
    public int numberOfMonthWorking() { return numberOfMonthWorking; }
    public int deductible() { return deductible; }
    public boolean isMarried() { return isMarried; }
    public int numberOfChildren() { return numberOfChildren; }
}