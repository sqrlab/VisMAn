package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.tree.DefaultMutableTreeNode;

import data.DataMutant;


/**
 * This class is used to represent the leaf nodes of the file system tree which
 * are the class level source files of the program.
 * @author David Petras
 *
 */
public class ClassNode extends DefaultMutableTreeNode {
	
	private File sourceFile; //The actual .java source code file.
	private String sourceCode; //A string containing the source code for the class.
	private ArrayList<DataMutant> mutantList;
	
	/**
	 * This method is used to construct a new instance of a class node.
	 * @param _sourceFile
	 */
	public ClassNode(File _sourceFile)
	{
		super(_sourceFile);
		mutantList = new ArrayList<DataMutant>();
		sourceFile = _sourceFile;
		loadSourceCode();
	}
	
	@Override
	public String toString()
	{
		return sourceFile.getName();
	}
	
	/**
	 * This method will take each line of the source file and add them to the
	 * source code string.
	 */
	private void loadSourceCode()
	{
		Scanner input;
		sourceCode = "";
		try 
		{
			input = new Scanner(sourceFile);
			while(input.hasNextLine())
			{
				sourceCode += "\n"+input.nextLine();
			}
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will return the source code for a class node.
	 * @return the source code
	 */
	public String getSource()
	{
		return this.sourceCode;
	}
	
	/**
	 * Accessor method to get the name of the class.
	 * @return the name of the class
	 */
	public String getName()
	{
		return sourceFile.getName();
	}
	
	/**
	 * This method will add a mutant to the classNode.
	 * @param _mutant a mutated version of the class
	 */
	public void addMutant(DataMutant _mutant)
	{
		this.mutantList.add(_mutant);
	}
	
	/**
	 * Accessor method to get the mutants associated with the class.
	 * @return a list of mutants
	 */
	public ArrayList<DataMutant> getMutantList()
	{
		return this.mutantList;
	}
	
	/**
	 * This method will calculate the average percentage of test cases that are able
	 * to detect a mutant for all the mutants of the class.
	 * @return the average percent of test cases that kill a mutant of the class
	 */
	public double getAggregateData()
	{
		double mutantPercentSum = 0;
		for (DataMutant mutant: mutantList)
		{
			mutantPercentSum += mutant.getPercentKilled();
		}
		
		return mutantPercentSum/mutantList.size();
	}
	
	/**
	 * Accessor method to get the number of mutants in the class.
	 * @return the number of mutant versions of the class
	 */
	public int getNumberOfMutants()
	{
		return this.mutantList.size();
	}
	
	/**
	 * 
	 * @return
	 */
	public int getLowDetected()
	{
		int numberOfLow = 0;
		for (DataMutant mutant: mutantList)
		{
			if (mutant.getPercentKilled() <= 0.33)
			{
				numberOfLow++;
			}
		}
		return numberOfLow;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getMedDetected()
	{
		int numberOfMed = 0;
		for (DataMutant mutant: mutantList)
		{
			if (mutant.getPercentKilled() > 0.33 && mutant.getPercentKilled() <= 0.66)
			{
				numberOfMed++;
			}
		}
		return numberOfMed;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getHighDetected()
	{
		int numberOfHigh = 0;
		for (DataMutant mutant: mutantList)
		{
			if (mutant.getPercentKilled() > 0.66)
			{
				numberOfHigh++;
			}
		}
		return numberOfHigh;
	}
}
