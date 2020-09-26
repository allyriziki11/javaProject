package javamysqldb;

//step1: import required packages
import java.sql.*;

/**
 *
 * @author KEDS
 * jdbc:mysql://localhost:3306/keds
 */
public class Main {
           // JDBC DRIVER NAME and Database URL
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost:3306/keds";

        //Database credentials
        static final String USER = "root";
        static final String PASS = "Rizi_2176";

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        try{
           //step2: register jdbc driver
            Class.forName("com.mysql.jdbc.Driver");

            //step3: open connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //step4: execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, name, sex FROM person";
            ResultSet rs = stmt.executeQuery(sql);

            //step5: extract data from results
            while(rs.next()){
               //retrieve by column
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String sex = rs.getString("sex");

                //display values
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Sex: " + sex);

                //step6: cleanup enviroment
                rs.close();
                stmt.close();
                conn.close();
            }
        }catch(SQLException se){
            //Handles errors for JDBC
          se.printStackTrace();
        }catch(Exception e){
          //handles error for class for name
            e.printStackTrace();
        }finally{
           //finally block used to close resources
            try{
              if(stmt != null)
                  stmt.close();
            }catch(SQLException se){
              se.printStackTrace();
            }
        }
    }

}
