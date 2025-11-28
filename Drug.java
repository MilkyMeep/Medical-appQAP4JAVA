import java.io.Serializable;

public class Drug implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int drugId;
    private String drugName;
    private double drugCost;
    private String dosage;
    
    public Drug(int drugId, String drugName, double drugCost, String dosage) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugCost = drugCost;
        this.dosage = dosage;
    }
    
    // Getters
    public int getDrugId() { return drugId; }
    public String getDrugName() { return drugName; }
    public double getDrugCost() { return drugCost; }
    public String getDosage() { return dosage; }
    
    @Override
    public String toString() {
        return String.format("Drug{drugId=%d, drugName='%s', drugCost=%.2f, dosage='%s'}",
                drugId, drugName, drugCost, dosage);
    }
}