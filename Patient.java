import java.time.LocalDate;

public class Patient {
    private int patientId;
    private String patientFirstName;
    private String patientLastName;
    private LocalDate patientDOB;
    
    public Patient(int patientId, String patientFirstName, String patientLastName, LocalDate patientDOB) {
        this.patientId = patientId;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.patientDOB = patientDOB;
    }
    
    // Getters
    public int getPatientId() { return patientId; }
    public String getPatientFirstName() { return patientFirstName; }
    public String getPatientLastName() { return patientLastName; }
    public LocalDate getPatientDOB() { return patientDOB; }
    
    @Override
    public String toString() {
        return String.format("Patient{patientId=%d, patientFirstName='%s', patientLastName='%s', patientDOB=%s}",
                patientId, patientFirstName, patientLastName, patientDOB);
    }
}