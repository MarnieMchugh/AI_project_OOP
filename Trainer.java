package assignment.OOP;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;//adds the elements for the user sex input

/*
 * A class to train a Classifier using provided data and the naive Bayes algorithm 
 * Author: Mark McHugh
 */


public class Trainer {
	private ArrayList<String[]> data;
	Hashtable<String, Float> weights = new Hashtable<String, Float>();
	
	public Trainer(ArrayList<String[]> data)
	{
		setData(data);
	}
	
	public Hashtable<String,Float> train(double percent)
	{
		/*
		 * Trains a classifier by counting the total number of each input element and 
		 * the amount associated with them being related to an entrepreneur or not 
		 * (within a given percentage of total data). 
		 * The trainer then compares the amount of each element associated with being
		 * an entrepreneur or not and assigns them a statistical likelihood in weights
		 * Author: Mark McHugh
		 */
		
		int i;
		int c;
		
		int yes_count = 0;
		int no_count = 0;
		
		int trainingData = (int) Math.floor(data.size()*percent);
		
		
		//ensures the percentage entered is not greater than 100
		if(percent>1)
		{
			System.out.println("Percentages higher than 100 cannot be calculated");
		}
		else
		{
			//cycles through a portion of data using the percent given
			for(i=0;i<trainingData;i++)
			{
				//checks if the final element of the current person is yes
				if(data.get(i)[data.get(i).length-1].equals("Yes"))
				{
					//if the final element is yes the yes counter is incremented
					yes_count++;
				}
				else
				{
					//if the final element is no the no counter is incremented
					no_count++;
				}
			}
			
			
			for(i=0;i<data.get(1).length;i++)
			{
				
				//nested for loop that allows us to cycle through the elements and inputs
				for(c=0;c<trainingData;c++)
				{
					//makes a string element to track the value of this element's value and where in the array it falls 
					String current_element = i + data.get(c)[data.get(c).length-1]+ data.get(c)[i].trim();
					
					
					//checks if the current element is in the list of values and weights
					if (weights.containsKey(current_element))
					{
						
						//if the current element is in the list of weights and values it adds one to it's value
						weights.put(current_element, weights.get(current_element) + 1);
					}
					else
					{
						
						//if the current element is not in the list of values and weights it adds it with one instance
						weights.put(current_element, (float) 1);
					}
	
				}
			}	
		}
		
		//creates a set of keys that I can iterate through to assign conditional weights
		Set<String> keys = weights.keySet();
		
		//iterates through the Key set to assign conditional weights
        for(String key: keys){
        	
        	//if the element is not the final element that confirms entrepreneur status
            if(!(key.equals(data.get(1).length-1 + "NoNo")) && !(key.equals(data.get(1).length-1 + "YesYes")))
            {
            	if(key.substring(1,4).equals("Yes"))
            	{
            		//if the weights are associated with an entrepreneur the weights are the total number of the element devided by the total number of entrepreneurs
            		weights.put(key, weights.get(key)/yes_count);
            	}
            	else
            	{
            		//if the weights are associated with an non entrepreneur the weights are the total number of the element devided by the total number of non entrepreneurs
            		weights.put(key, weights.get(key)/no_count);
            	}
            }
            else
            {
            	//puts the statistical likelihood of it being yes or being no based on total training data
            	weights.put(key, weights.get(key)/trainingData);
            }
        }
		
		return weights;
		
	}
	
	
	
	public String toString()
	{
		
		return weights.toString();
		
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
