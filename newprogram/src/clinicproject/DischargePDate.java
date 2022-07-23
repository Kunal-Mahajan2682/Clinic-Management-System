package clinicproject;
import java.time.temporal.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class DischargePDate 
{
	
	int PatientID;
	int noofdays;
	Date Admit;
	int pid,btid;
//	Date Discharge;
	String q;
	String name2;
// THIS IS FOR THE UNDER WRITTEN FUNCTION	
	public static java.util.Date Discharge;
	
	
	clinicproject.SqlConnection conn=new clinicproject.SqlConnection();
	Scanner s=new Scanner(System.in);
	
	public void CheckPatientRecord()
	{
		conn.getConn();
		
		try 
		
		{
			

//			q="select * from pinfo where pname =  '"+name+"' ";
			q="SELECT * FROM pinfo p left join bloodtest b" + " on p.id=b.pid"+" where pname='"+name2+"'";
			conn.getConn();
			PreparedStatement pstmt=conn.con.prepareStatement(q);
			
			ResultSet rs=pstmt.executeQuery(q);
			
			rs.next();
			
			
			pid=rs.getInt(1);			
			btid=rs.getInt("bid");
			
//			System.out.println("\t\t\t\t\t\tpatient Id :"+pid+"Blood Test ID :"+btid);

			if(pid==0)
			{
				System.out.println("\n\t\t\t\t\t\tPATIENT NOT FOUND WITH NAME : "+name2);
				System.out.println("\n\t\t\t\t\t\tREGISTER NEW PATIENT.");
				
			}
			else
			{
				System.out.println("\n\t\t\t\t\t\tPATIENT IS FOUND AT NAME : "+name2);
			}
			
//			conn.con.close();
		
		
		
		
		}catch(Exception e) {System.out.println(e);}

		
		

	}
	
	public void CheckAdmittedOrNot() 
	{
		
		conn.getConn();
		
		
//		<------ Code for the Updating records in the admitinfo table ------>
		System.out.println("\n\t\t\t\t\t\t Checking for the Patient is Admitted or Not ...");
		System.out.println("\n\t\t\t\t\t\t Enter the Name of the Patient");
		name2=s.nextLine();
		
		
		CheckPatientRecord();
		
		if(btid==0)
		{
			System.out.println("\n\t\t\t\t\t\t BLOOD TEST RECORD IS NOT FOUND.\n\t\t\t\t\t\t INSERT HERE ... \n");
			bloodtest();
		}
		
		String Q="select * from admitinfo where btid= "+btid;
		
		try
		{
			
			
			PreparedStatement pstmt=conn.con.prepareStatement(Q);
			ResultSet rs=pstmt.executeQuery(Q);
			if(rs.next())
			{
				PatientID=rs.getInt(1);
				Admit=rs.getDate(3);
				
//				System.out.println(PatientID+"\t"+Admit);
				System.out.println("\n\t\t\t\t\t\t Patient is Admitted");
				System.out.println("");
				System.out.println("\t\t\t\t\t\t >>>> Press 1 : DISCHARGE ");
				int dis=s.nextInt();
				
				if(dis==1)
					Discharge();
			}
			else 
			{
				System.out.println("\n\t\t\t\t\t\t Patient is Not Admitted");
			}
			
			
			conn.con.close();
		}catch(Exception e) {System.out.println(e);}
	}
	
	
	private static java.sql.Date getCurrentDate()
	{
	
//		try
//		{
		Discharge=new java.util.Date();
		return new java.sql.Date(Discharge.getTime());
//		}catch(Exception e) {System.out.println(e);}
	}
	
	public void Discharge()
	{
		
		String Q="update admitinfo set discharge = '"+getCurrentDate()+"', noofday= "+CompairTwoDates()+" where btid="+btid;
		
		try
		{
			
			PreparedStatement pstmt=conn.con.prepareStatement(Q);
//			pstmt.setDate(1, getCurrentDate());
//			pstmt.setInt(2, 1);
			pstmt.executeUpdate();
			
		System.out.println("\n\t\t\t\t\t\tPATIENT IS DISCHARGED")	;
		}catch(Exception e) {System.out.println(e);}
	}
	
	public int CompairTwoDates()
	{
		
		conn.getConn();
//		pid=1;
		String j="select discharge - admit AS DAYS from admitinfo where pid="+pid;
		
		try
		{
			
			PreparedStatement pstmt=conn.con.prepareStatement(j);
			
			ResultSet rs=pstmt.executeQuery(j);
			rs.next();
			noofdays=rs.getInt(1);

			
		}catch(Exception e) {System.out.println(e);}
		return(noofdays);
	}
	
	
	
//	----> This Print Funtion Written for the Checking CompairTwoDates() Is Working or Not <----
	public void print()
	{
		System.out.println(CompairTwoDates());
		
	}
	
	
	
	public void bloodtest()
	{
		clinicproject.BloodTest obj2=new clinicproject.BloodTest();
		obj2.BloodTestUI();
		CheckAdmittedOrNot();
	}
	
	
	public static void main(String[] args)
	{
		DischargePDate obj=new DischargePDate();
		obj.CheckAdmittedOrNot();
//		obj.print();
	}
	
	

}
