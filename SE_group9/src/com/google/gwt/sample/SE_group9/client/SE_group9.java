package com.google.gwt.sample.SE_group9.client;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextHeader;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.gwtext.client.widgets.grid.GridPanel;
import com.kiouri.sliderbar.client.event.BarValueChangedEvent;
import com.kiouri.sliderbar.client.event.BarValueChangedHandler;



/***
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SE_group9 implements EntryPoint{

	/**
	 * This is the entry point method.
	 */
	
	/* stores the path where the excel files are saved (us directory) 
	 * we have to split the excel file Movies_8000 -> waiting time to high!
	 * */
	public final static String MOVIES_PATH_ALLDATA = "/excelFiles/movies_80000.tsv";//"/excelFiles/moviesAE.txt";
	public final static String MOVIES_PATH_AE = "/excelFiles/MoviesCountry.txt";//"/excelFiles/moviesAE.txt";
	public final static String MOVIES_PATH_FIRSTHALF = "/excelFiles/Movies40000.txt";//"/excelFiles/moviesFM.txt";
	public final static String MOVIES_PATH_SECONDHALF = "/excelFiles/Movies40000_2.txt";//"/excelFiles/moviesNS.txt";
	public final static String MOVIES_PATH_TZ= "/excelFiles/TestTZ.txt";//"/excelFiles/moviesTZ.txt";
	
	/*String which is used to identify the real 
	 * name of the table in accord with 
	 * the Films who the user has choose */

	public static int importedNumberOfLines = 0;
	public static int importedNumberOfColumns = 0; 
	
	/*Array which takes as input the data set in the server class*/
	public static String [][] twoDimArrayImportedDataSet;
	public static String [][] twoDimArrayImportedDataSet2;

	/*async object used for the server side import of the data*/
	public GreetingServiceAsync newData = GWT.create(GreetingService.class);
	public static Button bImport = new Button("Import data");
	public static Button bImport2 = new Button("Import data2");
	Label testlabel = new Label("test");
	Label testlabel2 = new Label("test");
	public static Button bDrawMap = new Button("DrawMap");

		Visualization userPanel = new Visualization();
		WorldMap worldmap = new WorldMap();
	
   // is executed when loaded
	public void onModuleLoad() {
		
		userPanel.buildUserInterface();		
	    bImport.addClickHandler(new ClickHandler() {
	        public void onClick (ClickEvent event) {
	        	importData(MOVIES_PATH_FIRSTHALF);
	        	
	        }
	        
	    });	
	
	    
        	}
// import first half of the array		
 public void importData(String path){
	 userPanel.dataImportStarted();
	 importNumberOfLines (path);
	 importNumberOfColums (path);
     importTwoDimArrayToClient(path);
 }
//import second half of the array	
 public void importData2(String path){
	 userPanel.dataImportStarted();
	 importNumberOfLines (path);
	 importNumberOfColums (path);
     importTwoDimArrayToClient2(path);
 }
 
 
 
 
	/** calls the server side method to import the two dimensional string arrays
	 * @param path, the path of the directory
	 */
	public void importTwoDimArrayToClient (String path) {
		if (newData == null) {
	    	newData = GWT.create(GreetingService.class);
	    }
		
		AsyncCallback <String[][]> callback = new AsyncCallback <String[][]> () {

			@Override
			public void onFailure(Throwable caught) {
				//the Data has failed to load
				userPanel.lb.setText("Error in the import of the data set, please try again");
				userPanel.dataImportFailed();
			}

			@Override
			public void onSuccess(String[][] result) {
				// The data was successfully loaded and filled into an Array
				twoDimArrayImportedDataSet = new String [importedNumberOfLines][importedNumberOfColumns];
				twoDimArrayImportedDataSet = result; 
				
	        	userPanel.setMoviesAllData(twoDimArrayImportedDataSet);
	        	userPanel.setNumberOfColumnsAllData(importedNumberOfColumns);
	        	userPanel.setNumberOfLinesAllData(importedNumberOfLines);
				
	        	userPanel.dataImportComplete();
	        	testlabel2.setText("success");
	   
	        	
	        	testlabel2.setText("successful");
	        	importData2(MOVIES_PATH_SECONDHALF);
			}
			
		};
		
		newData.importData(path, callback);
		
	}
	public void importTwoDimArrayToClient2 (String path) {
		if (newData == null) {
	    	newData = GWT.create(GreetingService.class);
	    }
		
		AsyncCallback <String[][]> callback = new AsyncCallback <String[][]> () {

			@Override
			public void onFailure(Throwable caught) {
				//the Data has failed to load
				userPanel.lb.setText("Error in the import of the data set, please try again");
				userPanel.dataImportFailed();
			}

			@Override
			public void onSuccess(String[][] result) {
				// The data was successfully loaded and filled into an Array
				twoDimArrayImportedDataSet = new String [importedNumberOfLines][importedNumberOfColumns];
				twoDimArrayImportedDataSet = result; 
				
	        	userPanel.setMoviesArrayAE(twoDimArrayImportedDataSet);
	        	userPanel.setNumberOfColumnsAE(importedNumberOfColumns);
	        	userPanel.setNumberOfLinesAE(importedNumberOfLines);
				
	        	userPanel.dataImportComplete();
	        	testlabel2.setText("success");
	        	//worldmap.createDataTale();
	        	
	        	testlabel2.setText("successful");

			}
			
		};
		
		newData.importData(path, callback);
		
	}
	/** calls the server side method to import the number of lines in
	 * the two dimensional array
	 * @param path, the path of the MOVIES_80000.tsv file
	 */
	public void importNumberOfLines (String path) {
		 // Initialize the service proxy.
	    if (newData == null) {
	    	newData = GWT.create(GreetingService.class);
	    }
	    
	    AsyncCallback <Integer> callback = new AsyncCallback <Integer>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Integer result) {
				importedNumberOfLines = result;
			
				
			}
	    
	    };
	    
	    newData.getNumberOfLines(path, callback);
	}
	/** calls the server side method to import the number of columns in
	 * the two dimensional array
	 * @param path, the path of the MOVIES_80000.tsv file
	 */
	public void importNumberOfColums (String path) {
		 // Initialize the service proxy.
	    if (newData == null) {
	    	newData = GWT.create(GreetingService.class);
	    }
	    
	    AsyncCallback <Integer> callback = new AsyncCallback <Integer>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Integer result) {
				importedNumberOfColumns = result; 
				
			}
	    	
	    	
	    	
	    };
	    
	    newData.getNumberOfColumns(path, callback);
	    
	}
	

}
	
