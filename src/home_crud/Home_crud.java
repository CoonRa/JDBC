
package home_crud;
import java.sql.*;
import javax.swing.*;
        
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
    Connection c;
    Statement stmt;
        
    try {
    c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "enotnik666");
    c.setAutoCommit(false);
    String sql;
 

     
    // ввод данных 
    stmt = c.createStatement();
    sql = "INSERT INTO STORE (PRODUCT_NO,NAME,PRICE,CNT) VALUES (5, 'Коврик мышиный арт. 1', 100, 10);";
    stmt.executeUpdate(sql);
    stmt.close();
    c.commit();
    System.out.println("Успешно добавлен товар");
    
    
    // обновление данных
    stmt = c.createStatement();
    sql = "UPDATE STORE set PRICE = 110 where PRODUCT_NO = 5;";
    stmt.executeUpdate(sql);
    c.commit();
    stmt.close();
    System.out.println("Успешно изменен товар");
    
    //вывод данных 
    stmt = c.createStatement();
    ResultSet rs = stmt.executeQuery( "SELECT PRODUCT_NO, NAME, PRICE, CNT FROM STORE;" );
    while(rs.next()){
            int product_no = rs.getInt("product_no");
            String  name = rs.getString("name");
            float price = rs.getFloat("price");
            int cnt = rs.getInt("cnt");      
            
            System.out.println(product_no + " " + name + " " + price + " руб. " + cnt + " шт.");
        
        }  
    
     rs.close();
     stmt.close();
     c.commit();

 
    //удаление  
    stmt = c.createStatement();
        sql = "DELETE from store where PRODUCT_NO = 5;";
        stmt.executeUpdate(sql);
        c.commit();
        stmt.close();
        System.out.println("Успешно удален товар");

     }
        catch(SQLException e){e.printStackTrace();}
 // Почему ругается, что переменная с не может быть инициализирована?
   finally{
        try{c.close();}catch(SQLException e)
        {e.printStackTrace();}
          }
//             
      }
    
}
