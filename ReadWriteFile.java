import java.io.*;
import java.util.*;
class ReadWriteFile
{
   	public static void main(String[] arg)throws Exception
        {
               Scanner sc=new Scanner(System.in);
		FileOutputStream fout=new FileOutputStream("My.data");
		
		PrintStream ps=new PrintStream(fout);

               for(int i=0;i<5;i++)
		{
			System.out.println("Enter Name,city,state - ");
			String name=sc.next();
 			String city=sc.next();
			String state=sc.next();
                         
                       ps.println(name+"\t"+city+"\t"+state);
		}
			try 
			{
				FileInputStream fin=new FileInputStream("My.data");
				DataInputStream din=new DataInputStream(fin);
				
				System.out.println("name \t  City  \t  State  ");
                                for(int i=0;i<5;i++)
		               {
		 			String s=din.readLine();
                                         System.out.println(s);
		               }

			}
                       catch(Exception e)
			{
				System.out.println(e);
			}
		}
	
}