package clinicproject;
import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;

import java.sql.Date;
import java.time.LocalDate;
////import java.time.*;
import java.time.temporal.*;
import java.time.temporal.ChronoUnit;
//import java.util.Date;
public class AdmitPData 
{
	
//	Date FirstDate;
//	Date SecondDate;
	int NoOfDays;
	int pid;
	int btid;
	String name="";
	
	
	int PatientID;
	
	String q="";
	Scanner s=new Scanner(System.in);
	clinicproject.SqlConnection conn=new clinicproject.SqlConnection();
	SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
	LocalDate first= LocalDate.now();
	LocalDate second=LocalDate.now();
//	FirstDate=first;

	
	
	private static java.sql.Date getCurrentDate()
	{
	
		java.util.Date today=new java.util.Date();
		return new java.sql.Date(today.getTime());
	}
	
	
	public void InputPName()
	{
		System.out.println("\n\t\t\t\t\t\t Enter Patient Name With Sirname :");
		name=s.nextLine();
		
	
		
	}
	public void CheckData()
	{
		InputPName();
		conn.getConn();
		
		try 
		
		{
			

//			q="select * from pinfo where pname =  '"+name+"' ";
			q="SELECT * FROM pinfo p left join bloodtest b" + " on p.id=b.pid"+" where pname='"+name+"'";
			conn.getConn();
			PreparedStatement pstmt=conn.con.prepareStatement(q);
			
			ResultSet rs=pstmt.executeQuery(q);
			
			rs.next();
			
			
			pid=rs.getInt(1);			
			btid=rs.getInt("bid");
			
//			System.out.println("patient Id :"+pid+"Blood Test ID :"+btid);

			if(pid==0)
			{
				System.out.println("\nPATIENT NOT FOUND WITH NAME : "+name);
				System.out.println("REGISTER NEW PATIENT");
				
			}
			else
			{
				System.out.println("\n\t\t\t\t\t\tPATIENT IS FOUND AT NAME : "+name);
				InsertNew();
			}
			
			conn.con.close();
		
		
		
		
		}catch(Exception e) {System.out.println(e);}

		
		

		

	}
	
	
	public void InsertNew()
	{
//		<------ Code for Inserting The Records in the admitinfo table ------>
		String Q="INSERT INTO admitinfo(btid,pid,admit) values(?,?,?)";
		conn.getConn();

		
		try 
		{
			
			
			PreparedStatement pstmt=conn.con.prepareStatement(Q);
			pstmt.setInt(1, btid);
			pstmt.setInt(2, pid);
			
//			<--- Remaining --->
//			>>> Step : 1 -> To get input of two dates.
//			>>> Step : 2 -> To Count no of Days Between Two Dates.
//			
//			------> To Give Menu for The Discharging the Patient <--------
			
			pstmt.setDate(3, getCurrentDate());
//			pstmt.setDate(4, getCurrentDate());
//			pstmt.setInt(5, 1);
			
			pstmt.executeUpdate();
			
			
			conn.con.close();
			
		
		}catch(Exception e) {System.out.println(e);}
		
		System.out.println("\n\t\t\t\t\t\tRECORD ARE INSERTED.");
	}
	
		
	public static void main(String[] args)
	{
		AdmitPData obj=new AdmitPData();
		obj.CheckData();
//		obj.InsertNew();
	}

}
