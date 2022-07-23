package clinicproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ViewPatient 
{
	
	int id1=0;
	String name2="";
	String Q="";
	
	
	Scanner s=new Scanner(System.in);
	
	public void UpdateInfo()
	{
		
		System.out.println("\t\t\t\t\t\t Enter the patient Name With Sirname  :");
		name2=s.nextLine();
//		pstmt.setString(1,name2);
		
		try
		{
//			Q="select * from pinfo where id ="+" 1";
			Q="select * from pinfo where pname =  '"+name2+"' ";			
			clinicproject.SqlConnection conn=new clinicproject.SqlConnection();
			conn.getConn();
			PreparedStatement pstmt=conn.con.prepareStatement(Q);
			

//			
			
			
			ResultSet rs=pstmt.executeQuery(Q);
			
			System.out.println("\t\t\t\t\t\t Searched Records is :\n\n");
			while (rs.next())
			{
				id1=rs.getInt(1);
				System.out.println("\t\t\t\t\t\t ID   : "+rs.getInt(1)+"\n\t\t\t\t\t\t Name : "+rs.getString(2));
				System.out.println("\t\t\t\t\t\t Age  : "+rs.getString(3)+"\tGender :"+rs.getString(4)+"  \t Contact :  "+rs.getString(5));
				System.out.println("\t\t\t\t\t\t BP   : "+rs.getInt(6) +"\tSPO2(Blood-Oxygen) :  "+rs.getInt(7));
			}
			if(id1==0)
			{
				System.out.println("\t\t\t\t\t\t Record Not Found For The Name : "+name2);
				System.out.println("\t\t\t\t\t\t Try Again ... ");
				UpdateInfo();
			}
			
			
			
//			conn.con.close();
		
		
		
		
		}catch(Exception e) {System.out.println(e);}
	}
	
	
	


}
