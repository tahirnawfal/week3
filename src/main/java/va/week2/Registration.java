package va.week2;

import java.io.Serializable;

public class Registration implements Serializable {
    private String firstName;
    private String lastName;
    private String studentId;
    private String email;
    private String postalCode;
    
    // These are the missing pieces causing your 7 errors:
    private String username;
    private String password;
    private String mobileNumber;
    private String date;

    public Registration() {}

    // Existing getters/setters...
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    // Add these missing ones:
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}