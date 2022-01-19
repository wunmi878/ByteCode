//User defined package
package ByteCode_JavaProjekt_2;

//In-built package in Java imported
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

//class declaration
public class ClassInfoMenu
{
	//class variable Testing class declared
	TestingClass testingClass;
	
	//class constructor with parameter declared 
	public ClassInfoMenu( TestingClass testingClass )
	{
		this.testingClass = testingClass;
	}//end of constructor
	
	
	//User defined method with Input Output Exception handled
	public void menuDisplay() throws IOException
	{
		//A loop construct to always accept input from the scanner
			
			//console output printed out for user input format 
			System.out.println("Input the following numbers to show the following .Class(Byte-code) Structure \n"
			+"1)All informations \n"+
			"2)Version\n"+
			"3)Field Count\n"+
			"4)Method Count\n"+  
			"5)Access Flags\n"+ 
			"6)Interface\n"+ 
			"7)Name of Class\n"+
			"8)Name of SuperClass\n");
			
			//A new line is printed
			System.out.println("\n");
			
			
		while(true) {
			//scanner to accept input from the console
			Scanner sc= new Scanner(System.in);
			String input= sc.nextLine();
			
			//ArrayList of the following classes(CpInfo,FieldInfo,MethodInfo) created and used to access different methods 
			ArrayList<CpInfo> info = TestingClass.getCpInfo();
			ArrayList<FieldInfo> fieldInfo= TestingClass.getFieldInfo();
			ArrayList<MethodInfo> methodInfo=TestingClass.getmethodInfo();
			
			
			
			//Each input from the console is controlled to access different methods. 
			if(input.equals("1"))
			
				{
					for(CpInfo cinfo :info)
					{
						System.out.println( cinfo.getCpInfo() +cinfo.getUTF() + "\n");
						
					}
				}
				else if(input.equals("2"))
				{
					System.out.println(Version.getVersion( testingClass.getMajorVersion() )+ "\n");
				
				}
				
				else if(input.equals("3"))
				{
					if(fieldInfo.size() == 0)
					{
						System.out.println("There are no Field to be counted in the program");
					}
					else {					
						for(FieldInfo finfo : fieldInfo)
						{
							System.out.println( finfo.getFieldInfo()  + "\n");
						}

					}
				}
				else if(input.equals("4"))
				{
					for(MethodInfo minfo : methodInfo)
					{
						System.out.println( minfo.getMethodInfo()  + "\n");
						
					}
				}
				else if(input.equals("5"))
				{
					System.out.println(Accessflags.getFlags(testingClass.getaccessFlags() )+ "\n");
				}
				else if(input.equals("6"))
				{
					System.out.println(InterfaceCount.getInterfaceInfo(testingClass.getInterfaceInfor() )+ "\n");
				}
				else if(input.equals("7"))
				{
					
					System.out.println(NameClass.getClassInfo(testingClass.getClassInfor() )+ "\n");
					testingClass.getClassName( testingClass.getClassInfor()  );
					
				}
				else if(input.equals("8"))
				{
					System.out.println(SupClass.getSuperInfo(testingClass.getSupClassInfor() )+ "\n");
					testingClass.getClassName( testingClass.getSupClassInfor() );
				}
				else if(input.equals("exit"))
				{
					System.exit(0);
				}
				// loop to catch input mismatch exception
				else if(!input.equals("1") && !input.equals("2"))
				{
					if(!input.equals("3") && !input.equals("4"))
					{
						if(!input.equals("5") && !input.equals("6"))
						{
							if(!input.equals("7") && !input.equals("8"))
							{	
								System.out.println("Please input only integer values given in the menu");
							}
						}
					}	
				}
				// end of if else loop
			
		}//end of while loop
			 

	}//end of  method menu display
		
	    
	

}//end of class