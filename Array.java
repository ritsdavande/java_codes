import java.util.*;

class Array
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
int  arr[]=new int[5];
int i;
for(i=0;i<5;i++)
{
arr[i]=sc.nextInt();
}
System.out.println("array list is \n");
for(i=0;i<5;i++)
{
System.out.println(arr[i]);
}
}
}