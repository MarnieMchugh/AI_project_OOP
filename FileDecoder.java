/*
 * Right now this only opens and decodes the csv file in order to be able to properly train the machine
 * later I might add the functionality that actually trains the network because this class already has all
 * the data converted into a readable format, I could also just return that readable format so it can be 
 * used in a class along the lines of "MachineBrain" 
 */


package assignment.OOP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileDecoder {
	
	//classes to be used in functions  
	private File trainingData;
	private Scanner scanner;
	private PrintWriter printer;
	
	public FileDecoder(String file)
	{
		trainingData = new File(file);
		try {
			//creates scanner for later use
			scanner = new Scanner(trainingData);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//Specifies the issue for error checking 
			System.out.println("Problem With Scanner Creation");
			e.printStackTrace();
		}
	}
	
	public int countlns()
	{
		//if we don't make a new scanner having reached the end of file in another method would stop this method working and skips preamble
		makeNewScanner(true);
		//i will 
		int numberOfDataElements = 0;
		
		//counts the total number of lines after preamble lines in CVS
		do {
			numberOfDataElements++;
			
			//needed to stop an infinite loop
			scanner.nextLine();
		}
		while(scanner.hasNextLine());
		return numberOfDataElements;
	}
	
	

	public ArrayList<String[]> decodeCSV() {
		//initialise an array list to add elements to
		ArrayList<String[]> out = new ArrayList<String[]>();
		
		int i;
		int count = 0;
		int ycount = 0;
		//if we don't make a new scanner having reached the end of file in another method would stop this method working
		makeNewScanner(true);
		
		while(scanner.hasNextLine())
		{
			//adds each line of  csv file as an array
			out.add(scanner.nextLine().split(",")) ;
		}
		
		
		//makes a new scanner only using 
		makeNewScanner(true);
		
		
		return out;
	}
	
	private void makeNewScanner(boolean forDataImplimentation)
	{
		/*
		 * creates a new scanner then if forDataImplimentation is true skips 3 lines for preamble
		 */
		try {
			//creates new scanner 
			scanner = new Scanner(trainingData);

			if(forDataImplimentation == true)
			{
				//skips the preamble
				scanner.nextLine();
				scanner.nextLine();
				scanner.nextLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("could not make new scanner");
			e.printStackTrace();
		}
		
	}
	
	
	public String toString()
	{
		//returns all of the data in the file as a string 
		
		String out = "";
		
		//makes new scanner to scan the file
		makeNewScanner(true);
		
		//scans through the whole file and adds each line to the output 
		while(scanner.hasNextLine())
		{
			out = out + scanner.nextLine() + "\n";
		}
		return out;
	}

}

