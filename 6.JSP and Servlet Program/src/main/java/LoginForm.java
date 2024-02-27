import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginForm")
public class LoginForm extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// Retrieve user input from the login form
String username = request.getParameter("username");
String password = request.getParameter("password");
// Set content type of the response
response.setContentType("text/html");
// Get PrintWriter object to write HTML response
PrintWriter out = response.getWriter();
// Hardcoded values for username and password
String validUsername = "bishow";
String validPassword = "admin";
// Check if the entered username and password match the hardcoded values
if (validUsername.equals(username) && validPassword.equals(password)) {
// Authentication successful
out.println("<html><body>");
out.println("<h2>Login Successful</h2>");
out.println("<p>Welcome, " + username + "!</p>");
out.println("</body></html>");
} else {
// Authentication failed
out.println("<html><body>");
out.println("<h2>Login Failed</h2>");
out.println("<p>Invalid username or password.</p>");
out.println("</body></html>");
}
}
}

