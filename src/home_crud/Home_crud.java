
package home_crud;
import java.sql.*;
        
/**
 *
 * @author kuznetsova_a
 */
public class Home_crud {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException  {
        //выкидывает ошибку 
        Class.forName("org.postgresql.Driver");
        // 
        Connection connection = null;
        try {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "enot666");
        Statement start = connection.createStatement();
        ResultSet rs = start.executeQuery("select product_no, name,price, cnt from store;");
        while(rs.next()){System.out.println(rs.getLong("product_no") + rs.getLong("name") 
        + rs.getLong("price")+ rs.getLong("cnt") );}       
        
        }
        catch(SQLException e){e.printStackTrace();}
        finally{
        try{connection.close();}catch(SQLException e)
        {e.printStackTrace();}
        }
        
        
        
    }
    
}
