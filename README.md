# AI_project_OOP
A machine learning program that calculates the likelyhood that you are an entrepenure based on the variables 
male or female 
did your parents own a business 
do you have a part time job
do you live in an urban or rural setting
did you take business studies corses 

I have used the Naive Bayes algorithm for this, this may prove to have innacurate results as the above values aren't truly independent.
The Naive Baybes algorithm chooses the most likely candidate of all possiblities, in this example it compares the likelihood that any of the above variables are related to someone being an entrepeneur or not.
It assumes first the person will be an entrepeneur and then multiplies all the provided variables assuming that the person does become an entreprenur and saves the result
It then assumes the person will not be an entrepeneur and multiplies all the provided variables assuming that the person does not become an entreprenur and saves the result
It then compares these two results and informs the user of the more likely outcome
Explained in more detail here:C
Wiki: https://en.wikipedia.org/wiki/Naive_Bayes_classifier
Video: https://www.youtube.com/watch?v=O2L2Uv9pdDA

The algorithm is trained using 70% upon start up but in the additional features you can retrain using any percentage you want.
I also designed a gui to restrict the users ability to commit errors using combo boxes rather than text input. 
The user can select each variable and then check their likelihood against the algorithm. 

Additonal Features I decided to add were the ability to display the estimated error of the algorithm using the remaining data and the ability to retrain the algorithm using a different percentage of the overall data provided.

Class Descriptions:


Control:
This class was used to intitalise all other classes.
It initialises the file decoder with MLdata.csv.
It decodes MLdata.csv and adds it to a trainer. 
It then trains using 70% of the data and adds the weights to the Classifier class.
It then creates a GUI called "Entreprenureship Classifier" that has access to all of the above information

FileDecoder:
This class skips the first three lines in a class (inorder to skip non data lines) and then converts them into an ArrayList of strings.
It also has the ability to count the number of datapoints in a file 

Trainer: 
Creates a HashTable with the weights of for each distinct variable provided in the training data and devides them based on if the final variable is a yes or a no. 
It returns these weights in terms of percentages 

Classifier:
This uses the Naieve bayes therom to calculate the likelyhood of someone being an entreprenur and not. 
It then compares both likelyhoods and chooses the larger.
In the case of Classifier.getError() it does this for all of the remaining data points, then gets the percentage of those it got correct and returns it.
In the case of Classifier.checker() it does this for a given array and then returns the result along with the likelihood in human readable English.

GUI:
Creates a GUI with a checkbox for each possible variable (I did this to avoid user input errors).
A "submit" button that submits the data entered into the checkboxes into the Classifier and displays a pop up window that says your if you're more or less likely to be an entreprenure and the probablity the classifier calculated
A "get error" button that displays a pop up window containing the error of the given classifier
A slider for percentages from 0 to 100 (defaulted at 70) so that the user can retrain the model.
A "retrain" button that retrains the model using the percentage given in the slider 
Labels for every element listed above 

If I had More Time: 
If I had More Time I would find a way to make the probability that the algorithm returns more human readable, most people aren't going to understand how high 30% is using this algorithm and will think it's very uncertian. 
I would also consider adding better GUI elements, right now while it's not ugly it's not particularly pretty eaither and that would be nice to add. 

