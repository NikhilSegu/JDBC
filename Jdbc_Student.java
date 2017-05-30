import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet;
import java.sql.DriverManager;
class Jdbc_Student{
 public static void main(String[] args){
        Connection con=null;
		Statement stmt=null;
        ResultSet rs=null;
		ResultSetMetaData rsmd=null;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
    try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection(url,"system","manager");
		stmt=con.createStatement();
		rs=stmt.executeQuery("select * from student;");
		while(rs.next()){
	    System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
	}	
catch(Exception e){System.out.println(e);}
finally{
	try{
		if(rs!=null) rs.close();
        if(stmt!=null) rs.close();
        if(con!=null) rs.close();  
	}
  catch(Exception e) {System.out.println(e);}
}	
}
}