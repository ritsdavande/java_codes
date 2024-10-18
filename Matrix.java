import java.util.Scanner;

public class Matrix{
	public int row;
	public int col;
	int a[][];
	int b[][];
	int addition[][];
	int subtraction[][];
	int multiplication[][];
	float division[][];
	int transpose[][];
	int size;
	
	Scanner sc = new Scanner(System.in);
	
	public Matrix(int r,int c){
	row=r;
	col=c;
	
	size=row*col;
	a=new int [size][size];
	b=new int [size][size];
	addition=new int [size][size];
	subtraction=new int [size][size];
	multiplication=new int [size][size];
	division=new float [size][size];
	transpose=new int [size][size];
}
public void setA(){
	int i,j;
	for(i=0;i<row;i++){
		for(j=0;j<col;j++){
			a[i][j]=sc.nextInt();
		}	
	}
}

public void setB(){
	int i,j;
	for(i=0;i<row;i++){
		for(j=0;j<col;j++){
			b[i][j]=sc.nextInt();
		}	
	}
}
//function for Addition 
public void addition(){
	int i,j;
	for(i=0;i<row;i++){
		for(j=0;j<col;j++){
			addition[i][j]=a[i][j]+b[i][j];
		}	
	}
}
//function for Subtraction
public void subtraction(){
	int i,j;
	for(i=0;i<row;i++){
		for(j=0;j<col;j++){
			subtraction[i][j]=a[i][j]-b[i][j];
		}	
	}
}
//function for Multiplication
public void multiplication(){
	int i,j;
	for(i=0;i<row;i++){
		for(j=0;j<col;j++){
			multiplication[i][j]=a[i][j] * b[i][j];
		}	
	}
}
//function for Division
public void division(){
	int i,j;
	for(i=0;i<row;i++){
		for(j=0;j<col;j++){
			division[i][j]=a[i][j] / b[i][j];
		}	
	}
}
//function for Transpose
public void transpose(){
	int i,j;
	for(i=0;i<row;i++){
		for(j=0;j<col;j++){
			transpose[i][j]=a[j][i];
		}	
	}
}

public void displayAddition(){
    int i,j;
	for(i=0;i<row;i++){
		for(j=0;j<col;j++){
			System.out.print(" "+addition[i][j]);;
		}	
		System.out.println("\t");
	}
}

public void displaySubtraction(){
    int i,j;
	for(i=0;i<row;i++){
		for(j=0;j<col;j++){
			System.out.print(" "+subtraction[i][j]);;
		}	
		System.out.println("\t");

	}
}

public void displayMultiplication(){
    int i,j;
	for(i=0;i<row;i++){
		for(j=0;j<col;j++){
			System.out.print(" "+multiplication[i][j]);;
		}	
		System.out.println("\t");

	}
}

public void displayDivision(){
     int i,j;
	for(i=0;i<row;i++){
		for(j=0;j<col;j++){
			System.out.print(" "+division[i][j]);;
		}	
		System.out.println("\t");

	}
}

public void displayTranspose(){
     int i,j;
	for(i=0;i<row;i++){
		for(j=0;j<col;j++){
			System.out.print(" "+transpose[i][j]);
		}	
		System.out.println("\t");

	}
}

public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	Matrix mt = new Matrix(2,2);
	System.out.println("Enter the elements of first matix");
	mt.setA();

	System.out.println("Enter the elements of second matix");
	mt.setB();

	int i=2;
	while(i>0){
		int choice;
		System.out.println("1.Addition 2.Subtraction 3.Multiplication 4.Division 5.Transpose");
		System.out.println("Enter your choice");
		choice =sc.nextInt();
		switch(choice){
			case 1:System.out.println("Addition of matrix is");
				mt.addition();
				mt.displayAddition();
				break;
			case 2:System.out.println("Subtraction of matrix is");
				mt.subtraction();
				mt.displaySubtraction();
				break;
			case 3:System.out.println("Multiplication of matrix is");
				    mt.multiplication();
				    mt.displayMultiplication();
				break;
			case 4:System.out.println("Division of matrix is");
				mt.division();
				mt.displayDivision();
				break;
			case 5:System.out.println("Transpose of matrix is");
				mt.transpose();
				mt.displayTranspose();
				break;
			default:break;
			}
		}
	}
}