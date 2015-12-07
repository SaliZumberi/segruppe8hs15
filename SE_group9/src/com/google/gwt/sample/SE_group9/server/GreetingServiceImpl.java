package com.google.gwt.sample.SE_group9.server;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import javax.servlet.ServletContext;

import com.google.gwt.sample.SE_group9.client.GreetingService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
//import com.google.gwt.user.server.rpc.UnexpectedException;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService  {
	
	/** import the data from the excel file and stores them in a two-dimensional Array of type String
	 * @param path, the path of the directory
	 */
	@Override
	public String[][] importData (String path) {
		ServletContext context = getServletContext();
		String fullPath = context.getRealPath(path);
		String tsvFile = fullPath;
		
		/*Define the regular expression for the specials charachters*/
		String regEx = "\"/m/[a-z_0-9]*\" \"|[{]|[}]|\"|/m/[a-z_s0-9]*|[:]|Language";	
		Pattern pattern = Pattern.compile(regEx);
		
		//BufferedReader br = null;
		BufferedReader br2 = null;
		
		/*initialize String line which reads line by line the tsv file*/
		String line = "";
		
		/* "\t" as delimiter used: in tsv files each column is divided with a "tab-space" */
		String tvsSplitBy = "\\t";
	
		/*Declare a 2D array where we will store the tsv file; */
		String [][] twoDimArrayDataSet = new String [getNumberOfLines(path)][getNumberOfColumns(path)];
		
		/*declare a variable row which points to the actual position(row) in the excel file*/
		int row = 0;
		
		/*get number of Columns in the excel file*/
		int numberOfColumns = getNumberOfColumns(path);
		
		try {
			br2 = new BufferedReader(new FileReader(tsvFile));
			while ((line = br2.readLine()) != null) {

			     /* use tab as separator in the tsv file */
				String [] splitLine = line.split(tvsSplitBy);
				
				for (int i = 0; i < numberOfColumns; i++) {
					twoDimArrayDataSet [row][i] = splitLine[i];
					
					/*freebase charachters consider from column 5 */
					if (i > 4) {
					Matcher m = pattern.matcher(twoDimArrayDataSet[row][i]);
					twoDimArrayDataSet[row][i] = m.replaceAll("");
					}
				}
				row++;	 
				/*
				splitLine[0]; // Wikipedia ID
				splitLine[1]; // Freebase movie ID
				splitLine[2]; // Movie name
				splitLine[3]; // Movie release date
				splitLine[4]; // Movie box office revenue
				splitLine[5]; // Movie runtime
				spltiLine[6]; // Movie languages (Freebase ID:name tuples)
				splitLine[7]; // Movie countries (Freebase ID:name tuples)
				splitLine[8]; // Movie genres (Freebase ID:name tuples)
				*/
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br2 != null) {
				try {
					br2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return twoDimArrayDataSet;

	}

	/** Method that counts the number of Lines in the excel file
	 * @param path, the path of the directory
	 */
	@Override
	public Integer getNumberOfLines (String path) {
		BufferedReader br = null;
		ServletContext context = getServletContext();
		String fullPath = context.getRealPath(path);
		String tsvFile = fullPath;
		int nrOfLines = 0; 
		
		/*get number of rows to define the size of the 2D array */
		try {
			/*it takes the tsv file as input*/
			br = new BufferedReader(new FileReader(tsvFile));
			while ((br.readLine()) != null) {
				nrOfLines++; 
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return nrOfLines; 
	}


	/** Method that counts the number of columns in the excel file
	 * @param path, the path of the directory
	 */
	@Override
	public Integer getNumberOfColumns(String path) {
		ServletContext context = getServletContext();
		String fullPath = context.getRealPath(path);
		String tsvFile = fullPath;
		BufferedReader br2 = null;
		String line = "";
		String tvsSplitBy = "\\t";
		int nrOfCol = 0; 
		
		/*get number of columns to define the size of the 2D array */
		try {
			/*it takes the tsv file as input*/
			br2 = new BufferedReader(new FileReader(tsvFile));	
			
			while ((line = br2.readLine()) != null) {
				/* define a local one-dimensional String which stores the line divided
				 * by the "tsvSplit"
				 */
				String [] splitLine = line.split(tvsSplitBy);
				nrOfCol = splitLine.length;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br2 != null) {
				try {
					br2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		  }	
		
		return nrOfCol;
	}

}





