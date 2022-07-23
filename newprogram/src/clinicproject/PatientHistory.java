package clinicproject;
import java.sql.*;
import java.util.*;


public class PatientHistory 
{
	
	int pid,age,btid,noofday,bp,spo2;
	String name,gender,contact,report,disease,date1,date2;
	int sum;
	String str1="NORMAL";
	
	Scanner s=new Scanner(System.in);
	clinicproject.SqlConnection conn=new clinicproject.SqlConnection();
	
	
	public void HistoryUI()
	{
		
		checkPatient();
		checkAdmitInfo();
		bill();
		
		System.out.print("\t\t\t\t\t\t _________________________________________________________________\n");
		System.out.print("\t\t\t\t\t\t|                                                                 |\n");
		System.out.print("\t\t\t\t\t\t|                      PARADISE CHILD HOSPITAL                    |\n");
		System.out.print("\t\t\t\t\t\t|_________________________________________________________________|\n");
		System.out.println();
		System.out.print("\t\t\t\t\t\t+-----------------------------------------------------------------+\n");
		System.out.print("\t\t\t\t\t\t|                       ---->  HISTORY  <----                     |\n");
		System.out.print("\t\t\t\t\t\t+-----------------------------------------------------------------+\n");			
		System.out.print("\t\t\t\t\t\t     --- PATIENT DETAILES ---                                      \n");
		System.out.print("\t\t\t\t\t\t                                                                   \n");
		System.out.print("\t\t\t\t\t\t        ID    : "+pid+"");
		System.out.print("\t\t\tBLOOD-TEST NO. : "+btid+"         \n");
		System.out.print("\t\t\t\t\t\t        NAME  : "+name+"");
		System.out.print("\t\tAGE  : "+age+"           \n");
		System.out.print("\t\t\t\t\t\t        CONTACT NO. : "+contact+"");
		System.out.print("\tGENDER : "+gender+"      \n");
		System.out.print("\t\t\t\t\t\t _________________________________________________________________ \n");
		System.out.print("\t\t\t\t\t\t                                                                   \n");
//		System.out.print("\t\t\t\t\t\t        Description of Day : "+date1+"                             \n");
		System.out.print("\t\t\t\t\t\t        Doctor Name        : DR. DILIP SHIVAJI MAHAJAN             \n");
		if(report==null && btid==0) 
		{
			System.out.print("\t\t\t\t\t\t        Blood-test Report  : "+"NORMAL"+"                            \n");
			System.out.print("\t\t\t\t\t\t        Disease Detected   : "+"NO DISEASE IS DETECTED"+"      \n");

		}else
		{
			System.out.print("\t\t\t\t\t\t        Blood-test Report  : "+report+"                            \n");
			System.out.print("\t\t\t\t\t\t        Disease Detected   : "+disease+"                           \n");

		}
		if(noofday!=0) {
		System.out.print("\t\t\t\t\t\t        Admit Date         : "+date1+"                             \n");
		System.out.print("\t\t\t\t\t\t        Discharge Date     : "+date2+"                             \n");
		System.out.print("\t\t\t\t\t\t        Number of Days     : "+noofday+"                           \n");}
		System.out.print("\t\t\t\t\t\t _________________________________________________________________ \n");
		System.out.print("\t\t\t\t\t\t                                                                   \n");
		System.out.print("\t\t\t\t\t\t        Bill of Patient    : "+sum+"                               \n");
		System.out.print("\t\t\t\t\t\t _________________________________________________________________ \n");		


		
		
	}
	
	
	
	
	
	
	public void inputname()
	{
		System.out.println("\t\t\t\t\t\tEnter the Patient Name");
		name=s.nextLine();
	}
	public void checkPatient()
	{
		inputname();
		String q="SELECT * FROM pinfo p left join bloodtest b" + " on p.id=b.pid"+" where pname='"+name+"'";
		conn.getConn();
		try
		{
			
			PreparedStatement pstmt=conn.con.prepareStatement(q);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				pid=rs.getInt(1);
				name=rs.getString(2);
				age=rs.getInt(3);
				gender=rs.getString(4);
				contact=rs.getString(5);
				bp=rs.getInt(6);
				spo2=rs.getInt(7);
				
				btid=rs.getInt("bid");
				report=rs.getString("bloodtest");
				disease=rs.getString("disease");
				
			}
			
			if(pid==0)
			{
				System.out.println("\t\t\t\t\t\t Patient is Not Found");
				checkPatient();
			}
			
			conn.con.close();
		}catch(Exception e) {System.out.println(e);}
	}
	
	public void checkAdmitInfo()
	{

		String q="select * from admitinfo where pid="+pid;
		conn.getConn();
		try
		{
			
			PreparedStatement pstmt=conn.con.prepareStatement(q);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				date1=""+rs.getDate("admit");
				date2=""+rs.getDate("discharge");
				noofday=rs.getInt("noofday");
			}
			
			
			
			
		}catch(Exception e) {System.out.println(e);}
	}
	
	public void bill()
	{
		int Doctorfee=500,Labfee=1000,Wardcharge=200,Servicefee=200;
		if(btid==0)
		{
			Labfee=0;
		}
		if(noofday==0)
		{
			Wardcharge=0;
		}
		
		sum =Doctorfee+Labfee+(Wardcharge*noofday)+Servicefee;
	}
	
	
	
	
	
	public static void main(String[] args)
	{
		PatientHistory obj=new PatientHistory();
		obj.HistoryUI();
	}

}
