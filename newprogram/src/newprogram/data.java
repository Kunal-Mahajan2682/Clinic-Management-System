package newprogram;
import java.sql.*;
import java.io.*;
import java.util.*;
public class data {



		public static void main(String[] args)
		{

			
			
			try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/test2";
			Connection con=DriverManager.getConnection(url,"root","Kunal123");
			
			
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			Scanner s=new Scanner(System.in);

				
				
//
//				System.out.println("\t\t\t\t\t\tEnter the Patient ID : \n");
//				int id=s.nextInt();

				
				System.out.println("\t\t\t\t\t\tEnter the Name of Patient : ");
				String name=br.readLine();
				
				System.out.println("\t\t\t\t\t\tEnter the Age of Patient : \n");
				int age=br.read();
				
				

				
				System.out.println("\t\t\t\t\t\tEnter the Gender of Patient : \n \t\t\t\t\t\t Press 1 for MALE AND 2 FOR FEMALE");
				int sex=s.nextInt();
				String gender="";
				if(sex==1)
					gender="male";
				else if(sex==2)
					gender="female";
				else if(sex==3)
					gender="Trans";
		
//			}catch(IOException a) {System.out.println(a);}
			

			
			System.out.println("\t\t\t\t\t\tEnter the Contact Number of Patient : \n");
			String contact=s.next();
			
			System.out.println("Enter the City of Patient : \n");
			String city=br.readLine();



		
			
		

			
			String Q="";
			

			Q="insert into test3(pname,age,gender,contact,city) values(?,?,?,?,?)";
			
			PreparedStatement pstmt=con.prepareStatement(Q);
		
//			System.out.println("\t\t\t\t\t\tEnter the ID of Patient : \n");
//			int id=s.nextInt();
//			pstmt.setInt(1, id);
			
//			System.out.println("\t\t\t\t\t\tEnter the Name of Patient : ");
//			String name=s.nextLine();			
			pstmt.setString(1,name);
			
//			System.out.println("\t\t\t\t\t\tEnter the Age of Patient : \n");
//			int age=s.nextInt();			
			pstmt.setInt(2, age);
			
//			System.out.println("\t\t\t\t\t\tEnter the Gender of Patient : \n");
//			String gender=s.nextLine();
			pstmt.setString(3,gender );

//			System.out.println("\t\t\t\t\t\tEnter the Contact Number of Patient : \n");
//			String contact=s.nextLine();
			pstmt.setString(4,contact );

//			System.out.println("\t\t\t\t\t\tEnter the City of Patient : \n");
//			String city=s.nextLine();
			pstmt.setString(5,br.readLine() );
			
			
			
			
			pstmt.executeUpdate();
			
//			pstmt.executeUpdate();
			System.out.println("Inserted ...");
			con.close();
			
			}catch(Exception ee) {System.out.println(ee);}
			
				
			
		}
		
	}

