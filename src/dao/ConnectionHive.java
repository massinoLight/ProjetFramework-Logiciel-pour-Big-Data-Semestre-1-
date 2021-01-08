package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionHive {
	
	 private static String driverName = "com.amazon.hive.jdbc4.HS2Driver";
	  /**
	   * @param args
	   * @throws SQLException
	   */
	  public static void main(String[] args) throws SQLException {
	      try {
	      Class.forName(driverName);
	    } catch (ClassNotFoundException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	      System.exit(1);
	    }
	    //replace "hive" here with the name of the user the queries should run as
	    Connection con = DriverManager.getConnection("jdbc:hive2://ec2-3-235-44-213.compute-1.amazonaws.com:10000/default", "hive", "");
	    Statement stmt = con.createStatement();
	    ResultSet result ;
	    String tableName = "temp_covid";
	    String sql;
	   	    
	    sql = "SELECT iso_code,the_date,total_cases FROM default.temp_covid WHERE LOCATION='France' ";
	    
        result = stmt.executeQuery(sql);
        System.out.println("Running: " + sql);
        while (result.next()) {
            System.out.println("Pays=" + result.getString(1));
            System.out.println("Le=" + result.getString(2));
            System.out.println("Nombre de cas=" + result.getString(3));
        }
	    
	    
	  }
	
	
	

}
