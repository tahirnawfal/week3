package va.week2;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation for handling Student Registration and Database Persistence
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 1. Capture all parameters from RegistrationPage.jsp
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String mobileNumber = request.getParameter("mobileNumber");
        String email = request.getParameter("email");
        String date = request.getParameter("date");
        String studentId = request.getParameter("studentId");
        String postalCode = request.getParameter("postalCode");

        // 2. Populate the Model object
        Registration reg = new Registration();
        reg.setFirstName(firstName);
        reg.setLastName(lastName);
        reg.setUsername(username);
        reg.setPassword(password);
        reg.setMobileNumber(mobileNumber);
        reg.setEmail(email);
        reg.setDate(date);
        reg.setStudentId(studentId);
        reg.setPostalCode(postalCode);

        // 3. Server-side validation (matching client-side constraints)
        boolean isValid = true;
        if (username == null || username.length() > 10) isValid = false;
        if (mobileNumber == null || !mobileNumber.matches("\\d{10}")) isValid = false;
        if (studentId == null || !studentId.matches("\\d{9}")) isValid = false;

        if (isValid) {
            // 4. Call DAO for Database Operations [cite: 33, 35, 36]
            RegisterDao dao = new RegisterDao();
            try {
                int result = dao.registerStudent(reg);
                
                if (result > 0) {
                    out.println("<html><body>");
                    out.println("<h2 style='color:green'>Registration Successful for " + username + "!</h2>");
                    out.println("<p>Student record has been saved to the database.</p>");
                    out.println("<a href='RegistrationPage.jsp'>Back to Form</a>");
                    out.println("</body></html>");
                } else {
                    out.println("<h2 style='color:red'>Database Error: Could not save record.</h2>");
                }
            } catch (Exception e) {
                out.println("<h2 style='color:red'>Error: " + e.getMessage() + "</h2>");
                e.printStackTrace();
            }
        } else {
            out.println("<h2 style='color:red'>Validation Failed! Please check your input format.</h2>");
            out.println("<a href='RegistrationPage.jsp'>Try Again</a>");
        }
    }
}