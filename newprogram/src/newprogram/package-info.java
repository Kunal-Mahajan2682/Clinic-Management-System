package newprogram;
import java.sql.*;
import java.util.*;

class Database
{
	public static void main(String[] args)
	{
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/test";
	Connection con=DriverManager.getConnection(url,"root","Kunal@123");
//	Statement stmt=con.createStatement();

	
	Scanner s=new Scanner(System.in);
	
		System.out.println("\t\t\t\t\t\tEnter the Name of Patient");
		int id=s.nextInt();
		String name=s.nextLine();
		int age=s.nextInt();
		String gender=s.nextLine();
		String contact=s.nextLine();
		String city=s.nextLine();
		
		String Q="";
		

		Q="insert into table1(id,name,age,gender,contact,city) values(?,?,?,?,?,?)";
		
		PreparedStatement pstmt=con.preparedStatement(Q);
		pstmt.setInt(1, 1);
		pstmt.setString(2,"Kunal Mahajan" );
		pstmt.setInt(3, 22);
		pstmt.setString(4,"Male" );
		pstmt.setString(5,"8208548384" );
		pstmt.setString(6,"Deopur" );
		
		
		
		
		stmt.executeUpdate(Q);
		
//		pstmt.executeUpdate();
		System.out.println("Inserted ...");
		con.close();
		
		}catch(Exception ee) {System.out.println(ee);}
		
			
		
	}
	
}