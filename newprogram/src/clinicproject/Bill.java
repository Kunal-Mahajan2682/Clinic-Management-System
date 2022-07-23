package clinicproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Bill 
{
	
	int pid,noofday,btid;
	String name;
	int Doctorfee=500,Labfee=1000,Wardcharge=200,Servicefee=200,sum;
	
	
	Scanner s=new Scanner(System.in);
	clinicproject.SqlConnection conn=new clinicproject.SqlConnection();
	
	public void BillUI()
	{
		checkForPatient();
		checkForTest();
		checkForAdmit();
		countBill();

		
		System.out.print("\t\t\t\t\t\t _________________________________________________________________\n");
		System.out.print("\t\t\t\t\t\t|                                                                 |\n");
		System.out.print("\t\t\t\t\t\t|                      PARADISE CHILD HOSPITAL                    |\n");
		System.out.print("\t\t\t\t\t\t|_________________________________________________________________|\n");
		System.out.println();
		System.out.print("\t\t\t\t\t\t+-----------------------------------------------------------------+\n");
		System.out.print("\t\t\t\t\t\t|                       ---->  INVOICE  <----                     |\n");
		System.out.print("\t\t\t\t\t\t+-----------------------------------------------------------------+\n");			
		System.out.print("\t\t\t\t\t\t                                                                  \n");
		System.out.print("\t\t\t\t\t\t               Doctor Fee         :    500                        \n");
		System.out.print("\t\t\t\t\t\t               Laboratory Fee     :    "+Labfee+"                 \n");
		System.out.print("\t\t\t\t\t\t               Ward Charges       :    200 /day                   \n");
		System.out.print("\t\t\t\t\t\t               Total No. of  Days :    "+noofday+"                \n");
		System.out.print("\t\t\t\t\t\t               Service Charge     :    200                        \n");
		System.out.print("\t\t\t\t\t\t                                                                 \n");
		System.out.print("\t\t\t\t\t\t__________________________________________________________________\n");
		System.out.print("\t\t\t\t\t\t                                                                 \n");
		System.out.print("\t\t\t\t\t\t              Total               :     "+sum+"                   \n");
		System.out.print("\t\t\t\t\t\t__________________________________________________________________\n");


	}
	
	public void inputName()
	{
		System.out.println("\t\t\t\t\t\tEnter the Patient Name :");
		name=s.nextLine();
	}
	
	public void checkForPatient()
	{
		
		inputName();
		String q="select * from pinfo where pname='"+name+"'";
		conn.getConn();
		
		try
		{
			
			PreparedStatement pstmt=conn.con.prepareStatement(q);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				pid=rs.getInt(1);
			}
			if(pid==0)
			{
				System.out.println("\t\t\t\t\t\tPatient Not Found");
				checkForPatient();
			}
			
			conn.con.close();
		}catch(Exception e) {System.out.println(e);}
		
	}
	
	public void checkForTest()
	{
		
		String q="select * from bloodtest where pid="+pid;
		conn.getConn();
		
		try
		{
			
			PreparedStatement pstmt=conn.con.prepareStatement(q);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				btid=rs.getInt("bid");
			}

			
			conn.con.close();
		}catch(Exception e) {System.out.println(e);}
		
	}
	
	public void checkForAdmit()
	{
		String q="select * from admitinfo where pid="+pid;
		conn.getConn();
		
		try
		{
			
			PreparedStatement pstmt=conn.con.prepareStatement(q);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				noofday=rs.getInt("noofday");
			}
			
			conn.con.close();
		}catch(Exception e) {System.out.println(e);}

	}
	
	public void countBill()
	{
		if(btid==0)
		{
			Labfee=0;
		}
		if(noofday==0)
		{
			Wardcharge=0;
		}
		
		sum=Doctorfee+Labfee+(Wardcharge*noofday)+Servicefee;
	}
	
	public static void main(String[] args)
	{
		Bill obj=new Bill();
		obj.BillUI();
	}

}
