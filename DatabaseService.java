import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {
    private static final String URL = "jdbc:postgresql://localhost:5432/medical_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password123";
    
    // Save patient to database
    public static void savePatientToDatabase(String firstName, String lastName, String dobString) {
        String sql = "INSERT INTO patients (first_name, last_name, date_of_birth) VALUES (?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setDate(3, Date.valueOf(dobString));
            
            pstmt.executeUpdate();
            System.out.println("Patient saved to database successfully!");
            
        } catch (SQLException e) {
            System.err.println("Error saving patient to database: " + e.getMessage());
        }
    }
    
    // Read patients from database
    public static List<Patient> readPatientsFromDatabase() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Patient patient = new Patient(
                    rs.getInt("patient_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getDate("date_of_birth").toLocalDate()
                );
                patients.add(patient);
            }
            System.out.println("Patients loaded from database successfully!");
            
        } catch (SQLException e) {
            System.err.println("Error reading patients from database: " + e.getMessage());
        }
        
        return patients;
    }
    
    // Test database connection
    public static boolean testConnection() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Database connection successful!");
            return true;
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
            return false;
        }
    }
}