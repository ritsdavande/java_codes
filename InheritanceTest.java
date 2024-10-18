
class Person{
	String name="OM";
	int date=28;
	String month="August";
	int year=2004;
	double weight=55.0;
	double height=176.0;
	String address="Yadav Nagar Jaysingpur";
	int cur_year=2024;
	int age;

	int calculateAge(){
		return age=cur_year-year;
		}
}

class Student extends Person{
	int roll_no=33;
	double totalMarks=410;
	int totalSubjects=5;
	double avgMarks;

	double calculateAvg(){
		return avgMarks=(totalMarks)/(totalSubjects);
		}
}

class Employee extends Person{
	int empId=01;
	double salary=10000.0;
	double tax=0.3;
	double totalTax;

	double calculateTax(){
		return totalTax=(salary*tax);
		}
}

class InheritanceTest{
	public static void main(String[] args){
		Person p1=new Person();
		System.out.println("PERSON INFORMATION");
		System.out.println("The name of person is- "+ p1.name);
		System.out.println("The BirthDate of person is- "+ p1.date +"/"+ p1.month +"/"+ p1.year);
		System.out.println("The Weight of person is- "+ p1.weight +"kg.");
		System.out.println("The Height of person is- "+ p1.height +"cm.");
		System.out.println("The Address of person is- "+ p1.address);
		System.out.println("The Age of person is- "+ p1.calculateAge() +"years.");
		System.out.println("");
		Student s1=new Student();
		System.out.println("STUDENT INFORMATION");
		System.out.println("The Rollno of student is- "+ s1.roll_no);
		System.out.println("The Totalmarks of student are- "+ s1.totalMarks);
		System.out.println("The Totalsubjects of student are- "+ s1.totalSubjects);
		System.out.println("The Averagemarks of student are- "+ s1.calculateAvg());
		System.out.println("");
		Employee e1=new Employee(); 
		System.out.println("EMPLOYEE INFORMATION");
		System.out.println("The EmployeeID of employee is- "+ e1.empId);
		System.out.println("The Salary of employee is- Rs "+ e1.salary);
		System.out.println("The Tax of employee is- "+ e1.tax);
		System.out.println("The Totaltax of employee is Rs- "+ e1.calculateTax());
		}
}