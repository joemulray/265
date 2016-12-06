/*
Joseph Mulray
11/6/2016
Lab 7
*/

public class prob3{

	public static void main(String [] args){
	
	int number = Integer.parseInt(args[0]); 		

	if((number % 4 == 0 && number % 100 != 0) || number % 400 == 0){

	System.out.println("leap year!");

	}
	else{
		System.out.println("not a leap year");
	}




	
	}
}
