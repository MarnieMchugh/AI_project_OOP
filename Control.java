package assignment.OOP;

import java.util.Arrays;

public class Control {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileDecoder file = new FileDecoder("C:\\Users\\mapdg\\Downloads\\MLdata.csv");
		
		String[][] tester = file.decodeCSV(file.countlns(), 6);
		
		System.out.println(Arrays.toString(tester[5]));
	}

}
