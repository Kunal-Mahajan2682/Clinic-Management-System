package clinicproject;
import java.sql.*;
public class SqlConnection 
{

	public Connection con;
	public Statement stmt;
	public PreparedStatement pstmt;
	
		
		public void getConn()
		{
			
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/test2";
				con=DriverManager.getConnection(url,"root","Kunal123");
//				System.out.println("Connection made Sucessfully");
				
				stmt= con.createStatement();
				
				
//				con.close();
				
			}catch(Exception ee) {System.out.println(ee);}
				
					
				
			}


		public static void main(String[] args) 
		{
			
			
			SqlConnection obj=new SqlConnection();
			obj.getConn();
			

		}

	}



