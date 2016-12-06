//Joseph Mulray
//Lab 8 Interfaces

import java.util.*;
import java.io.*;

public class Csv {


private String [] fields;
private int fieldNum = 0;

public Csv(String file) throws FileNotFoundException{
	
	//Create scanner for inputing the csv file	
	File inputFile = new File(file);
	Scanner csvFile = new Scanner(inputFile);		
	
	while(csvFile.hasNext()){
		String line = csvFile.next();
		fields = line.split(",");

		System.out.print("Field " + fieldNum + ": ");

		for (int point=0; point < fields.length; point++){
		System.out.print(fields[point] + " ");

		}
			
		System.out.println("");		

		fieldNum++;

	}
		
}	

public static void main(String [] args) throws IOException{

	//create csv onject
	Csv csvInput = new Csv("test.csv");
	
}


}
