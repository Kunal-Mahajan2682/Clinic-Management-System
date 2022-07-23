package clinicproject;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PatientInsert 
{
	
	
	

	int bp;
	int oxy;
	
	String name;
	int age;
	String gender;
	String contact;
//	String city1;

	
	
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	Scanner sc=new Scanner(System.in);

	
	
	public void PatientInfo()
	{
		
		try
		{
		System.out.println("\t\t\t\t\t\tEnter the Name of Patient : ");
//		String name="";
		name=br.readLine();

		System.out.println("\t\t\t\t\t\tEnter the Age of Patient : \n");
//		int age=0;
		age=sc.nextInt();
		
		

		
		System.out.println("\t\t\t\t\t\tEnter the Gender of Patient : \n \t\t\t\t\t\t Press 1 for MALE \n \t\t\t\t\t\t 2 FOR FEMALE");
		System.out.println(" \t\t\t\t\t\t Press 1 for TRANS-GENDER ");
		int sex=sc.nextInt();
//		String gender="";
		if(sex==1)
			gender="male";
		else if(sex==2)
			gender="female";
		else if(sex==3)
			gender="Trans";

	

	
	System.out.println("\t\t\t\t\t\tEnter the Contact Number of Patient : \n");
//	String contact="";
	contact=sc.next();
	


	
	
		}catch(Exception ee) {System.out.println(ee);}


	}
	
	public void GeneralInfo()
	{
		
			

			System.out.println("\t\t\t\t\t\t Enter the BP Ranges Between 10 to 290  : \n" + "\t\t\t\t\t\t Enter the Blood Oxygen Levels Ranges between 0 to 100  :");
			bp = sc.nextInt();
			oxy=sc.nextInt();
			if(bp<10 && bp>290 && oxy>100 && oxy<=0)
			{
				System.out.println("Wrong Value Enter Within the Range ");
				GeneralInfo();
			}

			
			
			
	}
	
	
	public void method1()
	{
		
		PatientInfo();
		GeneralInfo();
//		city();
		
		
		try
		{
			
			
			String Q="";
			

			Q="insert into pinfo(pname,age,gender,contact,bp,spo2) values(?,?,?,?,?,?)";
			
			clinicproject.SqlConnection conn=new clinicproject.SqlConnection();
			conn.getConn();
			PreparedStatement pstmt= conn.con.prepareStatement(Q);
		
			
			pstmt.setString(1,name);
			
			pstmt.setInt(2, age);
			
			pstmt.setString(3,gender );


			pstmt.setString(4,contact );

//			pstmt.setString(5,  city1);
			
			pstmt.setInt(5, bp);
			
			pstmt.setInt(6, oxy);
			
			
			pstmt.executeUpdate();
			

			conn.con.close();
			
			
			}catch(Exception ee) {System.out.println(ee);}
			
				
			
		
	
	
			
	}


	
	
}
