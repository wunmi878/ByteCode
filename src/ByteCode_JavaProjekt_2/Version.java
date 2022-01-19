//user defined package declared
package ByteCode_JavaProjekt_2;

//Class declaration with name Version
public class Version
{
	//method declared with data type string to get the major version(int). 
	public static String getVersion( int majorVersion ) 
	{
		String ver = "";

		//Falls unterscheidung / decision construct
		switch(majorVersion) 
		{
			case 45:			ver = "Java SE 1.1" ;			break;
			case 46:			ver = "Java SE 1.2" ;			break;
			case 47:			ver = "Java SE 1.3" ;			break;
			case 48:			ver = "Java SE 1.4" ;			break;
			case 49:			ver = "Java SE 1.5" ;			break;
			case 50:			ver = "Java SE 1.6" ;			break;
			case 51:			ver = "Java SE 1.7" ;			break;
			case 52:			ver = "Java SE 1.8" ;			break;
			case 53:			ver = "Java SE 1.9" ;			break;
			default:			ver = "UnKnown Version"; 		break;
			
		} // end of decision construct
		return ver;
	}//end of method
	
}// end of class