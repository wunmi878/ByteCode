// User defined package
package ByteCode_JavaProjekt_2;

//Class declaration with name SupClass
class SupClass
{
	//method declaration with parameter
	public static String getSuperInfo( int super_class ) 
	{
		String sup = "";
		
		if(super_class!=0)
		{
			System.out.println("The Super Class index ist: "+ super_class);
		}
		else
		{
			System.out.println("There is no Super Class" );
		}
		return sup;
		
	}//end of method
	
	
	
	
}//End of class