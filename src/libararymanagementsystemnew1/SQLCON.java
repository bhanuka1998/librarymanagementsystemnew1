package libararymanagementsystemnew1;

import java.sql.*;
import java.sql.DriverManager;

/**
 *
 * @author Acer
 */
public class SQLCON {
    public static Connection connect(){
        
        
         Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_managment_system", "root","");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return conn;
    }
    }

