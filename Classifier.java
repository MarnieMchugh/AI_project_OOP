package assignment.OOP;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/*
 * A class to check the likelihood of someone being an entrepreneur as well as the aproximate error
 * of the classifiers' weights 
 * Author: Mark McHugh
 */


public class Classifier {
	private Hashtable<String,Float>  weights;

	public Classifier(Hashtable<String,Float> weights)
	{
		setWeights(weights);
	}
	
	
	public String checker(String[] instance)
	{
		/*
		 * Checks if a given string array is likely or unlikely to be an entrepreneur
		 * by going through each element and multiplying the likelihood that any given 
		 * value is present in an entrepreneur and a non entrepreneur by the likelihoods 
		 * of all other given values and the overall likelihood of being an entrepreneur or not 
		 * then returns whether or not they're likely to be an entrepreneur along with the calculated
		 * probability
		 */
		String output;
		double probability;
		double likely_yes = weights.get(instance.length + "YesYes" ) ;
		double likely_no = weights.get(instance.length + "NoNo" ) ;
		int i;
		
		for(i=0; i<instance.length;i++)
		{
			//multiplies the likelyhood of each element of instance given the person becomes an entrepreneur 
			likely_yes = likely_yes * weights.get(i + "Yes" + instance[i]);
		}
		
		for(i=0; i<instance.length;i++)
		{
			//multiplies the likelyhood of each element of instance given the person does not become an entrepreneur
			likely_no = likely_no * weights.get(i + "No" + instance[i]);
		}
		
		
		if(likely_no > likely_yes)
		{
			//sets the correct probability and then informs the user they're unlikely to own a business
			probability = likely_no;
			output = "Unlikely to become entrepreneur";

		}
		
		else 
		{
			//sets the correct probability and then informs the user they're likely to own a business
			probability = likely_yes;
			output = "More likely than not will be entrprenure";
		}
		
		return output + "\n Probability: " + probability;
		
	}
	
	public double getError(double percent, ArrayList<String[]> data)
	{
		/*
		 * Calculates the error by checking data that was not used to train 
		 * against the weights provided, counting the number of correct guesses
		 * then comparing that number to the total remaining data and returns a percentage
		 */
		
		int i;
		int c;
		
		int trainingData = (int) Math.floor(data.size()*percent);
		
		int count = 0;
		
		for(c=trainingData; c<data.size();c++)
		{
			
			//for every piece of the test data test if it is consistent with the expected result 
			String[] instance = data.get(c);
			int max = instance.length-1;
			double likely_yes = weights.get(max + "YesYes" ) ;
			double likely_no = weights.get(max + "NoNo" ) ;

			for(i=0; i<max;i++)
			{
				//calculates if the prediction that this instance will be an entrepreneur
				likely_yes = likely_yes * weights.get(0 + "Yes" + instance[0]);
			}
			
			for(i=0; i<max;i++)
			{
				//calculates if the prediction that this instance will not be an entrepreneur
				likely_no = likely_no * weights.get(0 + "No" + instance[0]);
			}
			
			
			if(likely_no > likely_yes)
			{
				
				if(instance[max].equals("No"));
				{
					//if the algorithm predicted they're unlikely and they aren't an entrepreneur count is incremented
					count++;
				}
	
			}
			
			else
			{
				if(instance[max].equals("Yes"))
				{
					//if the algorithm predicted they're likely and they are an entrepreneur count is incremented
					count++;
				}
			}
		}

		//sets the error correctly by taking the percent we got right away from 1
		percent = 1 - ((double)  count / (data.size() - trainingData));
		return percent;
	}

	public Hashtable<String,Float> getWeights() {
		return weights;
	}

	public void setWeights(Hashtable<String,Float> weights) {
		
		//checks if the weights is empty and if it isn't sets the weights
		if(weights.keys() != null )
		{
			this.weights = weights;
		}
		else
		{
			System.out.println("Hash Table Empty");
		}
	}
	
	public String toString()
	{
		return weights.toString();
		
	}


	
}
	