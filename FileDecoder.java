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
		
		//counts the total number of lines after preamble in CVS
		do {
			numberOfDataElements++;
			
			//needed to stop an infinite loop
			scanner.nextLine();
			System.out.println(numberOfDataElements);
		}
		while(scanner.hasNextLine());
		return numberOfDataElements;
	}
	
	

	public String[][] decodeCSV(int elements, int inputs) {
		String[][] out = new String[elements][inputs];
		
		int i = 0;
		
		//if we don't make a new scanner having reached the end of file in another method would stop this method working
		makeNewScanner(true);
		
		while(scanner.hasNextLine())
		{
			out[i] = scanner.nextLine().split(",");
			System.out.println(Arrays.toString(out[i]));
			i++;
		}
		
		return out;
	}
	
	private void makeNewScanner(boolean forDataImplimentation)
	{
		try {
			scanner = new Scanner(trainingData);

			if(forDataImplimentation == true)
			{
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
	

}
