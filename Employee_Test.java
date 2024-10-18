
class Employee {

	private String name;
	private String id;
	private int salary;

	public Employee (String name, String id, int salary) {

		this.name = name;
		this.id = id;
		this.salary = salary;

	}

	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}

	public int getSalary() {
		return salary;
	}

	public void setName(String name) {
		this.name= name;
	}
	public void setId(String id) {
		this.id= id;
	}
	public void setSalary(int salary) {
		this.salary =salary;
	}

	public void increment()

	{
		this.salary+=(int) (this.salary*0.10);
	}                                       

}
public class Employee_Test{
	public static void main(String[] args) {

		Employee e1 = new Employee("", "", 0);

		e1.setName("Ritesh");

		e1.setId("22UCS027");

		e1.setSalary(100000);

	System.out.println("Employee Details:-"); 
	System.out.println("Name: " + e1.getName());
	System.out.println("ID: " + e1.getId());
	System.out.println("Salary:"+e1.getSalary());
	System.out.println();

	System.out.println("Salary after increment:");
	e1.increment(); System.out.println("Employee Details:-");
	System.out.println("Name:"+e1.getName());
	System.out.println("ID:"+e1.getId()); 
	System.out.println("Salary:"+e1.getSalary()); 
    } 
}
