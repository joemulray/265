/*
Joseph Mulray
11/06/2016
Lab 7
*/

import java.util.Calendar;

public class prob4{

	public static void main(String [] args){
	
	Calendar calendar = Calendar.getInstance();

		
	int number = Integer.parseInt(args[0]);
	switch (number){

	case 0:
	System.out.println("milliseconds since January 1, 1970: " + calendar.getTimeInMillis());
	break;

	case 1:
	System.out.println("seconds since January 1, 1970: " + calendar.getTimeInMillis()/1000 );
	break;

	case 2:
	System.out.println("days since January 1, 1970: " + (calendar.getTimeInMillis()/1000)/86400);
	break;

	case 3:
	System.out.println("date and time: " + calendar.getTime());
	break;

	default:
	System.out.println("Invalid input");
	break;	


	}




	}	


}
