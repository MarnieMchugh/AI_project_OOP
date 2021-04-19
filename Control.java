package assignment.OOP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Control {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileDecoder file = new FileDecoder("MLdata.csv");
		
		
		ArrayList<String[]> tester = file.decodeCSV();
		
		Trainer thing = new Trainer(tester);
		
		Hashtable<String,Float> weights = thing.train(0.7);
		
		Classifier test = new Classifier(weights);
		
		GUI frame = new GUI("Entreprenureship Classifier",tester, test, thing); 
		
		
		
	}

}
