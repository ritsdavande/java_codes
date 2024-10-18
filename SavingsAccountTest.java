//EXPERIMENT NO-4
class SavingsAccount{
	int account_number;
	String account_name;
	String account_branchname;
	double account_balance;
	public static int annualInterestRate=5;
	SavingsAccount(){
		}
	
	void setaccount_number(int acno){
		account_number=acno;
		}
	int getaccount_number(){
		return account_number;
		}
	void setaccount_name(String name){
		account_name=name;
		}
	String getaccount_name(){
		return account_name;
		}
	void setaccount_branchname(String bname){
		account_branchname=bname;
		}
	String getaccount_branchname(){
		return account_branchname;
		}
	void setaccount_balance(int bal){
		account_balance=bal;
		}
	double getaccount_balance(){
		return account_balance;
		}
	public static void modifyInterestRate(int rate){
		annualInterestRate=rate;
		}
	public double monthlyInterest(){
		return ((account_balance * annualInterestRate)/1200);
		}
}

class SavingsAccountTest{
	public static void main(String args[]){
		SavingsAccount saver1=new SavingsAccount();
		SavingsAccount saver2=new SavingsAccount();
		saver1.setaccount_number(123);
		saver1.setaccount_name("HARSH");
		saver1.setaccount_branchname("Sangli");
		saver1.setaccount_balance(10000);
		saver2.setaccount_number(456);
		saver2.setaccount_name("ADITYA");
		saver2.setaccount_branchname("Kagal");
		saver2.setaccount_balance(11000);
		
		
		System.out.println("The first account information is: ");
		System.out.println("Account no of saver1: "+saver1.getaccount_number());
		System.out.println("Account name of saver1: "+saver1.getaccount_name());
		System.out.println("Account branchname of saver1: "+saver1.getaccount_branchname());
		System.out.println("Account balance of saver1: "+saver1.getaccount_balance());
		System.out.println("Monthly interest of saver1 is: "+saver1.monthlyInterest());


		System.out.println("The second account information is: ");
		System.out.println("Account no of saver2: "+saver2.getaccount_number());
		System.out.println("Account name of saver2: "+saver2.getaccount_name());
		System.out.println("Account branchname of saver2:  "+saver2.getaccount_branchname());
		System.out.println("Account balance of saver2: "+saver2.getaccount_balance());
		System.out.println("Monthly interest of saver2 is: "+saver2.monthlyInterest());
		
		SavingsAccount.modifyInterestRate(10);
		System.out.println("After modifying monthlyinterestrate of saver1: "+saver1.monthlyInterest());
		System.out.println("After modifying monthlyinterestrate of saver2: "+saver2.monthlyInterest());
		}

}