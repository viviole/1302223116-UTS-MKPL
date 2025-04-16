package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	
	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
		
		if (numberOfMonthWorking > TaxConstants.MONTHS_IN_YEAR) {
			System.err.println("More than 12 month working per year");
		}
		
		if (numberOfChildren > TaxConstants.MAX_DEDUCTIBLE_CHILDREN) {
			numberOfChildren = TaxConstants.MAX_DEDUCTIBLE_CHILDREN;
		}
		
		int tax;
		if (isMarried) {
			tax = (int) Math.round(TaxConstants.TAX_RATE * 
			(((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - 
			deductible - (TaxConstants.BASE_NON_TAXABLE_INCOME + 
			TaxConstants.MARRIED_DEDUCTION + (numberOfChildren * 
			TaxConstants.PER_CHILD_DEDUCTION))));
		}else {
			tax = (int) Math.round(TaxConstants.TAX_RATE * 
			(((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - 
			 deductible - 
			 TaxConstants.BASE_NON_TAXABLE_INCOME));
		}
		
		return Math.max(tax, 0);
			 
	}
	
}
