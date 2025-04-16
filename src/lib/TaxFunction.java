package lib;

public class TaxFunction {
	
	public static int calculateTax(TaxCalculationData data) {
        if (data.numberOfMonthWorking() > 12) {
            System.err.println("More than 12 month working per year");
        }
        int taxableIncome = calculateTaxableIncome(data);
        return calculateFinalTax(taxableIncome);
    }

    private static int calculateTaxableIncome(TaxCalculationData data) {
        int grossIncome = calculateGrossIncome(data);
        int nonTaxableIncome = calculateNonTaxableIncome(data);
        return grossIncome - data.deductible() - nonTaxableIncome;
    }

    private static int calculateGrossIncome(TaxCalculationData data) {
        return (data.monthlySalary() + data.otherMonthlyIncome()) * data.numberOfMonthWorking();
    }

    private static int calculateNonTaxableIncome(TaxCalculationData data) {
        int nonTaxable = TaxConstants.BASE_NON_TAXABLE_INCOME;
        
        if (data.isMarried()) {
            nonTaxable += TaxConstants.MARRIED_DEDUCTION;
        }
        
        int childrenCount = Math.min(data.numberOfChildren(), TaxConstants.MAX_DEDUCTIBLE_CHILDREN);
        nonTaxable += childrenCount * TaxConstants.PER_CHILD_DEDUCTION;
        
        return nonTaxable;
    }

    private static int calculateFinalTax(int taxableIncome) {
        int tax = (int) Math.round(TaxConstants.TAX_RATE * taxableIncome);
        return Math.max(tax, 0);
    }
}
