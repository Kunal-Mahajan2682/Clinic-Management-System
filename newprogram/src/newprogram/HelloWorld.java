package newprogram;
//import java.clinicproject.*;
import java.util.*;

import clinicproject.Sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.String;
import java.sql.*;
//import java.io.*;
//import java time.format.DateTimeFormatter;
//import java.time.LocalDateTime;





public class HelloWorld
{
	public void NameOfProject()
	{
		
		System.out.print("\t\t\t\t\t _______________________________________________________________________________________\n");
		System.out.print("\t\t\t\t\t|                                           		                                |\n");
		System.out.print("\t\t\t\t\t|                                           		                                |\n");
		System.out.print("\t\t\t\t\t|                                           		                                |\n");
		System.out.print("\t\t\t\t\t|                                           		                                |\n");
		System.out.print("\t\t\t\t\t|                                           		                                |\n");
		System.out.print("\t\t\t\t\t|                                           		                                |\n");
		System.out.print("\t\t\t\t\t|                                           		                                |\n");
		System.out.print("\t\t\t\t\t|                                           		                                |\n");
		System.out.print("\t\t\t\t\t|                           WELCOME TO CLINIC MANAGEMENT SYSTEM                         |\n");
		System.out.print("\t\t\t\t\t|                                                                                       |\n");
		System.out.print("\t\t\t\t\t|                                                                                       |\n");
		System.out.print("\t\t\t\t\t|                                                                                       |\n");
		System.out.print("\t\t\t\t\t|                                                                                       |\n");
		System.out.print("\t\t\t\t\t|                                                                                       |\n");
		System.out.print("\t\t\t\t\t|                                                                                       |\n");
		System.out.print("\t\t\t\t\t|                                                        -Created By                    |\n");
		System.out.print("\t\t\t\t\t|                                  	                 Kunal Rajendra Mahajan         |\n");
		System.out.print("\t\t\t\t\t|_______________________________________________________________________________________|\n");
		}
	
	Scanner scan=new Scanner(System.in);
//	String name;
//	String address;
//	long contact;
//	int age;
//	String bg;
//	String sex;
//	String disease;
//	long id;
//	String dadm;
	//To take a pause
	private void pressAnyKeyToContinue()
	 { 
	        System.out.println("Press Enter key to continue...");
	        try
	        {
	            System.in.read();
	        }  
	        catch(Exception e)
	        {
	        System.out.println("Press 'Enter' key to continue!");
	        }  
	 }
	 //Taking multiple words
	String readString()
	{
	    Scanner scanner = new Scanner(System.in);
	    return scanner.nextLine();
	}
	//Log in Module
	void login()
	{
	   String pass;
	   int a;
	   System.out.println("");
	   System.out.println("");
	   System.out.println("");
	   System.out.print("\t\t\t\t\t _______________________________________________________________________________________ \n");
	   System.out.print("\n\t\t\t\t\t\t\t\t\tCLINIC MANAGEMENT SYSTEM \n");
	   System.out.print("\t\t\t\t\t _______________________________________________________________________________________ \n");
	   System.out.println("\n\n\t\t\t\t\t\t\t\t------------------------------");
	   System.out.print("\n\t\t\t\t\t\t\t\t\t     LOGIN \n");	
	   System.out.print("\t\t\t\t\t\t\t\t------------------------------\n\n");	
	   System.out.print("\t\t\t\t\t\t\t\tEnter the Password: ");
	   pass=scan.next();
	   if(pass.equals("deccan"))
		{
	      System.out.print("\n\n\t\t\t\t\t\t\t\tAccess Granted!\n");
	      pressAnyKeyToContinue();
	  	}
	    else
		{
	      System.out.print( "\n\n\t\t\t\t\t\t\t\tAccess Aborted...\n\t\t\t\t\t\t\t\t1.Try Again\n\n\t\t\t\t\t\t\t\t2.Exit");
	      System.out.print("\n\n\t\t\t\t\t\t\tEnter the option: ");
	      a=scan.nextInt();
	      if(a==1)
	          login();
	      else if(a==2)
	          System.exit(0);
	      else
	        {
	         System.out.print("\n\n\t\t\t\t\t\tInvalid Choice\n");
	         login();
	        }
	        }
	}


	public void Menu()
	{
	int k;
	//giving option to the user for their choice
	System.out.println("");
	System.out.println("");
	System.out.print("\t\t\t\t\t _______________________________________________________________________________________ \n");
	System.out.print("\n\n\t\t\t\t\t\t\t\t\t  CLINIC MANAGEMENT SYSTEM \n\n");	
	System.out.print("\t\t\t\t\t _______________________________________________________________________________________ \n");
	System.out.print("\n\n\t\t\t\t\t\tPlease, Choose from the following Options: \n\n");
	System.out.print("\t\t\t\t\t\t _________________________________________________________________\n");
	System.out.print("\t\t\t\t\t\t|                                                                 |\n");
	System.out.print("\t\t\t\t\t\t|                         >>> MENU <<<                            |\n");	
	System.out.print("\t\t\t\t\t\t+-----------------------------------------------------------------+\n");	
	System.out.print("\t\t\t\t\t\t|                                                                 |\n");
	System.out.print("\t\t\t\t\t\t|             1  >> Patients Records                              |\n");
	System.out.print("\t\t\t\t\t\t|             2  >> History of the Patient                        |\n");
	System.out.print("\t\t\t\t\t\t|             3  >> Bill of the patient                           |\n");
	System.out.print("\t\t\t\t\t\t|             4  >> Information About the Hospital                |\n");
	System.out.print("\t\t\t\t\t\t|             5  >> Exit                                          |\n");
	System.out.print("\t\t\t\t\t\t|_________________________________________________________________|\n\n");
	System.out.print("\t\t\t\t\t\tEnter your choice: ");
	k=scan.nextInt();
	for(int i=1;k>5;i++)
	{
	if(k>5||k<1)
	 {
	  System.out.print("\n\n\t\t\t\t\t\tInvalid Choice\n");
	  System.out.print("\t\t\t\t\t\tTry again...........\n\n");
//	  menu();
	 }
	System.out.print("\t\t\t\t\t\tEnter your choice: ");
	k=scan.nextInt();
	}//if inputed choice is other than given choice
	switch(k)
	{
	case 1: PatientInfo();
	break;
	case 2: History();
	break;
	case 3: Bills(); 
	break;
	case 4: about();
	break;
	case 5: Exit();
	}
	//menu();
	}
	
// This block contain Code of Patient Information
	
	public void PatientInfo()
	{
		System.out.print("\n\n\t\t\t\t\t\tPlease, Choose from the following Options: \n\n");
		System.out.print("\t\t\t\t\t\t _________________________________________________________________\n");
		System.out.print("\t\t\t\t\t\t|                                                                 |\n");
		System.out.print("\t\t\t\t\t\t|                    >>>  PATIENT RECORDS  <<<                    |\n");
		System.out.print("\t\t\t\t\t\t+-----------------------------------------------------------------+\n");	
		System.out.print("\t\t\t\t\t\t|                                                                 |\n");
		System.out.print("\t\t\t\t\t\t|             1  >> Register Patient Information                  |\n");
		System.out.print("\t\t\t\t\t\t|             2  >> Update Patient Information                    |\n");
		System.out.print("\t\t\t\t\t\t|             3  >> Delete Patient Information                    |\n");
		System.out.print("\t\t\t\t\t\t|             4  >> Admit Realated Information                    |\n");
		System.out.print("\t\t\t\t\t\t|             5  >> View Patient Information                      |\n");
		System.out.print("\t\t\t\t\t\t|             6  >> Go Back to Menu                               |\n");
		System.out.print("\t\t\t\t\t\t|_________________________________________________________________|\n\n");
		System.out.print("\n\t\t\t\t\t\tEnter your choice: ");
		int j=scan.nextInt();
		for(int i=1;j>6;i++)
		{
			if(j>6||j<1)
			{
			System.out.print("\n\n\t\t\t\t\t\tInvalid Choice\n");
			System.out.print("\t\t\t\t\t\tTry again...........\n\n");
//		 	menu();
			}
			System.out.print("\t\t\t\t\t\tEnter your choice: ");
			j=scan.nextInt();
		}
		
		switch(j)
		{
		case 1: InsertPInfo();  //--->	Insert Module is Done	<-----
		break;
		case 2: UpdatePInfo();
		break;
		case 3: DeletePInfo();
		break;
		case 4: UpdateAdmitInfo();
		break;
		case 5: ViewPInfo();  //--->	View Patient Module is Done	<-----
		break;
		case 6: Menu(); 				//----------------> Menu OF PATIENTS <-----------------------//
		break;
		}
//		if(j>6)
//		{
//			System.out.println("\t\t\t\t\t\t WRONG INPUT ENTER VALUES BETWEEN 1 TO 6 \n \t\t\t\t\t\t\t\t\t\t TRY AGAIN");
//			PatientInfo();
//		}
		
	}
		
		public void InsertPInfo()
		{
			clinicproject.PatientInsert ins=new clinicproject.PatientInsert();
			ins.method1();
//			ins.GeneralInfo();
			
			
			System.out.println("\t\t\t\t\t\t INSERTED RECORDS SUCESSFULLY");
			System.out.println("\n\n\t\t\t\t\t\tFOR MANU PRESS 1");
//			Scanner s=new Scanner (System.in);
			int a =scan.nextInt();
			if(a==1)
				PatientInfo();
		}
		
		public void UpdatePInfo()
		{
			
			
			System.out.println("\t\t\t\t\t\t Before Updating the Records Please Check Patient is Registered Or Not");
//			System.out.println("\t\t\t\t\t\t Press 1 : Update Patient Information\n\t\t\t\t\t\t Press 2 : Update the Test Records");
			System.out.print("\n\n\t\t\t\t\t\tPlease, Choose from the following Options: \n\n");
			System.out.print("\t\t\t\t\t\t _________________________________________________________________\n");
			System.out.print("\t\t\t\t\t\t|                                                                 |\n");
			System.out.print("\t\t\t\t\t\t|                  >>>  UPDATE PATIENT INFO  <<<                  |\n");			
			System.out.print("\t\t\t\t\t\t+-----------------------------------------------------------------+\n");	
//			System.out.print("\t\t\t\t\t\t|                                                                 |\n");
			System.out.print("\t\t\t\t\t\t|             1  >> Update Basic Patient Information              |\n");
			System.out.print("\t\t\t\t\t\t|             2  >> Update Test Records of Patient                |\n");
			System.out.print("\t\t\t\t\t\t|_________________________________________________________________|\n\n");
			System.out.print("\n\t\t\t\t\t\t Enter your choice: ");

			
			int ab=scan.nextInt();
			if(ab>2 || ab<1)
			{
				System.out.println("WRONG CHOISE ...");
				UpdatePInfo();
			}
			else if(ab==1)
			{
				clinicproject.PatientUpdate obj=new clinicproject.PatientUpdate();
				obj.UpdateInfo();
			}
			else if(ab==2)
			{
				System.out.println("\t\t\t\t\t\t BEFORE INSERTING\\UPDATING TEST RELATED RECORDS FIRST VIEW RECORD");
				clinicproject.BloodTest obj2=new clinicproject.BloodTest();
				obj2.BloodTestUI();
				// <---- 07-04-2022 : Module Completed  ------>
			}
						
			
			
//			System.out.println("\t\t\t\t\t\t UPDATED RECORDS SUCESSFULLY");
			System.out.println("\n\n\t\t\t\t\t\t FOR MANU PRESS 1 ...");
//			Scanner s=new Scanner (System.in);
			int a =scan.nextInt();
			if(a==1)
				PatientInfo();
		}
		public void DeletePInfo()
		{
			
			
			clinicproject.DeleteRecord obj=new clinicproject.DeleteRecord();
			obj.DeleteUI();
			
			System.out.println("\t\t\t\t\t\t DELETED RECORDS SUCESSFULLY");
			System.out.println("\n\n\t\t\t\t\t\t FOR MANU PRESS 1 ...");
//			Scanner s=new Scanner (System.in);
			int a =scan.nextInt();
			if(a==1)
				PatientInfo();
		}
		public void UpdateAdmitInfo()
		{
			
			
			
			System.out.print("\n\n\t\t\t\t\t\tPlease, Choose from the following Options: \n\n");
			System.out.print("\t\t\t\t\t\t _________________________________________________________________\n");
			System.out.print("\t\t\t\t\t\t|                                                                 |\n");
			System.out.print("\t\t\t\t\t\t|                      >>>  ADMIT INFO  <<<                       |\n");
			System.out.print("\t\t\t\t\t\t+-----------------------------------------------------------------+\n");			
			System.out.print("\t\t\t\t\t\t|                1  >> Insert Admit Information                   |\n");
			System.out.print("\t\t\t\t\t\t|                2  >> Discharge The Patient                      |\n");
			System.out.print("\t\t\t\t\t\t|                3  >> Update Admit Record                        |\n");
			System.out.print("\t\t\t\t\t\t|_________________________________________________________________|\n\n");
			System.out.print("\n\t\t\t\t\t\t Enter your choice: ");

			
			int ab=scan.nextInt();
			if(ab>3 || ab<1)
			{
				System.out.println("WRONG CHOISE ...");
				UpdateAdmitInfo();
			}
			else if(ab==1)
			{
				clinicproject.AdmitPData obj=new clinicproject.AdmitPData();
				obj.CheckData();
			}
			else if(ab==2)
			{
				System.out.println("\t\t\t\t\t\t BEFORE INSERTING\\UPDATING TEST RELATED RECORDS FIRST VIEW RECORD");
				clinicproject.DischargePDate obj2=new clinicproject.DischargePDate();
				obj2.CheckAdmittedOrNot();
				// <---- 07-04-2022 : Module Completed  ------>
			}
			else if(ab==3)
			{
				System.out.println("\t\t\t\t\t\t IN THIS SECTION PREVIOUS RECORD WILL BE DELETED");
				
				// <---- REMAINING   ------>
			}

			
			
			
//			YOU HAVE TO SEARCH INFORMATION ON THE BASIS OF THE PATIENT NAME SO YOU HAVE TO INPUT PATIENT NAME AND THEN SEARCH AND THEN UPDATE
			System.out.println("\t\t\t\t\t\t UPDATED ADMIT INFORMATION SUCESSFULLY");
			System.out.println("\n\n\t\t\t\t\t\t FOR MANU PRESS 1 ...");
//			Scanner s=new Scanner (System.in);
			int a =scan.nextInt();
			if(a==1)
				PatientInfo();
		}
		public void ViewPInfo()
		{
			

			clinicproject.ViewPatient obj= new clinicproject.ViewPatient();
			obj.UpdateInfo();
			
			
			System.out.println("\n\n\t\t\t\t\t\t FOR MANU PRESS 1 ...");
			int a =scan.nextInt();
			if(a==1)
				PatientInfo();
		}



	
//	public void Diagnosis()
//	{
//		System.out.println("\t\t\t\t\t\tADDED DIGNOSIS SUCESSFULLY");
//		
//		System.out.println("\t\t\t\t\t\tFOR MANU PRESS 1");
////		Scanner s=new Scanner (System.in);
//		int a =scan.nextInt();
//		if(a==1)
//			Menu();
//	}
	
	
	public void History()
	{

		
		clinicproject.PatientHistory obj=new clinicproject.PatientHistory();
		obj.HistoryUI();
//		System.out.println("\t\t\t\t\t\tADDED HISTOY SUCESSFULLY");
		
		System.out.println("\n\t\t\t\t\t\tFOR MANU PRESS 1");
//		Scanner s=new Scanner (System.in);
		int a =scan.nextInt();
		if(a==1)
			Menu();
	}
	
	public void Bills()
	{

		clinicproject.Bill obj=new clinicproject.Bill();
		obj.BillUI();
		
		System.out.println("\n\t\t\t\t\t\tADDED BILLS SUCESSFULLY");
		
		System.out.println("\n\t\t\t\t\t\tFOR MANU PRESS 1");
//		Scanner s=new Scanner (System.in);
		int a =scan.nextInt();
		if(a==1)
			Menu();
	}
//	Exit block in Switch case 
	
	public void about()
	{
		System.out.println("\t\t\t\t\t\tAbout Information of The Hospital");
		
		System.out.print("\t\t\t\t\t\t _________________________________________________________________\n");
		System.out.print("\t\t\t\t\t\t|                                                                 |\n");
		System.out.print("\t\t\t\t\t\t|                      PARADISE CHILD HOSPITAL                    |\n");
		System.out.print("\t\t\t\t\t\t|_________________________________________________________________|\n");
		System.out.println();
		System.out.println("\t\t\t\t\t\t Name Of Doctor : Dr. Dilip S. Mahajan       Education : MBBS");
		System.out.println("\t\t\t\t\t\t Speacialisation : Child Care ");
		System.out.println("\t\t\t\t\t\t No. of Beds Available : 10");
		System.out.println("\t\t\t\t\t-------------------------------------------------------------------");
		System.out.println("\t\t\t\t\t\t Advantages :");
		System.out.println("\t\t\t\t\t\t 24*7 Service");
		System.out.println("\t\t\t\t\t\t 24*7 Pharmacy Store");
		System.out.println("\t\t\t\t\t\t Integreted Laboratory");
		System.out.println("\t\t\t\t\t-------------------------------------------------------------------");



		
		System.out.println("\n\t\t\t\t\t\tFOR MANU PRESS 1");
//		Scanner s=new Scanner (System.in);
		int a =scan.nextInt();
		if(a==1)
			Menu();
	}
	
	public void Exit()
	{
		System.exit(0);
	}

	
	
	
	
	public static void main(String[] args)
	{
		HelloWorld s=new HelloWorld();
		s.login();
		s.NameOfProject();
		s.Menu();
	}
}
