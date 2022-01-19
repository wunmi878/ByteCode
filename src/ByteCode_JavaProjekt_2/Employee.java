/* This is the simple Java code written and the class file was read 
by the testingClass.Java program*/

//User defined package
package ByteCode_JavaProjekt_2;


// A class declaration
public class Employee
{
	// variable declaration
	private String employeeName;
	private int employeeAge;
	private double employeeSalary;
	
	//Method declaration with name display
	public void display()
	{
		employeeName="Me";
		employeeAge=22;
		employeeSalary= 33.00;
		System.out.println("Name ist " + employeeName+ "the Age ist \n"+ employeeAge+ "and the Salary ist \n"+ employeeSalary );
	}//end of user defined declaration
	
	//main method declaration
	public static void main(String[] args)
	{
		RaslanWunmi_JavaProjekt_2.Employee eP= new RaslanWunmi_JavaProjekt_2.Employee();
		eP.display();
	}// end of main method
	
}// end of class