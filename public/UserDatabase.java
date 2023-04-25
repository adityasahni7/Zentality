import java.sql.*;

public class UserDatabase {

   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost/USER";

   static final String USER = "username";
   static final String PASS = "password";

   public static void main(String[] args) {
      Connection conn = null;
      Statement stmt = null;
      try{
         Class.forName(JDBC_DRIVER);

         System.out.println("Connecting to database...");
         conn = DriverManager.getConnection(DB_URL,USER,PASS);

         System.out.println("Creating table in given database...");
         stmt = conn.createStatement();
         String sql = "CREATE TABLE USER " +
                      "(ID INT PRIMARY KEY     NOT NULL," +
                      " USERNAME     TEXT    NOT NULL, " +
                      " EMAIL        TEXT    NOT NULL, " +
                      " PASSWORD     TEXT    NOT NULL)";
         stmt.executeUpdate(sql);
         System.out.println("Table created successfully...");

         stmt.close();
         conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }catch(Exception e){
         e.printStackTrace();
      }finally{
         try{
            if(stmt!=null)
               stmt.close();
         }catch(SQLException se2){
         }
         try{
            if(conn!=null)
            conn.close();
         }catch(SQLException se){
            se.printStackTrace();
         }
      }
      System.out.println("Goodbye!");
   }
}
