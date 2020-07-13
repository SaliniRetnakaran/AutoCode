package interview.date.formatmethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class DateFormatPrgm 

{

	public void Dateformat() throws Exception
	{
		System.out.println("Hello , please enter date in MM-DD-YYYY format");
		
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader BR=new BufferedReader(isr);
		String UserDateInput=BR.readLine();
		System.out.println("Your Input is:::"+UserDateInput);
		System.out.println("*******************************************************************");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date UserDate = dateFormat.parse(UserDateInput);
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM/dd/YYYY");
		
		System.out.println("Your input in new format(MM/DD/YYYY):::"+dateFormat2.format(UserDate));
		 
		 
	}
	public static void main(String[] args) throws Exception 
	{
		
	      DateFormatPrgm obj=new DateFormatPrgm();
	      obj.Dateformat();
		
			
		
	}

}
