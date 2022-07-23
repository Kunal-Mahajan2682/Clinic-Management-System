package clinicproject;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BloodTest 
{
	
	String Q;
	String sql;
	String name;
	int pid;
	int bid;
	
	PreparedStatement pstmt;
	Scanner s=new Scanner(System.in);
	clinicproject.SqlConnection conn=new clinicproject.SqlConnection();
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	
	public void BloodTestUI()
	{
		

//		System.out.println("\t\t\t\t\t\t >>>> Press 1 : View Record\n\t\t\t\t\t\t >>>> Press 2 : Insert New Record\n\t\t\t\t\t\t >>>> Press 3 : Update Record");
		
		System.out.print("\t\t\t\t\t\t _________________________________________________________________\n");
		System.out.print("\t\t\t\t\t\t|                                                                 |\n");
		System.out.print("\t\t\t\t\t\t|                      >>  BLOOD TEST RECORDS  <<                 |\n");
		System.out.print("\t\t\t\t\t\t+-----------------------------------------------------------------+\n");	
		System.out.print("\t\t\t\t\t\t|         Press 1  >> View Patient                                |\n");
		System.out.print("\t\t\t\t\t\t|         Press 2  >> Insert New Test Records of Patient          |\n");
		System.out.print("\t\t\t\t\t\t|         Press 3  >> Update Test Records of Patient              |\n");
		System.out.print("\t\t\t\t\t\t|_________________________________________________________________|\n\n");
		int input=s.nextInt();
		if(input>3||input<1)
		{
			System.out.println("WRONG CHOISE ENTER AGAIN ...");
			BloodTestUI();
		}
		else if(input==1)
			ViewBInfo();
		
		else if(input==2)
			InsertBInfo();
		
		else if(input==3)
			UpdateBInfo();
		
	}
	// <---- Date : 04/07/2022 ------>

	
	public void getname()
	{
		try
		{
		System.out.println("\t\t\t\t\t\t Enter Patients Name :");
		name= br.readLine();
		}catch(Exception e) {System.out.println(e);}
	}
		
	
	public void ViewPInfo()
	{

		getname();
		
		conn.getConn();

//		first want id of patient info table and then check the blood test table
		try
		{
			Q="select * from pinfo where pname = '"+name+"'";			
			
			pstmt= conn.con.prepareStatement(Q);

			ResultSet rs=pstmt.executeQuery(Q);
			
			rs.next();
			pid=rs.getInt(1);
			System.out.println("\t\t\t\t\t\t EXICUTED SUCCESS");
		
			conn.con.close();
			
		}catch(Exception e) {System.out.println(e);}
		
		
	}
	
	
	
	public void ViewBInfo()
	{
		ViewPInfo();
		conn.getConn();
		
		try 
		{
			String sql="select * from bloodtest where pid="+pid;
			PreparedStatement pstmt1=conn.con.prepareStatement(sql);
			ResultSet rs=pstmt1.executeQuery(sql);
			if(rs.next()) 
			{
				pid=rs.getInt(2);
				System.out.println("\t\t\t\t\t\t RECORD FOUND AT THE POSITION. \n\t\t\t\t\t\t UPDATE EXISTING RECORD");
			}
			else 
			{
				System.out.println("\t\t\t\t\t\t RECORD NOT FOUND AT THIS POSITION. \n\t\t\t\t\t\t INSERT NEW RECORD");
			}
//			BloodTestUI();

			conn.con.close();
		}catch(Exception e) {System.out.println(e);}
	}
	
	
	public void InsertBInfo()
	{
		
		ViewBInfo();
		conn.getConn();
		try
		{
			String Ins="insert into bloodtest(pid,bloodtest,disease) values(?,?,?)";
			PreparedStatement pstmt=conn.con.prepareStatement(Ins);
			
			pstmt.setInt(1,pid);
			
			System.out.println("\t\t\t\t\t\t >>> Press 1 :  NORMAL REPORT\n\t\t\t\t\t\t >>> Press 2 :  ABNORMAL REPORT");
			int a=s.nextInt();
			if(a>2 || a<1)
			{
				System.out.println("\t\t\t\t\t\t INVALID CHOISE TRY AGAIN");
				InsertBInfo();
			}
			else if(a==1)
			{
				pstmt.setString(2,"NORMAL");
				pstmt.setString(3, "");
			}
			else if(a==2)
			{
				pstmt.setString(2, "ABNORMAL");
				System.out.println("\t\t\t\t\t\t Enter the Disease :");
				String disease=br.readLine();
				pstmt.setString(3, disease);
				
			}
			pstmt.executeUpdate();
			System.out.println("\t\t\t\t\t\t INSERTED THE RECORDS FOR THE BLOOD TEST");
		
			conn.con.close();
		}catch(Exception e) {System.out.println(e);}
	}
	
	public void UpdateBInfo()
	{
		
		
		ViewBInfo();
		
		String report="";
		String disease="";
		
		System.out.println("\t\t\t\t\t\t >>> Press 1 :  NORMAL\n\t\t\t\t\t\t >>> Press 2 : ABNORMAL");
		int a=s.nextInt();
		if(a>2 || a<1)
		{
			System.out.println("\t\t\t\t\t\t INVALID CHOISE TRY AGAIN");
			InsertBInfo();
		}
		else if(a==1)
		{
			report="NORMAL";
		}
		else if(a==2)
		{
			try
			{
			report="ABNORMAL";
			System.out.println("\t\t\t\t\t\t Enter the Disease :");
			disease=br.readLine();
			}catch(Exception e) {System.out.println(e);}

		}
		
		
		try
		{
			String Ins="update bloodtest set bloodtest='"+report+"', disease='"+disease+"' where pid="+pid;
//			System.out.println(Ins);
			conn.getConn();
			PreparedStatement pstmt=conn.con.prepareStatement(Ins);
			pstmt.executeUpdate();
			
			System.out.println("\t\t\t\t\t\t UPDATED RECORD SUCESSFULLY");
			
			conn.con.close();
		}catch(Exception e) {System.out.println(e);}

		
		
	}
	

	public static void main(String[] args)
	{
		BloodTest obj=new BloodTest();
		obj.BloodTestUI();
	}
	

}
