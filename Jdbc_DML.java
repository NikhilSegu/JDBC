 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.io.*;
 
 class Jdbc_DML{
 public static void main(String[] args)
 {
	 Connection con=null;
	 PreparedStatement stmt=null;
	 String url="jdbc:oracle:thin:@localhost:1521:xe"; 
	 try{
		 Class.forName("oracle.jdbc.driver.OracleDriver");
         con=DriverManager.getConnection(url,"system","manager");
         stmt=con.prepareStatement("insert into emp values(?,?,?)");
		 stmt.setInt(1,50);
		 stmt.setString(2,"jessie");
		 stmt.setDouble(3,9875478);
		 int count=stmt.executeUpdate();
		 System.out.println(count +" Row Inserted");
		 
		 
		 
	 }
      catch(Exception e){System.out.println(e);}
	  finally{  
       try{
		   if(stmt!=null) stmt.close();
		   if(con!=null) con.close();
	   }	  
		 catch(Exception e){System.out.println(e);}
        		 
  
	  }
 }
 }