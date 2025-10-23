
import java.sql.Driver;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GlobalDB {
    static Driver d;
    static Connection con;
    static Statement stmt;
    
    public static void createConnection(){
        
        try {
            d = new oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver(d);
            
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","Jayesh");
            
            stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(GlobalDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void nonSelect(String query){
        try {
            stmt.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Error in Query"+ex.getMessage());
            Logger.getLogger(GlobErroralDB.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public static void closeConnection(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(GlobalDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
