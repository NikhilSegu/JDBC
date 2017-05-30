 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.Statement;
 import java.sql.ResultSet;
 import java.sql.ResultSetMetaData;
 import java.io.*;
 
 class Jdbc_ResultSetMetadata{              //This resultset metadata is used when you dont know the columns.
 public static void main(String[] args)
 {
	 Connection con=null;
	 Statement stmt=null;
	 ResultSet rs=null;
	 ResultSetMetaData rsmd=null;
	 String url="jdbc:oracle:thin:@localhost:1521:xe"; 
	 try{
		 Class.forName("oracle.jdbc.driver.OracleDriver");
         con=DriverManager.getConnection(url,"system","manager");
         stmt= con.createStatement();
         rs= stmt.executeQuery("select * from emp");
		 rsmd=rs.getMetaData();
		 int count=rsmd.getColumnCount();
        while(rs.next()){
		for(int i=1;i<=count;i++)//always start with 1
			System.out.print(rs.getString(i)+" ");
		    System.out.println();
         }
	 }
      catch(Exception e){System.out.println(e);}
	  finally{  
       try{
		   if(rs!=null) rs.close();
		   if(stmt!=null) stmt.close();
		   if(con!=null) con.close();
	   }	  
		 catch(Exception e){System.out.println(e);}
        		 
  
	  }
 }
 }