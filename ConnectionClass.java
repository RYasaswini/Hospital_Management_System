
package Hospital;

import java.sql.*;

public class ConnectionClass 
{
    Connection con;
    Statement stm;
    
    public ConnectionClass()
    {
        try
        {
            // Corrected the class loading statement
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Corrected the connection string and exception handling
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management", "Hospital", "Yashu@1234#");
            stm = con.createStatement();
            System.out.println("Connection successful");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        new ConnectionClass();
    }
}
