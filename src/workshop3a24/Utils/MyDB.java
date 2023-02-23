
package workshop3a24.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohamed
 */
public class MyDB {
    final String URL ="jdbc:mysql://127.0.0.1:3306/3a24";
    final String USERNAME="root";
    final String PWD ="";
   private  Connection cnx;
 private static   MyDB instance;
    private MyDB(){
        try {
            cnx =DriverManager.getConnection(URL, USERNAME, PWD);
            System.out.println("connected ....");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public static MyDB getInstance (){
        if (instance == null)
            instance = new MyDB();
        return instance ;
    }
    public Connection getCnx(){
        return cnx;
    }
    
    
}
