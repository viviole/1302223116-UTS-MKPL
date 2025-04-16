package lib;

public final class TaxConstants {
    
    // Penghasilan Tidak Kena Pajak
    public static final int BASE_NON_TAXABLE_INCOME = 54_000_000; // PTKP dasar
    public static final int MARRIED_DEDUCTION = 4_500_000; // Tambahan jika sudah menikah
    public static final int PER_CHILD_DEDUCTION = 1_500_000; // Per anak (max 3)
    public static final int MAX_DEDUCTIBLE_CHILDREN = 3; // Batas maksimal anak yang diakui

    // Parameter Pajak
    public static final double TAX_RATE = 0.05; // Tarif pajak 5%
}