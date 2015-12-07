package com.google.gwt.sample.SE_group9.client;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.core.client.EntryPoint;
import com.gwtext.client.core.*;
import com.gwtext.client.data.*;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.*;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.*;
import com.gwtext.client.widgets.form.event.FieldListenerAdapter;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.client.widgets.layout.AccordionLayout;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.layout.VerticalLayout;
import com.gwtext.client.widgets.tree.AsyncTreeNode;
import com.gwtext.client.widgets.tree.TreePanel;
import com.gwtext.client.widgets.tree.XMLTreeLoader;
import com.gwtextux.client.data.PagingMemoryProxy;
import com.kiouri.sliderbar.client.event.BarValueChangedEvent;
import com.kiouri.sliderbar.client.event.BarValueChangedHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.ColumnSortList;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextHeader;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.Timer;  
import com.gwtext.client.core.Connection;  
import com.gwtext.client.core.EventObject;  
import com.gwtext.client.core.Function;  
import com.gwtext.client.widgets.Panel;  
import com.gwtext.client.widgets.Tool;  
import com.gwtext.client.widgets.tree.TreeNode;
import com.kiouri.sliderbar.client.event.BarValueChangedEvent;
import com.kiouri.sliderbar.client.event.BarValueChangedHandler;
 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;  
import com.google.gwt.event.dom.client.ClickHandler;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;



import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.ArrayReader;
import com.gwtext.client.data.DateFieldDef;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.FloatFieldDef;
import com.gwtext.client.data.MemoryProxy;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;

public class Visualization {

	public  String [][] MoviesDataAllData; 
	
	public static String [][] MoviesDataSetAE;
	public static String [][] MoviesDataSetFM;
	public static String [][] MoviesDataSetNS;
	public static String [][] MoviesDataSetTZ;
	
	public static int numberOfLinesAllData; 
	public static int numberOfColumnsAllData;
	
	public static int numberOfLinesAE; 
	public static int numberOfColumnsAE;
	
	public static int numberOfLinesFM; 
	public static int numberOfColumnsFM;
	
	public static int numberOfLinesNS; 
	public static int numberOfColumnsNS;
	
	public static int numberOfLinesTZ; 
	public static int numberOfColumnsTZ;
	
	// hallo
	
	/*String which is used to identify the real  s
	 * name of the table in accord with 
	 * the Films who the user has choose */
	public static String listOfFilms;
	
	final Button bShowMovies = new Button("2. Show Results");
	final Button bresetfilter = new Button("3. Reset");
	final Button bpleaseFilter = new Button("1. Filter Data");
	final static Button bresults = new Button("#Results");
	
	final Button clearTable = new Button ("Clear Table");
	final Button bdrawTable = new Button ("Draw Map");
	final Button bImportData = new Button ("Import");
	final Button importMoviesAllData = new Button ("Draw Table");
	final Button importMoviesAE = new Button ("Show Movies from A to E");
	final Button importMoviesFM = new Button ("Show Movies from F to M");
	final Button importMoviesNS = new Button ("Show Movies from N to S");
	final Button importMoviesTZ = new Button ("Show Movies from T to Z (incl. Numbers)");
	final Button bDrawtable2 = new Button ("Draw Table");
	final GridPanel grid = new GridPanel();
	
	public final TabPanel tabPanel = new TabPanel();
	public final Panel centerPanel = new Panel();  
	public Panel tableToDraw = new Panel ("Table");
	
	private Store store;
	private RecordDef recordDef;
	private static String CHART_URL_PREFIX = "http://chart.apis.google.com/chart";
	private FormPanel chartForm;
	
	public void setMoviesAllData (String [][] MoviesDataSet) {MoviesDataAllData = MoviesDataSet;}
	public void setMoviesArrayAE (String [][] MoviesDataSet) {MoviesDataSetAE = MoviesDataSet; }
	public void setMoviesArrayFM (String [][] MoviesDataSet) {MoviesDataSetFM = MoviesDataSet; }
	public void setMoviesArrayNS (String [][] MoviesDataSet) {MoviesDataSetNS = MoviesDataSet; }
	public void setMoviesArrayTZ (String [][] MoviesDataSet) {MoviesDataSetTZ = MoviesDataSet; }
	
	public void setNumberOfLinesAllData (int nrLines) {numberOfLinesAllData = nrLines; }
	public void setNumberOfColumnsAllData (int nrCol) {numberOfColumnsAllData = nrCol; }
	public void setNumberOfLinesAE (int nrLines) {numberOfLinesAE = nrLines; }
	public void setNumberOfColumnsAE (int nrCol) {numberOfColumnsAE = nrCol; }
	public void setNumberOfLinesFM (int nrLines) {numberOfLinesFM = nrLines; }
	public void setNumberOfColumnsFM (int nrCol) {numberOfColumnsFM = nrCol; }
	public void setNumberOfLinesNS (int nrLines) {numberOfLinesNS = nrLines; }
	public void setNumberOfColumnsNS (int nrCol) {numberOfColumnsNS = nrCol; }
	public void setNumberOfLinesTZ (int nrLines) {numberOfLinesTZ = nrLines; }
	public void setNumberOfColumnsTZ (int nrCol) {numberOfColumnsTZ = nrCol; }
	
	public String [][] getMoviesArrayAllData () {return MoviesDataAllData; }
	public String [][] getMoviesArrayAE () {return MoviesDataSetAE;}
	public String [][] getMoviesArrayFM () {return MoviesDataSetFM;}
	public String [][] getMoviesArrayNS () {return MoviesDataSetNS;}
	public String [][] getMoviesArrayTZ () {return MoviesDataSetTZ;}
	
	public int getNumberOfLinesAllData() {return numberOfLinesAllData;}
	public int getNumberOfColumnsAllData() {return numberOfColumnsAllData;}
	public int getNumberOfLinesAE() {return numberOfLinesAE;}
	public int getNumberOfColumnsAE() {return numberOfColumnsAE;}
	public int getNumberOfLinesFM() {return numberOfLinesFM;}
	public int getNumberOfColumnsFM() {return numberOfColumnsFM;}
	public int getNumberOfLinesNS() {return numberOfLinesNS;}
	public int getNumberOfColumnsNS() {return numberOfColumnsNS;}
	public int getNumberOfLinesTZ() {return numberOfLinesTZ;}
	public int getNumberOfColumnsTZ() {return numberOfColumnsTZ;}
	
	boolean isdoubled = false;
	public Label lb = new Label ("");
	public Label lblYear = new Label ("");
	public Slider slider = new Slider();
	public WorldMap worldmap = new WorldMap();
	Panel panelGraph = new Panel("World Map"); 
	final Menu FPanel = new Menu();
	public void buildUserInterface() {
		 
		
		/***********************************************************************************************************************
         * MainStructure
         */
		
     
		
		
		
        Panel panel = new Panel();  
        panel.setBorder(false);  
        panel.setPaddings(15);  
        panel.setLayout(new FitLayout());  
  
        Panel borderPanel = new Panel();  
        borderPanel.setLayout(new BorderLayout());  
  
        /***********************************************************************************************************************
         * NorthPanel
         */
        Panel northPanel = new Panel();  
        northPanel.setHtml("<p>MovieApp</p>");  
        northPanel.setHeight(32);  
        northPanel.setBodyStyle("background-color:#FFFF88");  
        borderPanel.add(northPanel, new BorderLayoutData(RegionPosition.NORTH));


        /***********************************************************************************************************************
         * SouthPanel
         */
        Panel southPanel = new Panel();  
        southPanel.setHtml("<p>David Bamman, Brendan O'Connor and Noah Smith, \"Learning Latent Personas of Film Characters,\" in: Proceedings of the Annual Meeting of the Association for Computational Linguistics (ACL 2013), Sofia, Bulgaria, August 2013.</p>");  
        southPanel.setHeight(100);  
        southPanel.setBodyStyle("background-color:#CDEB8B");  
        southPanel.setCollapsible(true);  
        southPanel.setTitle("Informations/Source");  
  
        BorderLayoutData southData = new BorderLayoutData(RegionPosition.SOUTH);  
        southData.setMinSize(100);  
        southData.setMaxSize(200);  
        southData.setMargins(new Margins(0, 0, 0, 0));  
        southData.setSplit(true);  
        borderPanel.add(southPanel, southData);  
  
        /***********************************************************************************************************************
         * East Panel
         */
        Panel eastPanel = new Panel();  
        eastPanel.setHtml("<p>east panel</p>");  
        eastPanel.setTitle("Advertisment");  
        eastPanel.setCollapsible(true);  
        eastPanel.setWidth(225);  
  
        BorderLayoutData eastData = new BorderLayoutData(RegionPosition.EAST);  
        eastData.setSplit(true);  
        eastData.setMinSize(175);  
        eastData.setMaxSize(300);  
        eastData.setMargins(new Margins(0, 0, 5, 0));  
  
        borderPanel.add(eastPanel, eastData);  
  
        /***********************************************************************************************************************
         * WestPanel
         */
        
        bpleaseFilter.addClickHandler(new ClickHandler() {
	        public void onClick (ClickEvent event) {
	        	bpleaseFilter.setEnabled(false);
	        	bpleaseFilter.setText("Loading...");
	        	FPanel.runFilter();
	        	bpleaseFilter.setText("1. Filter Data");
	        	bpleaseFilter.setEnabled(true);
	        	bShowMovies.setEnabled(true);
	        	
	        }	
	    });
     
//        final Menu FPanel = new Menu();
        //lb.setText(MoviesDataAllData[1][3]);
        
        bShowMovies.setEnabled(false);
        bresults.setEnabled(false);
        bresetfilter.setEnabled(true);
        
        bShowMovies.addClickHandler(new ClickHandler() {
	        public void onClick (ClickEvent event) {
	        	drawTable(FPanel.filteredMoviesArrays, DataFilter.countresults + " Results for this Filter: " + Menu.filterConditionArray[0] + " + "+  Menu.filterConditionArray[1] + " + "+  Menu.filterConditionArray[2] + " + "+  Menu.filterConditionArray[3]+ " + " +  Menu.filterConditionArray[4] +  Menu.filterConditionArray[5]);
	        	bresults.setEnabled(true);
	        }	
	    });
        
        bresults.addClickHandler(new ClickHandler() {
	        public void onClick (ClickEvent event) {
	        	bresults.setText("Results: "+  DataFilter.countresults);
	        	
	        }	
	    });
        
        bresetfilter.addClickHandler(new ClickHandler() {
	        public void onClick (ClickEvent event) {
	        	bShowMovies.setEnabled(false);
	            bresults.setEnabled(false);
	        	FPanel.resetFilter();
	        	
	        }	
	    });
        
        
        Panel westPanel = FPanel.createMenu();
        
        
        westPanel.add(bpleaseFilter);
        westPanel.add(bresetfilter);
        westPanel.add(bresults);
        westPanel.add(bShowMovies);
        
    
        
        //(Panel pYear, Panel pLanguage, Panel pGenre, Panel pLenghth, Panel pCountry)
        Panel accordionPanel = FPanel.createAccordionPanel();
      
        
        westPanel.add(accordionPanel);
      //  westPanel.add(searchPanel);
        

        panel.setBorder(false);  
        panel.setPaddings(15);  
   
        borderPanel.add(westPanel, FPanel.createWestData()); 
  
        
        
        /***********************************************************************************************************************
         * CenterPanel
         */
        
        
     /** Initialisation of the TabPanel next to the Filter 
     * + Design
     */
    
    tabPanel.setActiveTab(0);
    tabPanel.setResizeTabs(true);
    tabPanel.setMinTabWidth(115);
    tabPanel.setTabWidth(135);
    tabPanel.setHeight(650); 
    
 

    /** Impementation of Functions (Type Panel) in the TabPanel
     * Functions are implemented outside the OnModulLoad
     */
    //tabPanel.add(getLineChartPanel());
    //  tabPanel.add(getPieChartPanel());
    
    /** Initialisation of the Tabs in the TabPanel
     * + Table
     * + Maps
     * + Charts
     * --> Finally added to the TabPanel
     */
    // Setting  of buttons
  

   /*Home page in the Tab Panel*/
    Panel firstPanel = new Panel ("Home Page");
    firstPanel.add(SE_group9.bImport);
	firstPanel.add(bDrawtable2);
	firstPanel.add(bdrawTable);
	firstPanel.add(lb);
	tabPanel.add(firstPanel);
	

    /** add the tabPanel and the Filter (chartForm) to the CenterPanel, which represent the big root Panel of the Application
     * + ChartForm(Filter)
     * + TabPanel
     */
    	
    	centerPanel.add(tabPanel);
    	centerPanel.add(tabPanel, new BorderLayoutData(RegionPosition.CENTER));
    	borderPanel.add(centerPanel, new BorderLayoutData(RegionPosition.CENTER));  
        
        panel.add(borderPanel);  
        centerPanel.add(tabPanel, new BorderLayoutData(RegionPosition.CENTER));
        Viewport viewport = new Viewport(panel);  
        
    
    
    /******************************************************************************************************************************************************
     * Movies Buttons
     */
       
        	// drawing the table
            bDrawtable2.addClickHandler(new ClickHandler() {
	        public void onClick (ClickEvent event) {
	        	
	        	if(isdoubled == false){
	        	String[][] result = new String[getMoviesArrayAllData().length + getMoviesArrayAE().length][];

	        	System.arraycopy(getMoviesArrayAllData(), 0, result, 0, getMoviesArrayAllData().length);
	        	System.arraycopy(getMoviesArrayAE(), 0, result, getMoviesArrayAllData().length, getMoviesArrayAE().length);
	        	MoviesDataAllData = result;
	        	 FPanel.setMoviesAllData(MoviesDataAllData);
	        	isdoubled = true;}
	        	//drawTableAllData(getMoviesArrayAE(),getNumberOfLinesAE(),getNumberOfColumnsAE());
	        	drawTable(MoviesDataAllData, "All Films");
	        
	        
	        }	
	    });
            //when the slider is changed this is triggered
        slider.addBarValueChangedHandler(new BarValueChangedHandler() {
            public void onBarValueChanged(BarValueChangedEvent event) {
                    int i = event.getValue()+1900;
                    String year = ""+i;
                    lblYear.setText(""+i);
                    List<String> countryList = new ArrayList();
                    //loops through big array to make a small one containing only counties from that year
                    for(int j = 0; j<getNumberOfLinesAllData();j++){
                    	if(MoviesDataAllData[j][3].contains(year)){

                    		countryList.add(MoviesDataAllData[j][7]);
                    		
                    	}
                    }

                  worldmap.draw(i, countryList);
                    lblYear.setText("Selected Year: "+year); 
            }
    });  
        //create world map
        bdrawTable.addClickHandler(new ClickHandler() {
	        public void onClick (ClickEvent event) {
	        
	        	worldmap.initialize();

	           panelGraph.add(worldmap.dlp);
	            panelGraph.add(slider);
	            panelGraph.add(lblYear);
	       
		        tabPanel.add(panelGraph);
		        
	        	
	        }	
	    });
        
        
          
    }
	//Defines what happens when Data is loading/Failed/done
	public void dataImportComplete(){
		SE_group9.bImport.setEnabled(true);
		lb.setText("Successfully loaded data");
		bdrawTable.setEnabled(true);
		
		bDrawtable2.setEnabled(true);
		
		 FPanel.setMoviesAllData(MoviesDataAllData);
	
		
	}
	public void dataImportFailed(){
		SE_group9.bImport.setEnabled(true);
		bdrawTable.setEnabled(true);
		bDrawtable2.setEnabled(true);
		
	}
	public void dataImportStarted(){
	
		SE_group9.bImport.setEnabled(false);
		bdrawTable.setEnabled(false);
		bDrawtable2.setEnabled(false);
		lb.setText("Loading data...");
	}
	// drawing all data one one page with gwtext
	public void drawTable (final String [][] MoviesDataSet, final String listOfFilms) {
		if (grid != null) {
    		destroyTable();
    		tableToDraw.destroy();
    		
    	}
		
			
		 			 tableToDraw.setBorder(false); 
		             RecordDef recordDef = new RecordDef(  
		                     new FieldDef[]{  
		                             new StringFieldDef("wikiID"),  
		                             new StringFieldDef("freebase"),
		                             new StringFieldDef("name"),
		                             new StringFieldDef("relase"),
		                             new StringFieldDef("revenue"),
		                             new StringFieldDef("runtime"),
		                             new StringFieldDef("language"),
		                             new StringFieldDef("country"),
		                             new StringFieldDef("genre"),
		                     }  
		             );  
		             
		           
		            String [][] stringToProxy = MoviesDataSet;
		            PagingMemoryProxy proxy = new PagingMemoryProxy(stringToProxy);
		            
		            ArrayReader reader = new ArrayReader(recordDef);  
		            Store store = new Store(proxy, reader, true);  
		            store.load();  
		            grid.setStore(store);  
		            
		            ColumnConfig[] columns = new ColumnConfig[]{  
		             
		                    new ColumnConfig("Wikipedia ID", "wikiID", 160, true, null, "wikiID"),  
		                    new ColumnConfig("Freebase ID", "freebase", 50),
		                    new ColumnConfig("Name", "name", 200, true, null),  
		                    new ColumnConfig("Relase Date", "relase", 50, true, null),  
		                    new ColumnConfig("Revenue", "revenue", 80, true, null), 
		                    new ColumnConfig("Runtime", "runtime", 40, true, null), 
		                    new ColumnConfig("Language", "language", 160, true, null), 
		                    new ColumnConfig("Country", "country", 160, true, null), 
		                    new ColumnConfig("Genre", "genre", 160, true, null), 
		            };  
		      
		            ColumnModel columnModel = new ColumnModel(columns);
		            grid.setColumnModel(columnModel);  
		            grid.setFrame(true);  
		            grid.setStripeRows(true);  
		     
		            
		            /*set the "take-place" column on the grid*/
		            grid.setAutoExpandColumn("");  
		            grid.setAutoExpandColumn("wikiID");
		      
		            grid.setHeight(400);  
		            grid.setWidth(900);
		            
		            grid.setTitle("#Movie Table  -  " +listOfFilms);
		            
		            final PagingToolbar pagingToolbar = new PagingToolbar(store);  
		            pagingToolbar.setPageSize(10);  
		            pagingToolbar.setDisplayInfo(true);  
		            pagingToolbar.setDisplayMsg("Display 10 per page");  
		            pagingToolbar.setEmptyMsg("No information"); 
		            
		            NumberField pageSizeField = new NumberField();  
		            pageSizeField.setWidth(40);  
		            pageSizeField.setSelectOnFocus(true);  
		            pageSizeField.addListener(new FieldListenerAdapter() {  
		                public void onSpecialKey(Field field, EventObject e) {  
		                    if (e.getKey() == EventObject.ENTER) {  
		                        int pageSize = Integer.parseInt(field.getValueAsString());  
		                        pagingToolbar.setPageSize(pageSize);  
		                    }  
		                }  
		            });  
		            
		            ToolTip toolTip = new ToolTip("Enter page size");  
		            toolTip.applyTo(pageSizeField);  
		            
		            pagingToolbar.addField(pageSizeField);  
		            grid.setBottomToolbar(pagingToolbar);  
		            store.load(0, 10);
		           
		      
		            
		           tableToDraw.add(grid);  
		           tabPanel.add(tableToDraw);
	}

	public void destroyTable() {
		grid.destroy();
	}
	
	
	class IndexedColumn extends Column<List<String>, String> {
	    private final int index;
	    public IndexedColumn(int index) {
	        super(new TextCell());
	        this.index = index;
	    }
	    @Override
	    public String getValue(List<String> object) {
	        return object.get(this.index);
	    }
	}
	
	
}


	
	
