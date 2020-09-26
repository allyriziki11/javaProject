//import libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

//extend HttpServelet class
public class FormData extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            //set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Using GET method to read form data";
        String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0" + "Transitional//EN\">\n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor= \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "<li><b>First name</b>: "
                + request.getParameter("first_name") + "\n" +
                "<li><b>Last name</b>: "
                + request.getParameter("last_name") + "\n" +
                "<ul>\n" +
                "</body>" +
                "</html>"
                );
    }
}
