package assignment.OOP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Trainer {
	private ArrayList<String[]> data;
	
	public Trainer(ArrayList<String[]> data)
	{
		setData(data);
	}
	
	public Hashtable<String,Float> train(double percent)
	{
		int i;
		int c;
		String value;
		float count;
		Hashtable<String, Float> weights = new Hashtable<String, Float>();
		int trainingData = (int) Math.floor(data.size()*percent);
		
		for(i=0;i<data.get(1).length;i++)
		{
			//sets the value of the first element to be compared against 
			value = data.get(0)[i];
			
			//allows us to count how many elements have this input 
			count = 0;
			
			//nested for loop that allows us to cycle through the elements and inputs
			for(c=0;c<trainingData;c++)
			{
				
				//increases count if the the input matches that of the first element
				if(data.get(c)[i].equals(value))
				{
					count++;
				}
				else if (weights.contains(data.get(c)[i]))
				{
					
				}

			}

			weights.put(value,count/trainingData) ;
			System.out.println(weights);
		}
		
		return weights;
		
	}

	public ArrayList<String[]> getData() {
		return data;
	}

	public void setData(ArrayList<String[]> data) {
		if(data.size()>0)
		{
			this.data = data;
		}
		else
		{
			System.out.println("This ArrayList Has No Value");
		}
	}
}
