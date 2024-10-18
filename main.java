import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Main
{
	public static void main(String args[])
	{
		String dateStr=" 12/07/24";
		SimpleDateFormat fm= new SimpleDateFormat("dd/MM/YY");
		try
		{
			Date date= fm.parse(dateStr);
			SimpleDateFormat dayfm= newSimpleDateFormat("EEEE");
			Simple day= dayfm.format(date);
			System.out.println("Day of the wek for:" + dateStr + "is" + day);
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
	}
}