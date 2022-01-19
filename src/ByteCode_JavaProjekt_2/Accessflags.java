// User defined package
package ByteCode_JavaProjekt_2;

//Class declaration with name Accessflags
public class Accessflags
{
	//method declaration with data type String and name getFlags with parameter accessFlags(int)
	public static String getFlags( int accessFlags ) 
	{
		String flags = "";
		
		if( (accessFlags & 0x0001) > 0)
		{
			System.out.println("The Access specifier in the Program ist: PUBLIC");
		}
		if((accessFlags & 0x0002) > 0)
		{
				System.out.println("The Access specifier in the Program ist: PRIVATE");
		}
		if((accessFlags & 0x0004) > 0)
		{
				System.out.println("The Access specifier in the Program ist: PROTECTED");
		}
		if((accessFlags & 0x0008) > 0)
		{
				System.out.println("The Access specifier in the Program ist: STATIC");
		}
		 if((accessFlags & 0x0010) > 0)
		{
				System.out.println("The Access specifier in the Program ist: FINAL");
		}
		if((accessFlags & 0x0020) > 0)
		{
				System.out.println("The Access specifier in the Program ist: SUPER");
		}
		if((accessFlags & 0x0400) > 0)
		{
				System.out.println("The Access specifier in the Program ist: ABSTRACT");
		}
		return flags;
		
	}// end of method
	
}// end of class