import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private static final String DRUGS_FILE = "drugs.txt";
    
    // Save drugs to text file
    public static void saveDrugsToFile(List<Drug> drugs) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DRUGS_FILE))) {
            for (Drug drug : drugs) {
                writer.println(drug.getDrugId() + "," + 
                              drug.getDrugName() + "," + 
                              drug.getDrugCost() + "," + 
                              drug.getDosage());
            }
            System.out.println("Drugs saved to file successfully!");
        } catch (IOException e) {
            System.err.println("Error saving drugs to file: " + e.getMessage());
        }
    }
    
    // Read drugs from text file
    public static List<Drug> readDrugsFromFile() {
        List<Drug> drugs = new ArrayList<>();
        File file = new File(DRUGS_FILE);
        
        if (!file.exists()) {
            System.out.println("No drugs file found.");
            return drugs;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(DRUGS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int drugId = Integer.parseInt(parts[0]);
                    String drugName = parts[1];
                    double drugCost = Double.parseDouble(parts[2]);
                    String dosage = parts[3];
                    
                    drugs.add(new Drug(drugId, drugName, drugCost, dosage));
                }
            }
            System.out.println("Drugs loaded from file successfully!");
        } catch (IOException e) {
            System.err.println("Error reading drugs from file: " + e.getMessage());
        }
        
        return drugs;
    }
}