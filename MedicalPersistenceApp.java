import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalPersistenceApp {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Drug> drugs = new ArrayList<>();
    
    public static void main(String[] args) {
        // Test database connection
        System.out.println("Testing database connection...");
        DatabaseService.testConnection();
        
        showMenu();
    }
    
    private static void showMenu() {
        while (true) {
            System.out.println("\n=== Medical Persistence System ===");
            System.out.println("1. Save drugs to file");
            System.out.println("2. Read drugs from file");
            System.out.println("3. Save patient to database");
            System.out.println("4. Read patients from database");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    saveDrugsToFile();
                    break;
                case 2:
                    readDrugsFromFile();
                    break;
                case 3:
                    savePatientToDatabase();
                    break;
                case 4:
                    readPatientsFromDatabase();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
    
    private static void saveDrugsToFile() {
        if (drugs.isEmpty()) {
            addSampleDrugs();
        }
        FileService.saveDrugsToFile(drugs);
    }
    
    private static void readDrugsFromFile() {
        List<Drug> drugsFromFile = FileService.readDrugsFromFile();
        if (drugsFromFile.isEmpty()) {
            System.out.println("No drugs found in file.");
        } else {
            System.out.println("\n=== Drugs from File ===");
            for (Drug drug : drugsFromFile) {
                System.out.println(drug);
            }
        }
    }
    
    private static void savePatientToDatabase() {
        System.out.print("Enter patient first name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Enter patient last name: ");
        String lastName = scanner.nextLine();
        
        System.out.print("Enter patient date of birth (YYYY-MM-DD): ");
        String dobString = scanner.nextLine();
        
        DatabaseService.savePatientToDatabase(firstName, lastName, dobString);
    }
    
    private static void readPatientsFromDatabase() {
        List<Patient> patientsFromDB = DatabaseService.readPatientsFromDatabase();
        if (patientsFromDB.isEmpty()) {
            System.out.println("No patients found in database.");
        } else {
            System.out.println("\n=== Patients from Database ===");
            for (Patient patient : patientsFromDB) {
                System.out.println(patient);
            }
        }
    }
    
    private static void addSampleDrugs() {
        drugs.add(new Drug(1, "Aspirin", 5.99, "500mg"));
        drugs.add(new Drug(2, "Ibuprofen", 8.49, "400mg"));
        drugs.add(new Drug(3, "Vitamin C", 12.99, "1000mg"));
        System.out.println("Sample drugs added for demonstration.");
    }
}