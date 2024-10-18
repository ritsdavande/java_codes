class Calender{
	public static void main(String args[])
	{
		String days[]={"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		int remDays[]={3,0,3,2,3,2,3,3,2,3,2,1};     		//Remaining days in month after dividing by 7.
		int day =10,month=8,year=2024;                		//Date whose day is to find.
		int preYear=year-1;							 		//Previous year.
		int preYearRem=0+preYear%100+(preYear%100)/4;       // Total Remaining days in a year after dividing by 7.
		int i,sum=0;
		for(i=0;i<month-1;i++)
		{
			sum=sum+remDays[i];
		}
		sum=sum+day;
		int leap=year%100;
		if(leap%4 == 0)
		{
			sum=sum+1;
		}
		int dayy=(preYearRem+sum)%7;
		System.out.println(days[dayy]);
	}


}
