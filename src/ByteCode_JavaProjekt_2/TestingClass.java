/*This code is written to read the class structure of a Java .class(Byte-code) File. 
The Employee.class file was used as an example to show all that can be read in a class file.
Any other class file can be read in the DatainputStream section.
*/

//user defined package
package ByteCode_JavaProjekt_2;

//Java packages used in this program is imported here before using it in the class
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

//class declaration with name TestingClass
public class TestingClass
{
	//.class file structure declaration as variable
	private  int magic = 0xcafebabe;
	private  int minor;
	private  int major;
	private  int constant_pool;
	private  int accessflags;
	private  int this_class;
	private  int super_class;
	private  int interfaces_count;
	private  int fields_count;
	private  int methods_count;
	private  int attributes_count;
	
	// Array List of Class CpInfo, ClassInfoMenu, FieldInfo and MethodInfo created to store all objects in the class 
	private static ArrayList<CpInfo> info = new ArrayList<>();
	
	private static ArrayList<ClassInfoMenu> menu= new ArrayList<>();


	private static ArrayList<FieldInfo> fieldInfo = new ArrayList<>();

	private static ArrayList<MethodInfo> methodInfo = new ArrayList<>();
	
	
	//constant pool declaration as variable
	private static final byte CONSTANT_Methodref =	10;
	private static final byte CONSTANT_String =8;
	private static final byte CONSTANT_Fieldref= 9;
	private static final byte CONSTANT_Double= 6;
	private static final byte CONSTANT_Class= 7;
	private static final byte CONSTANT_Integer= 3;
	private static final byte CONSTANT_NameAndType= 12;
	private static final byte CONSTANT_Utf8= 1;
	private static final byte CONSTANT_Float= 4;
	private static final byte CONSTANT_Long	=5;
	private static final byte CONSTANT_MethodHandle=15;
	private static final byte CONSTANT_MethodType=16;
	private static final byte CONSTANT_InvokeDynamic=18;
	private static final byte CONSTANT_InterfaceMethodref=11;
	
	
	
	//Access flags declaration as variable
	private static final int ACC_PUBLIC=0x0001;
	private static final int ACC_PRIVATE= 0x0002;
	private static final int ACC_PROTECTED	=0x0004;
	private static final int ACC_STATIC=0x0008;
	private static final int ACC_FINAL=0x0010;
	private static final int ACC_SUPER=0x0020;
	private static final int ACC_ABSTRACT=0x0400;
	
	//method declaration to get all info from CpInfo to TestingClass
	public static ArrayList<CpInfo> getCpInfo() 
	{
		return RaslanWunmi_JavaProjekt_2.TestingClass.info;
	}// end of method ArrayList CpInfo
	
	
	//method declaration to get all field info from FieldInfo to TestingClass
	public static ArrayList<FieldInfo> getFieldInfo()
	{
		return RaslanWunmi_JavaProjekt_2.TestingClass.fieldInfo;
	}// end of method ArrayList FieldInfo
	
	
	//method declaration to get all method info from MethodInfo to TestingClass
	public static ArrayList<MethodInfo> getmethodInfo()
	{
		return RaslanWunmi_JavaProjekt_2.TestingClass.methodInfo;
	}// end of method ArrayList MethodInfo
	
	
	//method to access Version class
	public int getMajorVersion()
	{
		return this.major;
	}//end of method
	
	//method to access class Access flags
	public int getaccessFlags()
	{
		return this.accessflags;
	}//end of method
	
	//method to access class InterfaceCount
	public int getInterfaceInfor()
	{
		return this.interfaces_count;
	}//end of method
	
	//method to access class NameClass
	public int getClassInfor()
	{
		return this.this_class;
	}//end of method
	
	//method to access class SuperClass
	public int getSupClassInfor()
	{
		return this.super_class;
	}//end of method
	
	
	//method to get tag id from CpInfo class
	public CpInfo getCpInfoById( int cp_index) {
		for( int i= 0;  i < this.info.size(); i++) {
			if(this.info.get(i).getId() == cp_index) {
				return this.info.get(i);
			}
		}
		
		return  null;
	}// end of method 
	
	//method to print out the UTF for class name  throws input output exception
	public String getClassName( int cp_index ) throws IOException
	{
		String str = "";
		
		CpInfo cp_info = getCpInfoById( cp_index  );
		
		System.out.println(cp_info.getId() + " : "+ cp_info.getTag() + " : " +cp_info.getShortValue() );
		
		CpInfo cp_data =  getCpInfoById( cp_info.getShortValue()  );
		
		System.out.println("Class name :  " +  cp_data.getUTF());
		System.out.println("Super Class name :  " +  cp_data.getUTF());
		return str;
	}// end of method
	
	
	//method declared with name readClassStructure which throws an IOException
	public void readClassStructure() throws IOException
	{
		
		//Data Input Stream object created to read the Class file with the name Employee
		DataInputStream ds= new DataInputStream(new FileInputStream("Employee.class"));
		
		//beginning of the class file format reading and loop
		if(magic==ds.readInt())
		{
			System.out.println("This is a Class file with the magic Number" + magic+ "\n");
			
			// reading of the minor version
			minor = ds.readUnsignedShort();
			System.out.println("The minor version ist " + minor + "\n");
			
			// reading of the major version
			major = ds.readUnsignedShort();
			System.out.println("The minor version ist " + major + "\n");
			
			// reading of the constant pool
			constant_pool= ds.readUnsignedShort();
			System.out.println( "Gesamt Constant pool ist: "+ constant_pool);
	 		for(int i=1; i<constant_pool; i++)
			{
	 			int tag = ds.readUnsignedByte();
	 			System.out.print("\nfound Constant Pool tag : " + tag +" \t");
	 			
	 			// decision construct to check which tag is seen in the class file and printed out
				switch(tag)
				{
				case 0:
					i = constant_pool;
					break;
				
				case CONSTANT_Class:	
				
					int value =  0 ;
					
					
					int ch1 = ds.read();
					int ch2 = ds.read();
		
					byte[] byte_data = { (byte)ch1, (byte)ch2};
		
					value =  (ch1 << 8) + (ch2 << 0);
					
					
					String str_data = ""  +value;
					System.out.printf("%03d - Class: ref1: " + value,i);
					info.add( new CpInfo(i, (byte)tag, byte_data));
					break;
					
					
					
				case CONSTANT_Utf8:	
					int length = ds.readUnsignedShort();
					byte[] data = new byte[length];
					
					
					System.out.printf("%03d -UTF8 - length: " + length,i);
					ds.readFully(data);
					
					System.out.printf("%03d - UTF8 - data: " + new String(data),i);
					
					str_data = ""  +length + new String(data);					
					info.add(new CpInfo(i, (byte)tag, str_data.getBytes()));
					break;
					
					
					
				case CONSTANT_Methodref:
					int method= ds.readUnsignedShort();
					int method2 = ds.readUnsignedShort();
					str_data = ""  +method + method2;
					System.out.printf("%03d - Methodref: ref1: " + method + " ref2: " + method2,i);
					info.add( new CpInfo(i, (byte)tag, str_data.getBytes()));
					break;
					
				case CONSTANT_Fieldref:
					int field= ds.readUnsignedShort();
					int field1= ds.readUnsignedShort();
					str_data= ""+field+ field1;
					System.out.printf("%03d - Fieldref: ref1: " + field + " ref2: " + field1,i);
					info.add( new CpInfo(i, (byte)tag, str_data.getBytes()));
					break;
					
				case CONSTANT_String:
					int cons_field= ds.readUnsignedShort();
					str_data= "" + cons_field;
					System.out.printf("%03d - String: ref1: " +cons_field ,i);
					info.add(new CpInfo(i, (byte)tag, str_data.getBytes()));
					break;
					
				case CONSTANT_NameAndType:
					int nametyp= ds.readUnsignedShort();
					int nametyp1= ds.readUnsignedShort();
					str_data= ""+ nametyp+ nametyp1;
					System.out.printf("%03d - Name and Type: " + nametyp+ "ref2: "+ nametyp1,i);
					info.add(new CpInfo(i, (byte)tag, str_data.getBytes()));
					break;
					
				case CONSTANT_Integer:
					int con_int= ds.readInt();
					str_data= "" + con_int;
					System.out.printf("%03d - Integer: " + con_int,i);
					info.add(new CpInfo(i, (byte)tag, str_data.getBytes()));
					break;
					
				case CONSTANT_Double:
					
					double dbl = ds.readDouble(); 
					str_data="" +dbl;
					System.out.printf("%03d - Double: ref1: " +dbl + "d",i);
					i++;
					info.add(new CpInfo(i, (byte)tag, str_data.getBytes()));
					break;
					
				case CONSTANT_Float:
					float fl= ds.readFloat();
					float fl1= ds.readFloat();
					str_data= ""+fl+ fl1;
					System.out.printf("%03d - Float: ref1: " +fl+ " ref2: " +fl1,i);
					info.add(new CpInfo(i, (byte)tag, str_data.getBytes()));
					break;
					
				case CONSTANT_Long:
					long lo= ds.readLong();
					long lo1= ds.readLong();
					str_data= ""+lo+ lo1;
					System.out.printf("%03d - Long: ref1: " +lo+ " ref2: " +lo1,i);
					i++;
					info.add(new CpInfo(i, (byte)tag, str_data.getBytes()));
					break;
					
				case CONSTANT_MethodType:
					int methodtyp=ds.readUnsignedShort();
					str_data="" + methodtyp;
					System.out.printf("%03d - Method type ist : ref1: "+ methodtyp,i);
					info.add(new CpInfo(i, (byte)tag, str_data.getBytes()));
					break;
					
				case CONSTANT_InvokeDynamic:
					int dyn= ds.readUnsignedShort();
					int dyn1= ds.readUnsignedShort();
					str_data= ""+ dyn+ dyn1;
					System.out.printf("%03d - Dynamic type ist : ref1: "+ dyn +" ref2: "+ dyn1,i);
					info.add(new CpInfo(i, (byte)tag, str_data.getBytes()));
					break;
					
				case CONSTANT_InterfaceMethodref:
					int inMet=ds.readUnsignedShort();
					int inMet1=ds.readUnsignedShort();
					str_data= " "+inMet+ inMet1;
					System.out.printf("%03d - Interface Method ist : ref1: "+ inMet + " ref2: "+inMet1,i);
					info.add(new CpInfo(i, (byte)tag, str_data.getBytes()));
					break;
					
				case CONSTANT_MethodHandle:
					int metHandle=ds.readUnsignedByte();
					int metHandle1=ds.readUnsignedByte();
					str_data=" "+metHandle+ metHandle1;
					System.out.printf("%03d - Method Handle ist : ref1: "+ metHandle + " ref2: "+ metHandle1,i);
					info.add(new CpInfo(i, (byte)tag, str_data.getBytes()));
					break;
					
				}//end of Switch decision construct
				
			}//end of for loop
	 		
	 		
			// a new line is printed
	 		System.out.println("\n");
	 		
	 		
	 		// reading of the Access flags
	 		accessflags= ds.readUnsignedShort();
	  		
			System.out.println( "flags: "+ accessflags);
			
			System.out.println( (accessflags & ACC_PRIVATE) > 0 ? "PRIVATE " :"");
			
	 		System.out.println( (accessflags & ACC_SUPER) > 0 ? "SUPER " :"");
			
	 		System.out.println( (accessflags & ACC_PUBLIC) > 0 ? "PUBLIC " :"");
	 		
	 		System.out.println( (accessflags & ACC_PROTECTED) > 0 ? "PROTECTED " :"");
	 		
	 		System.out.println( (accessflags & ACC_STATIC) > 0 ? "STATIC " :"");
	 		
			System.out.println( (accessflags & ACC_ABSTRACT) > 0 ? "ABSTRACT " :"");
			
	 		//reading of the class
	 		this_class= ds.readUnsignedShort();

	 		System.out.println( "The class ist: "+ this_class);
			
	 		//reading of the super class
	 		super_class= ds.readUnsignedShort();
	 		System.out.println( "The super class ist: "+ super_class);
	 		
	 		// reading the interfaces 
	 		interfaces_count= ds.readUnsignedShort();
	 		System.out.println( "Interface count ist: "+ interfaces_count);
	 		
	 		
	 		// counting the fields
	 		fields_count= ds.readUnsignedShort();
	 		System.out.println( "Field count ist : "+ fields_count);
			
	 		// A new line is printed
	 		System.out.println("\n");
	 		
	 		
	 		// field  information  ...
	 		for(int i=0; i<fields_count; i++)
			{
	 			String data="";
	 			int field_af = ds.readUnsignedShort();
	 			data=""+field_af;
	 			int field_ni = ds.readUnsignedShort();
	 			data= ""+field_ni;
	 			int field_di = ds.readUnsignedShort();
	 			data=""+field_di;
	 			int field_ac = ds.readUnsignedShort();
	 			System.out.println("\n");
	 			System.out.println("Field - Access flag: " + field_af);
	 			System.out.println("Field - name_indx: " + field_ni+ " : " + info.get(field_ni-1).getUTF());
	 			System.out.println("Field - descr_index: " + field_di);
	 			System.out.println("Field - attribute count: " + field_ac);
	 			
	 			//From class FieldInfo
	 			fieldInfo.add(new FieldInfo((int)field_af, (int) field_ni, (int) field_di, (int) field_ac));
	 	 			
	 			//field attribute info
	 			for(int x=0; x<field_ac; x++)
				{
	 				int att_ni= ds.readUnsignedShort();
	 				int att_l= ds.readInt();
	 				byte[] att_data = new byte[att_l];
	 				System.out.println("Field Attribute - name index: " + att_ni );
	 				System.out.println("Field Attribute length: " + att_l);
	 				ds.readFully(att_data);
	 				
				}// end of attribute information for loop
	 			
	 			
	 			
	 			
	 		}//end of field information for loop
	 		
	 		//prints out a new line
	 		System.out.println("\n");
	 		
	 		//Method information
	 		methods_count= ds.readUnsignedShort();
	 		System.out.println( "Method count ist: "+  methods_count);
	 		
	 		for(int i=0; i<methods_count; i++)
			{
	 			String data="";
	 			int method_af = ds.readUnsignedShort();
	 			data=""+method_af;
	 			int method_ni = ds.readUnsignedShort();
	 			data=""+method_ni;
	 			int method_di = ds.readUnsignedShort();
	 			data=""+method_di;
	 			int method_ac = ds.readUnsignedShort();
	 			data=""+method_ac;
	 			System.out.println("\n");
	 			System.out.println("Method - Access flag: " + method_af);
	 			System.out.println("Method - name_index: " + method_ni + ": "+ info.get(method_ni-1).getUTF());
	 			System.out.println("Method - descr_index: " + method_di + ": "+ info.get(method_di-1).getUTF());
	 			System.out.println("Method - attribute count: " + method_ac);
	 			
				//From class MethodInfo
	 			methodInfo.add(new MethodInfo((int) method_af, (int)method_ni, (int)method_di, (int) method_ac));
	 			
	 			//Method Attribute information
	 			for(int j=0; j<method_ac; j++)
	 			{
	 				System.out.println("\n");
	 				int attribute_namei= ds.readUnsignedShort();
	 				int attribute_l= ds.readInt();
	 				byte[] attribut_d = new byte[attribute_l];
	 			
	 			
	 				System.out.println("Method Attribute - name index: " + attribute_namei);
	 				System.out.println("Method Attribute length: " + attribute_l);
	 			
	 				//reads array attribute data
	 				ds.readFully(attribut_d);
	 			}
	 	
	 		}// end of method information for loop
	 		
	 		// new line printed
	 		System.out.println("\n");
	 		
	 		//Attribute count
	 		attributes_count= ds.readUnsignedShort();
	 		System.out.println( "Attribute count ist: "+  attributes_count);
	 		
	 		// new line printed
	 		System.out.println("\n");
	 		
	 		// Attribute info
 			int attri_ni= ds.readUnsignedShort();
 			int attri_l= ds.readInt();
 			byte[] attri_data = new byte[attri_l];
 			
 			
 			System.out.println("Attribute - name index: " + attri_ni);
 			System.out.println("Attribute length: " + attri_l);
 			
 			//reads array attribute data
 			ds.readFully(attri_data);
			
		}//end of if loop
		
	}//end of reading class structure
	
	//main method declaration
	public static void main(String[] args) throws IOException
		{
			//object tc of the Testing class created
			RaslanWunmi_JavaProjekt_2.TestingClass tc= new RaslanWunmi_JavaProjekt_2.TestingClass();
			
			//tc object calls the method readClassStructure
			tc.readClassStructure();
			
			
			//object cim of the classInfoMenu created and accepts the object tc
			ClassInfoMenu cim = new ClassInfoMenu(tc);
			
			//cim object calls the method menuDisplay
			cim.menuDisplay();
			
			
		}// end of main method

}//end of class


	