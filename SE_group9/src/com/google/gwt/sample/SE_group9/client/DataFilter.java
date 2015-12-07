package com.google.gwt.sample.SE_group9.client;

import java.util.ArrayList;
import java.util.List;

public class DataFilter {
	
	public  String [][] MoviesDataAllData;
	ArrayList<String[]> filteredArrayList = new ArrayList<String[]>();
	public  String [][] filteredTempArray;
	public String cyear = "";
	public String clang = "";
	public String cgenre ="";
	public String clength = "";
	public String ccountry = "";
	public String cmoviename = "";
	public static int countresults = 0;
	
	public DataFilter(String[][] datainit){
		MoviesDataAllData = datainit;
	}
	//TODO fix this
	public String[][] filterYear(String year){
		int rowCount = 1;
		

    	//	for (int i =0; i< 200; i++){
    			
    		//	if(MoviesDataAllData[i][3].contains(year)){counter++;}
    			
    		//}
    		
    		String[][] filterArray = new String[80000][9];
    		for (int i=0; i<79999;i++){
    				if(MoviesDataAllData[i][3].contains(year) ){
    				for(int k = 0; k< 9; k++){
    					filterArray[rowCount][k] = MoviesDataAllData[i][k];
    					
    				}	
    			
    			rowCount++;
    		}
    		}
    		int rc = 1;
    		String[][] filterTwo = new String[rowCount+2][9];
    		for(int i = 0 ; i <rowCount;i++){
    			for(int k = 0; k< 9; k++){
					filterTwo[rc][k] = filterArray[i][k];
					
				}	
    			rc++;
    		}
    		
    	int countlength = 0;
    		while((filterTwo[countlength][0]!=null)){
    			countlength++;
    		}
		return filterTwo;
		
	}
	

	public String getTextDataFilter() {
		return MoviesDataAllData[1][2];
	}

	public String[][] filterCollector(String year, String language, String genre, String length, String country, String moviename){
		String[][] mytempArray1;
		String[][] mytempArray2;
		String[][] mytempArray3;
		String[][] mytempArray4;
		String[][] mytempArray5;
		String[][] mytempArray6;
		
		
		 if (year.isEmpty() == false){
			  cyear = year;
		 }else{
			  cyear = "";
		 }
		 
		 if (language.isEmpty() == false){
			  clang = language;
		 }else{
			  clang = "";
		 }
		 
		 if (genre.isEmpty() == false){
			  cgenre = genre;
		 }else{
			  cgenre = "";
		 }
		 
		 if (length.isEmpty() == false){
			  clength = length;
		 }else{
			  clength = "";
		 }
		 
		 if (country.isEmpty() == false){
			  ccountry = country;
		 }else{
			  ccountry = "";
		 }
		
		 if (moviename.isEmpty() == false){
			  cmoviename = moviename;
		 }else{
			 	cmoviename = "";
		 }	
		 
		//Filter year
		mytempArray1 = filterYear(year);
		Menu.btestyear.setText("" + mytempArray1[3][3]);
		mytempArray2 = filter(clang,6, mytempArray1);
		
		mytempArray3 = filter(cgenre,8,mytempArray2);
		mytempArray4 = filter(clength,5,mytempArray3);
		mytempArray5 = filter(ccountry,7,mytempArray4);
		mytempArray6 = filter(cmoviename,2,mytempArray5);
		
		return mytempArray6;
		
		
			
		}
	

	public String[][] filter(String searchString, int index, String[][] array){
		int rowCount = 1;
		
    	//	for (int i =0; i< 200; i++){
    			
    		//	if(MoviesDataAllData[i][3].contains(year)){counter++;}
    			
    		//}
    		
    		String[][] filterArray = new String[array.length][9];
    		Menu.btestyear.setText("Hajvan bevor if");
			Menu.btestyear.setText("test:" + array.length +" " + array[5][index] +" " + array[5][5]);
			
    		for (int i=2; i<array.length-1;i++){
    			
    				if(array[i][index].toLowerCase().contains(searchString.toLowerCase()) ){
    					
    				for(int k = 0; k< 9; k++){
    					Menu.btestyear.setText("Hajvan is in forschleife here");
    					filterArray[rowCount][k] = array[i][k];
    					
    				}	
    			
    			rowCount++;
    		}
    			Menu.btestyear.setText("FilterArray was successfull");
    		}
    		
    		int countlength = 2;
    		while((filterArray[countlength][0]!=null)){
    			countlength++;
    		}
    		
    		countresults = countlength-1; 
    		
    		int rc = 0;
    		String[][] filterTwo = new String[countlength][9];
    		for(int i = 1 ; i <filterTwo.length+1;i++){
    			for(int k = 0; k< 9; k++){
					filterTwo[rc][k] = filterArray[i][k];
					
				}	
    			rc++;
    		}
    	return filterTwo;
		
	}
	
	}

