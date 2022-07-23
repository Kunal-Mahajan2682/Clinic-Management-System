package clinicproject;
import java.sql.*;
import java.util.*;

public class PatientUpdate 
{
	
	int id1=0;
	String name2="";
	String Q="";
	String sql1="";
	String sql2="";
	String sql3="";
	String sql4="";
	
	int age;
	int bp,spo2;
	String contact="";
	
	String final1="";
	
	int pid;		//<---- pid is patient id in blood test
	int btid;		//<---- btid is blood test id
	String report="";
	String desease="";
	
	
	Scanner s=new Scanner(System.in);
	clinicproject.SqlConnection conn=new clinicproject.SqlConnection();
	clinicproject.ViewPatient obj=new clinicproject.ViewPatient();

	
	
	public void UpdateInfo()
	{
		
		
			
			System.out.println("\t\t\t\t\t\t Enter the patient Name With Sirname  :");
			
			name2=s.nextLine();
//			pstmt.setString(1,name2);



		try 
				
		{
			

			Q="select * from pinfo where pname =  '"+name2+"' ";			
			conn.getConn();
			PreparedStatement pstmt=conn.con.prepareStatement(Q);
			

			
			
			
			ResultSet rs=pstmt.executeQuery(Q);
			
//			System.out.println("\t\t\t\t\t\t Searched Records is :\n\n");
			rs.next();
			
			id1=rs.getInt(1);
//			while (rs.next())
//			{
//				id1=rs.getInt(1);
//				name2=rs.getString(2);
//
//			}
			
			UpdateBasicInfo();
			
			
			
			conn.con.close();
		
		
		
		
		}catch(Exception e) {System.out.println(e);}
		
	}
	
	public void UpdateBasicInfo()
	{
		System.out.println("\t\t\t\t\t\t Enter the patients Age:");
		age=s.nextInt();
		System.out.println("\t\t\t\t\t\t Enter the patients Contact:");
		contact=s.next();
		System.out.println("\t\t\t\t\t\t Enter the patients BP");
		bp=s.nextInt();
		System.out.println("\t\t\t\t\t\t Enter the patients SPO2");
		spo2=s.nextInt();
		try
		{

			
			final1="update pinfo set age="+age+",contact='"+contact+"',bp="+bp+",spo2="+spo2+" where id="+id1;

			//			System.out.println(final1);

			conn.getConn();
			PreparedStatement pstmt=conn.con.prepareStatement(final1);
			pstmt.executeUpdate();

			System.out.println("\n\t\t\t\t\t\t UPDATE RECORDS IN SUCCESS");
			conn.con.close();
			

		}catch(SQLException e) {System.out.println(e);}
		finally
		{
			if(id1==0)
			{
			System.out.println("Invalid Name Enter Full Name With Sirname");
			UpdateInfo();
			}
		}
		
		//   <----- This is or the BLOOD TEST TABLE ------>
		
//		System.out.println("\t\t\t\t\t\t Before Upadating this Record Check Previous Record is Available Or Not");
		
	}
	
	public static void main(String[] args)
	{
		PatientUpdate obj=new PatientUpdate();
//		obj.BloodTest();
//		obj.ViewBInfo();
		obj.UpdateInfo();
	}

}
