package assignment.OOP;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

/*
 * Creates a GUI to allow the user to enter data to check if they are likely to become an entrepreneur,
 * retrain the algorithm and check the error
 * Author: Mark McHugh
 */



public class GUI extends JFrame implements ActionListener, MouseListener {
	
	int i;
	
	//correctly formatted data options to avoid user mistakes in combo boxes
	String[] sexArr = {"Male","Female"};
	String[] gardianBusArr = {"Yes","No"};
	String[] parttimerArr = {"Yes","No"};
	String[] homeArr = {"Urban","Rural"};
	String[] studiesArr = {"Yes","No"};
	
	//Initialising combo boxes for user input
	JComboBox sex;
	JComboBox gardianBus;
	JComboBox parttimer;
	JComboBox home;
	JComboBox studies;
	
	//labels for each user input 
	JLabel sexLab;
	JLabel gardianLab;
	JLabel parttimerLab;
	JLabel homeLab;
	JLabel studiesLab;
	JLabel retrainLab;
	
	JButton submit;
	JButton error;
	JButton retrain;
	
	JSlider retrainPercent;
	
	double percent = 0.7;
	
	Hashtable<String,Float> weights;
	
	//create a usable gui for the user to interact with
	public GUI(String title,  ArrayList<String[]> data, Classifier checker, Trainer trainer)
	{
		//creates a GUI frame to add input elements to 
		super(title);
		setSize(500, 200);
		setLayout(new FlowLayout());
		
		weights = checker.getWeights();
		
		//adds the elements for the user sex input
		sexLab = new JLabel("What is your sex? ");	
		sex = new JComboBox(sexArr);
		sex.setToolTipText("Use this to enter your gender");
		
		
		//adds the elements for information on the users gardians
		gardianLab = new JLabel("Are your gardians Entreprenurrs? ");
		gardianBus = new JComboBox(gardianBusArr);
		gardianBus.setToolTipText("Please input your parents Business Owner status here");
		
		
		//adds the elements for information on the users part time employment status
		parttimerLab = new JLabel("Do you have a part time job?");
		parttimer = new JComboBox(parttimerArr);
		parttimer.setToolTipText("Please input your employment status");
		
		
		////adds the elements for the user locational input
		homeLab = new JLabel("Where do you live? ");
		home = new JComboBox(homeArr);
		home.setToolTipText("Please input what regon your live in");
		
		
		//adds the elements for the user study input
		studiesLab = new JLabel("Do you take business studies?");
		studies = new JComboBox(studiesArr);
		studies.setToolTipText("Yes if you take business studies No if you don't ");
		
		
		//adds submit button
		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener()
				{
			
					/*when submit is clicked each user input is put into an array and checked using the classifier
					 * it then makes a pop up window that tells you if you're more or less likely to become an entrepreneur 
					 * along with the certainty of the algorithm 
					 */
					public void actionPerformed(ActionEvent e) {
						
						//makes user inputs into an array
						String[] inputs = {(String) sex.getSelectedItem(),(String) gardianBus.getSelectedItem(),(String) parttimer.getSelectedItem(),(String) home.getSelectedItem(),(String) studies.getSelectedItem()};
						
						
						//checks against classifier and displays as popup window
						JOptionPane.showMessageDialog(rootPane, checker.checker(inputs));
						
					}
				});
		
		//adds getError button to get the error
		error = new JButton("Get Error");
		error.addActionListener(( new ActionListener()
				{
					/*
					 * Creates a pop up window that prints the error that the classifier currently has
					 */
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(rootPane, " Error is " + checker.getError(percent, data));
					}
				}
				));
		
		
		retrainLab = new JLabel("Select the percent to retrain with: ");
		
		//adds a slider to allow the user to retrain the algorithm with the file we already have
		retrainPercent = new JSlider(0,100,70);
		
		//creates a clear scale for the slider spacing
		retrainPercent.setMajorTickSpacing(10);
		retrainPercent.setPaintTicks(true);
		retrainPercent.setPaintLabels(true);
		
		retrainPercent.setToolTipText("Select the percentage you want to retrain the algorithm with");
		
		
		//adds a button that allows you to retrain the algorithm
		retrain = new JButton("Retrain");
		retrain.addActionListener(new ActionListener()
				{

					public void actionPerformed(ActionEvent e) {
						//sets the percent variable to the one selected by user
						percent = (double) retrainPercent.getValue()/100;
						
						//retrains the model using the users percent 
						weights = trainer.train(percent);
						
						//informs the checker of the new training 
						checker.setWeights(weights);
						
						//produces a window to let the user know the model is retrained and the error to be expected 
						JOptionPane.showMessageDialog(rootPane,"Model successfully retrained\nError: " + checker.getError(percent, data));
						
					}
					
				}
				);
		
		//adds all elements to the frame
		add(sexLab);
		add(sex);
		add(gardianLab);
		add(gardianBus);
		add(parttimerLab);
		add(parttimer);
		add(homeLab);
		add(home);
		add(studiesLab);
		add(studies);
		add(submit);
		add(error);
		add(retrainLab);
		add(retrainPercent);
		add(retrain);
		setVisible(true);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
