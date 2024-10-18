import java.io.*;


class file{
public static void main(String[] args){

try{
    DataInputStream fis=new DataInputStream(System.in);
    FileOutputStream fout= new FileOutputStream("outfile.txt");
    
    System.out.println("Enter Text ('@' at the end )");
    char ch;


    while((ch=(char)fis.read())!='@'){

        fout.write(ch);
    }

    fout.close();
}

	catch(IOException e)
		{
			System.out.println(e);
		}
}

}


