interface Cricket{
	
}

class Bat implements Cricket{
	public void batting(){
		System.out.println("Batting...");
	}
}
class Bowl implements Cricket{
	public void bowling(){
		System.out.println("Bowling...");
	}
}

class CricketTest{
	public static void main(String[] args){
		Bat spartan=new Bat();
		spartan.batting();
		Bowl sg=new Bowl();
		sg.bowling();
	}
}