package clinicproject;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;
public class DeleteRecord 
{
	
	
	
	
//		<----- First You have to create menu ---->
	int pid, btid,noofday;
	String a,b, name;
	
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	Scanner s=new Scanner(System.in);
	
	clinicproject.SqlConnection conn=new clinicproject.SqlConnection();
	
	public void DeleteUI()
	{
		
		System.out.print("\t\t\t\t\t\t _________________________________________________________________\n");
		System.out.print("\t\t\t\t\t\t|                                                                 |\n");
		System.out.print("\t\t\t\t\t\t|                  >>>  DELETE PATIENT INFO  <<<                  |\n");			
		System.out.print("\t\t\t\t\t\t+-----------------------------------------------------------------+\n");	
//		System.out.print("\t\t\t\t\t\t|                                                                 |\n");
		System.out.print("\t\t\t\t\t\t|             1  >> Delete Basic Patient Info                     |\n");
		System.out.print("\t\t\t\t\t\t|                  (INCLUDES BLOOD TEST AND ADMIT RECORDS)        |\n");
		System.out.print("\t\t\t\t\t\t|             2  >> Update Test Records of Patient                |\n");
		System.out.print("\t\t\t\t\t\t|_________________________________________________________________|\n\n");

		System.out.println("\t\t\t\t\t\tEnter the Choise");
		int ch=s.nextInt();
		if(ch>2||ch<1)
		{
			System.out.println("\t\t\t\t\tWrong Choise.. \n\t\t\t\t\t\t Try again ...");
			DeleteUI();
		}
		else if(ch==1)
		{
			DeleteAllRecords();
		}
		else if(ch==2)
		{
			KeepPatient();
		}
	}
	
	
	
	
	
	public void DeleteAllRecords()
	{
		

//		<----- All records should be deleted ---->
		KeepPatient();
		
		conn.getConn();
		String q="DELETE FROM pinfo where id="+pid;
		try
		{
			
			PreparedStatement pstmt=conn.con.prepareStatement(q);
			pstmt.execute();
			System.out.println("\t\t\t\t\t\tDELETED PATIENT SUCCESSFULLY");

		}catch(Exception e) {System.out.println(e);}

		
	}
	
	public void InputName()
	{
		System.out.println("\t\t\t\t\t\tEnter the Patient Name :");
//		name=s.nextLine();
//		name=s.nextLine();
		try
		{
			name=br.readLine();
		}catch(Exception e) {System.out.println(e);}

	}
	
	public void KeepPatient()
	{
		
		InputName();
		
		
		
//		<----- In this function, Only blood test, Admit and Bill Record is Deleted ---->
//		<----- Patient Record is not Deleted ---->

		conn.getConn();
		String q="SELECT * FROM pinfo p left join bloodtest b" + " on p.id=b.pid"+" where pname='"+name+"'";
		
		try
		{
			
			PreparedStatement pstmt=conn.con.prepareStatement(q);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				pid=rs.getInt("id");
				btid=rs.getInt("bid");
//				a=""+rs.getDate("admit");
//				b=""+rs.getDate("discharge");
//				noofday=rs.getInt("noofday");

			}
			
//			System.out.println("\tBlood Test NO. : "+btid);
//			System.out.println("\tPatient ID     : "+pid);
//			System.out.println("\tAdmit Date     : "+a);
//			System.out.println("\tDischarge Date : "+b);
//			System.out.println("\tNo of Days     : "+noofday);
			
		}catch(Exception e) {System.out.println(e);}
	
		DeleteAdmit();
		DeleteBloodTest();

	}
	
	
	public void DeleteAdmit()
	{
		
		
		conn.getConn();
		String q="DELETE FROM admitinfo where btid="+btid;
		try
		{
			
			PreparedStatement pstmt=conn.con.prepareStatement(q);
			pstmt.execute();
			System.out.println("\t\t\t\t\t\tDELETED RECORD FORM ADMIT TABLE");

		}catch(Exception e) {System.out.println(e);}
		
	}

	

	public void DeleteBloodTest()
	{
		
		
		conn.getConn();
		String q="DELETE FROM bloodtest where bid="+btid;
		try
		{
			
			PreparedStatement pstmt=conn.con.prepareStatement(q);
			pstmt.execute();
			System.out.println("\t\t\t\t\t\tDELETED RECORD FORM BLOOD TEST TABLE");

		}catch(Exception e) {System.out.println(e);}
		
	}

	
	
	
	
	
//	<----- No reverse is available You cant get data back ---->

	
	public static void main(String[] args)
	{
		DeleteRecord obj=new DeleteRecord();
//		obj.KeepPatient();
		obj.DeleteUI();
	}

}
