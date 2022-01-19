//User defined package
package ByteCode_JavaProjekt_2;

//In-built package in Java imported 
import java.io.IOException ;
import java.io.DataInputStream; 
import java.io.ByteArrayInputStream;

//class declaration
class CpInfo {
	
	//variable declaration
	private int  id;
	private byte tag;
	private byte[] info;
	
	//Class constructor declared
	public CpInfo ( int id, byte tag, byte[] info)
	{
		this.id = id;
		this.tag = tag;
		this.info = info;
	}//end of constructor
	
	//method to get id with data type int
	public int getId() {
		return this.id;
	}//end of method
	
	//method to get tag of class e.g tag 7 is a class tag
	public int getTag() {
		return this.tag;
	}// end of method
	
	
	//method declaration to get tag and output string value of the tag
	public String getUTF()
	{
		if(this.tag==1) {
			return new String(info);
		}
		else if(this.tag==10)
		{
			return new String(info);
		}
		else if(this.tag== 12)
		{
			return new String(info);
		}
		else if(this.tag== 9)
		{
			return new String(info);
		}
		else if(this.tag== 11)
		{
			return new String(info);
		}
		else if(this.tag== 8)
		{
			return new String(info);
		}
		else if(this.tag== 3)
		{
			return new String(info);
		}
		else if(this.tag== 4)
		{
			return new String(info);
		}
		else if(this.tag== 5)
		{
			return new String(info);
		}
		else if(this.tag== 6)
		{
			return new String(info);
		}
		else if(this.tag== 16)
		{
			return new String(info);
		}
		else if(this.tag== 18)
		{
			return new String(info);
		}
		return null;
	}// end of method declaration
	
	//method with data type int to get short value of the info stored in an array and throws an input output exception 
	public int getShortValue() throws IOException
	{
		return (info[0] << 8) + (info[1] << 0);
	}// end of method declaration
	
	
	//method with data type string to get the CpInfo variables (tag,info) 
	public String getCpInfo( ) 
	{
		String res = "";
		
		res += "Constant-Pool-Entry-Tag " + this.tag + " \n";
		res += "Constant-Pool-Entry-Data: " + this.info + " \n";
		return res;
	}// end of method declaration
	
}// end of class