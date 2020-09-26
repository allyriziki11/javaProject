//import libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
//extend HttpServlet class
public class MyServlet extends HttpServlet {
    private String message;
    public void init()throws ServletException{
        //do required initialization
       message = "Hello world...!";
    }
   
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<h1>" + message + "</h1>" + "<h2>Welcome to my first servlet application</h2>");
        } finally { 
            out.close();
        }
    }
    public void detsroy(){
      //do nothing...
    }
}
