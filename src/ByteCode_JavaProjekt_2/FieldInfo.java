//User defined package declared
package ByteCode_JavaProjekt_2;

//class declaration with name FieldInfo
class FieldInfo
{
	//variable declaration with private access specifier used 
	private int access_flag;
	private int name_index;
	private int descr_index;
	private int attribute_count;
	
	
	//constructor of the class declared with data type variables in parentheses
	public FieldInfo(int access_flag, int name_index, int descr_index, int attribute_count)
	{
		this.access_flag=access_flag;
		this.name_index=name_index;
		this.descr_index=descr_index;
		this.attribute_count=attribute_count;
	}//end of constructor
	
	// method to get FieldAccess information
	public int getFieldAccessInfo()
	{
		if(this.access_flag!=0)
		{
			System.out.println("Field Access flag ist:  "+access_flag);
		}
		else
		{
			System.out.println("There is no Field Access in the program: ");
		}
		return access_flag;
	
	}// end of method
	
	//Method to get  Field Information with return type string
	public String getFieldInfo( ) {
		String res = "";
		
		res += "Field Access-flag: " + this.access_flag + " \n";
		res += "Field Name-index: " + this.name_index + " \n";
		res += "Field Descriptor-index: " + this.descr_index + " \n";
		res += "Field Attributes: " + this.attribute_count + " \n";
		
		return res;
		
		
	}// end of method
}//end of class