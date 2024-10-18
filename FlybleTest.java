interface flyble{
	void fly();
}

class Eagle implements flyble{
	public void fly(){
		System.out.println("I fly very fast");
	}
}

class Rocket implements flyble{
	public void fly(){
		System.out.println("I can fly in space");
	}
}

class flybleTest{
	public static void main(String [] args){
		Eagle e=new Eagle();
		e.fly();
		Rocket r=new Rocket();
		r.fly();
	}
}