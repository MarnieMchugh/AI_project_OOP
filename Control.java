package assignment.OOP;

import java.util.ArrayList;
import java.util.Arrays;

public class Control {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileDecoder file = new FileDecoder("C:\\Users\\mapdg\\Downloads\\MLdata.csv");
		
		ArrayList<String[]> tester = file.decodeCSV();
		
		Trainer thing = new Trainer(tester);
		System.out.println(tester.get(1).length + 4);
		System.out.println(thing.train(0.70));
		System.out.println(tester.size());
	}

}
