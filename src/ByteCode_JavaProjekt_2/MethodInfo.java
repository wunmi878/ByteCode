// User defined package declared
package ByteCode_JavaProjekt_2;

// class declaration with name MethodInfo
class MethodInfo
{
	//variable declaration
	private int access_flag;
	private int name_index;
	private int descr_index;
	private int attribute_count;
	
	//constructor with parameters and integer data type declared
	public MethodInfo(int access_flag, int name_index, int descr_index, int attribute_count)
	{
		this.access_flag=access_flag;
		this.name_index=name_index;
		this.descr_index=descr_index;
		this.attribute_count=attribute_count;
	}// end of constructor
	
	// method to get Method Access information
	public int getMethodAcessInfo()
	{
		if(this.access_flag!=0)
		{
			System.out.println("Method Access flag ist:  "+access_flag);
		}
		else
		{
			System.out.println("There is no Method in the program: ");
		}
		return access_flag;
	
	
	}// end of method
	
	//method to get Method Information
	public String getMethodInfo( ) 
	{
		String res = "";
		
		res += "Method Access-flag: " + this.access_flag + " \n";
		res += "Method Name-index: " + this.name_index + " \n";
		res += "Method Descriptor-index: " + this.descr_index + " \n";
		res += "Method Attributes: " + this.attribute_count + " \n";
		return res;
	}// end of method
	
}//end of class