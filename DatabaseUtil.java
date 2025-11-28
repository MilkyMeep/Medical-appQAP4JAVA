import java.sql.*;

public class DatabaseUtil {
    private static final String URL = "jdbc:postgresql://localhost:5432/medical_db";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public static void initializeDatabase() {
        String createDrugsTable = """
            CREATE TABLE IF NOT EXISTS drugs (
                drug_id SERIAL PRIMARY KEY,
                drug_name VARCHAR(100) NOT NULL,
                drug_cost DECIMAL(10,2) NOT NULL,
                dosage VARCHAR(50)
            )
            """;
            
        String createPatientsTable = """
            CREATE TABLE IF NOT EXISTS patients (
                patient_id SERIAL PRIMARY KEY,
                first_name VARCHAR(50) NOT NULL,
                last_name VARCHAR(50) NOT NULL,
                date_of_birth DATE NOT NULL
            )
            """;
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            
            stmt.execute(createDrugsTable);
            stmt.execute(createPatientsTable);
            System.out.println("Database tables initialized successfully!");
            
        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }
}