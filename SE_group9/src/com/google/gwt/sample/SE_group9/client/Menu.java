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
import com.gwtext.client.widgets.Panel;  
import com.gwtext.client.widgets.Tool;  
import com.gwtext.client.widgets.tree.TreeNode;
 

import java.util.ArrayList;
import java.util.Arrays;
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

import com.google.gwt.core.client.EntryPoint;  
import com.google.gwt.user.client.ui.RootPanel;  
import com.gwtext.client.core.EventObject;  
import com.gwtext.client.data.Record;  
import com.gwtext.client.data.SimpleStore;  
import com.gwtext.client.data.Store;  
import com.gwtext.client.widgets.Panel;  
import com.gwtext.client.widgets.form.ComboBox;  
import com.gwtext.client.widgets.form.Field;  
import com.gwtext.client.widgets.form.FormPanel;  
import com.gwtext.client.widgets.form.event.ComboBoxCallback;  
import com.gwtext.client.widgets.form.event.ComboBoxListenerAdapter; 




public class Menu {
	public String clickedStringyear = "";
	public String clickedStringlanguage = "";
	public String clickedStringgenre= "";
	public String clickedStringlength = "";
	public String clickedStringcountry = "";
	private String getTextString = "fail";
	public static String[] filterConditionArray = new String[]{"", "", "", "","",""};;

	DataFilter datafilter;
	
	final Button bSHow = new Button ("Show this County");
	final Button bshowyears = new Button("show years");
	final Button baddtoFilter = new Button ("add To Filter");
	final Button bresetSearchFilter = new Button ("Reset Fields");
	final static Button btestyear = new Button("Show Index");
	   
	public static String [][] movies = new String[5][4];
	public String [][] getMovies () {return movies;}
	public static int  getColums(){ return movies[0].length;}
	public static int	getRows(){return movies.length;}
	public static int numberOfLines = getColums(); 
	public static int numberOfColumns =getRows();
	
	public static String [][] MoviesDataAllData; 
	
	ArrayList<String[]> filteredArrayList = new ArrayList<String[]>();
	public  String [][] filteredMoviesArrays;
	public  String [][] newfilteredMoviesArrays;
	
	public Menu(){
	
	}
	public Menu (String[][] dataset){
		MoviesDataAllData = dataset;
        createDatafilter();
	}
	public void setMoviesAllData(String[][] dataset){
		MoviesDataAllData = dataset;
        createDatafilter();
	}
	
	public Panel westPanel = new Panel();  
	
	public void fillin(){
		movies[0][0] = "James Bond";
		movies[0][1] = "German";
		movies[0][2] = "60";
		movies[0][3] = "5000";
		
		movies[1][0] = "James Bond 2 ";
		movies[1][1] = "English";
		movies[1][2] = "90";
		movies[1][3] = "10000";
		
		movies[2][0] = "James Bond 3";
		movies[2][1] = "Franz";
		movies[2][2] = "120";
		movies[2][3] = "5000";
		
		movies[3][0] = "James Bond 4";
		movies[3][1] = "English";
		movies[3][2] = "90";
		movies[3][3] = "15000";
		
		movies[4][0] = "James Bond 5";
		movies[4][1] = "German";
		movies[4][2] = "120";
		movies[4][3] = "15000";
	}
	
	public Panel createMenu(){
	
	       // westPanel.setHtml("<p>west panel</p>");  
	        westPanel.setTitle("Menu");  
	        westPanel.setBodyStyle("background-color:#EEEEEE");  
	        westPanel.setCollapsible(true);  
	        westPanel.setWidth(250);  
		return westPanel ;
		
	}
	
	public BorderLayoutData createWestData(){
		 BorderLayoutData westData = new BorderLayoutData(RegionPosition.WEST);  
	        westData.setSplit(true);  
	        westData.setMinSize(175);  
	        westData.setMaxSize(400);  
	        westData.setMargins(new Margins(0, 5, 0, 0));
		
		return westData ;
	}
	
	public Panel createAccordionPanel(){
		Panel accordionPanel = new Panel();  
		accordionPanel.setTitle("Filter Selection");  
        accordionPanel.setHeight(400);  
        accordionPanel.setLayout(new AccordionLayout(true)); 
        
        /********PANEL Search ********************************************************************************************/
        Panel panelsix= new Panel("SearchBox", "<p>Panel5 content!</p>");  
        panelsix.setIconCls("user-add-icon");  
        FormPanel searchPanels = createSearchs();
        panelsix.add(searchPanels);
        accordionPanel.add(panelsix);  
  
 
        /********PANEL ONE ********************************************************************************************/
        Panel panelOne = new Panel("Year", "<p>Panel1 content!</p>");  
        panelOne.setIconCls("settings-icon");
        
        final ListBox yearpanel 	= createYearList();
        panelOne.add(yearpanel);
        
     
        panelOne.add(btestyear);
        
        final Button btestshow = new Button("Show Year");
        panelOne.add(btestshow);
        
        final Label ltestyear = new Label();
        panelOne.add(ltestyear);
               
        yearpanel.addClickHandler(new ClickHandler() {
	        public void onClick (ClickEvent event) {
	        	int numberindex = yearpanel.getSelectedIndex();
	        	clickedStringyear = yearpanel.getItemText(numberindex);
	        	filterConditionArray[0]= clickedStringyear;
	        	btestyear.setText(clickedStringyear);
	        	btestyear.setText("" + filteredMoviesArrays.length);
	        	        	
	        	ltestyear.setText("Button: " + clickedStringyear);
	        }	
	    });
        
        accordionPanel.add(panelOne);  
        
        /********PANEL TWO ********************************************************************************************/
        Panel panelTwo = new Panel("Language", "<p>Panel2 content!</p>");  
        final ListBox languepanel 	= createLanguages();
                 
        panelTwo.setIconCls("folder-icon");  
        panelTwo.add(languepanel);
        
        languepanel.addClickHandler(new ClickHandler() {
	        public void onClick (ClickEvent event) {
	        	int numberindex = languepanel.getSelectedIndex();
	        	clickedStringlanguage = languepanel.getItemText(numberindex);
	        	filterConditionArray[1]= clickedStringlanguage;
	        }	
	    });

        
        accordionPanel.add(panelTwo);  
        
        /********PANEL THREE ********************************************************************************************/
        Panel panelThree = new Panel("Genre", "<p>Panel3 content!</p>");  
        final ListBox genrepanel 	= createGenreList();
        panelThree.setIconCls("user-add-icon");  
        panelThree.add(genrepanel);
        genrepanel.addClickHandler(new ClickHandler() {
	        public void onClick (ClickEvent event) {
	        	int numberindex = genrepanel.getSelectedIndex();
	        	clickedStringgenre = genrepanel.getItemText(numberindex);
	        	filterConditionArray[2]= clickedStringgenre;
	        }	
	    });
        
        accordionPanel.add(panelThree);  
        
        /********PANEL FOUR ********************************************************************************************/
        Panel panelFour = new Panel("Lenght", "<p>Panel4 content!</p>");  
        panelFour.setIconCls("user-add-icon");  
       
        panelFour.add(createLength());
        accordionPanel.add(panelFour);  
        
        /********PANEL FIVE ********************************************************************************************/
        Panel panelFive = new Panel("Country", "<p>Panel5 content!</p>");  
        panelFive.setIconCls("user-add-icon");  
        FormPanel statespanel = createStates();
        panelFive.add(statespanel);
        accordionPanel.add(panelFive);  
       

        return accordionPanel;  
	}
	
	public void runFilter(){
		filteredMoviesArrays = datafilter.filterCollector(filterConditionArray[0],filterConditionArray[1],filterConditionArray[2],filterConditionArray[3],filterConditionArray[4],filterConditionArray[5]);
	}
	
	public void resetFilter(){
		filterConditionArray[0] = "";
		filterConditionArray[1] = "";
		filterConditionArray[2] = "";
		filterConditionArray[3] = "";
		filterConditionArray[4] = "";
		filterConditionArray[5] = "";
	}
	
	public void createDatafilter(){
		 DataFilter filter = new DataFilter(MoviesDataAllData);
		 datafilter = filter;
	}
 
	public FormPanel createStates(){
		
        FormPanel form = new FormPanel();  
        form.setLabelWidth(35);  
        form.setBorder(false);  
        //create a Store using local array data  
        final Store store = new SimpleStore(new String[]{"abbr", "state",}, getStates());  
        store.load();  
  
        final ComboBox cb = new ComboBox();  
        cb.setForceSelection(true); 
        cb.setMinChars(1);  
        cb.setFieldLabel("Country");  
        cb.setStore(store);  
        cb.setDisplayField("state");  
        cb.setMode(ComboBox.LOCAL);  
        cb.setTriggerAction(ComboBox.ALL);  
        cb.setEmptyText("Enter country");  
        cb.setLoadingText("Searching...");  
        cb.setTypeAhead(true);  
        cb.setSelectOnFocus(true);  
        cb.setWidth(180);  
  
        cb.setHideTrigger(false);  
  
        cb.addListener(new ComboBoxListenerAdapter() {  
            public boolean doBeforeQuery(ComboBox comboBox, ComboBoxCallback cb) {  
                System.out.println("ComboBox::doBeforeQuery()");  
                return true;  
            }  
  
            public boolean doBeforeSelect(ComboBox comboBox, Record record, int index) {  
                System.out.println("ComboBox::doBeforeSelect(" +  
                                        record.getAsString("state") + ")");  
                return super.doBeforeSelect(comboBox, record, index);  
            }  
  
            public void onCollapse(ComboBox comboBox) {  
                System.out.println("ComboBox::onCollapse()");  
            }  
  
            public void onExpand(ComboBox comboBox) {  
                System.out.println("ComboBox::onExpand()");  
            }  
  
            public void onSelect(ComboBox comboBox, Record record, int index) {  
                System.out.println("ComboBox::onSelect('" + record.getAsString("state") + "')"); 
                clickedStringcountry = record.getAsString("state");
            }  
  
            public void onBlur(Field field) {  
                System.out.println("ComboBox::onBlur()");  
            }  
  
            public void onChange(Field field, Object newVal, Object oldVal) {  
                System.out.println("ComboBox::onChange(" + oldVal + "-->" + newVal + ")");  
            }  
  
            public void onFocus(Field field) {  
                System.out.println("ComboBox::onFocus()");  
            }  
  
            public void onInvalid(Field field, String msg) {  
                super.onInvalid(field, msg);  
            }  
  
            public void onSpecialKey(Field field, EventObject e) {  
                System.out.println("ComboBox::onSpecialKey(key code " + e.getKey() + ")");  
            }  
        });  
  
        final Label muti = new Label();
        form.add(muti);
        
        form.add(bSHow);

        bSHow.addClickHandler(new ClickHandler() {
	        public void onClick (ClickEvent event) {
	            filterConditionArray[4]= cb.getText();
	        	muti.setText("Country: " + cb.getText());
	        	
	        
	        
	        }	
	    });
        
        
        
        
        		
        form.add(cb);  
		return form;
	}
	
	public ListBox createGenreList(){
		
		ListBox list = new ListBox();
		list.setVisibleItemCount(15);
        list.setMultipleSelect(false);
        list.setWidth("100");
        list.addItem("Thriller");
        list.addItem("Mystery");
        list.addItem("Crime Fiction");
        list.addItem("Drama");
        list.addItem("Short Film");
        list.addItem("Family Film");
        list.addItem("Musical");
        list.addItem("Horror");
        list.addItem("Romantic comedy");
        list.addItem("Costume drama");
        list.addItem("Comedy");
        list.addItem("Science Fiction");
        list.addItem("Children's/Family");
        list.addItem("Romance Film");
        list.addItem("Comedy film");
        list.addItem("Action");
        list.addItem("World cinema");
        list.addItem("Black-and-white");
        list.addItem("Action/Adventure");
        list.addItem("Parody");
        list.addItem("Fan film");
        list.addItem("Black comedy");
        list.addItem("Silent film");
        list.addItem("Adventure");
        list.addItem("Sports");
        list.addItem("Fantasy");
        list.addItem("War film");
        list.addItem("Romantic drama");
        list.addItem("Culture & Society");
        list.addItem("Malayalam Cinema");
        list.addItem("Western");
        list.addItem("Bollywood");
        list.addItem("Documentary");
        list.addItem("Softcore Porn");
        list.addItem("Erotic Drama");
        list.addItem("Chinese Movies");
        list.addItem("Film noir");
        list.addItem("Biography");
        list.addItem("Family Drama");
        list.addItem("History");
        list.addItem("Experimental film");
        list.addItem("Monster movie");
        list.addItem("Gender Issues");
        list.addItem("Music");
        list.addItem("Japanese Movies");
        list.addItem("Melodrama");
        list.addItem("Indie");
        list.addItem("Ensemble Film");
        list.addItem("Art film");
        list.addItem("Film adaptation");
        list.addItem("LGBT");
        list.addItem("Wuxia");
        list.addItem("Political cinema");
        list.addItem("Period piece");
        list.addItem("Cult");
        list.addItem("Pornographic movie");
        list.addItem("Sword and sorcery");
        list.addItem("Biographical film");
        list.addItem("Animation");
        list.addItem("Propaganda film");
        list.addItem("B-movie");
        list.addItem("Filipino Movies");
        list.addItem("Concert film");
        list.addItem("Film \u00e0 clef");
        list.addItem("Pre-Code");
        list.addItem("Christian film");
        list.addItem("Disaster");
        list.addItem("Television movie");
        list.addItem("Historical Epic");
        list.addItem("Dance");
        list.addItem("Political drama");
        list.addItem("Gothic Film");
        list.addItem("Zombie Film");
        list.addItem("Docudrama");
        list.addItem("Historical fiction");
        list.addItem("Action Thrillers");
        list.addItem("Media Satire");
        list.addItem("Computer Animation");
        list.addItem("Fantasy Adventure");
        list.addItem("Dogme 95");
        list.addItem("Backstage Musical");
        list.addItem("Slapstick");
        list.addItem("Political satire");
        list.addItem("Coming of age");
        list.addItem("Sex comedy");
        list.addItem("Historical drama");
        list.addItem("Gay pornography");
        list.addItem("Time travel");
        list.addItem("Crime Comedy");
        list.addItem("Kitchen sink realism");
        list.addItem("Heist");
        list.addItem("Slasher");
        list.addItem("Sci-Fi Horror");
        list.addItem("Road movie");
        list.addItem("Comedy of Errors");
        list.addItem("Archaeology");
        list.addItem("Crime Drama");
        list.addItem("Satire");
        list.addItem("Absurdism");
        list.addItem("Swashbuckler films");
        list.addItem("Psychological thriller");
        list.addItem("Stop motion");
        list.addItem("Comedy-drama");
        list.addItem("Hardcore pornography");
        list.addItem("Anti-war");
        list.addItem("Comedy of manners");
        list.addItem("Natural horror films");
        list.addItem("Buddy film");
        list.addItem("Children's");
        list.addItem("Animals");
        list.addItem("Anime");
        list.addItem("Tragedy");
        list.addItem("Comedy Western");
        list.addItem("Feminist Film");
        list.addItem("Pornography");
        list.addItem("Combat Films");
        list.addItem("Rockumentary");
        list.addItem("Blaxploitation");
        list.addItem("Educational");
        list.addItem("Children's Fantasy");
        list.addItem("Spaghetti Western");
        list.addItem("Tollywood");
        list.addItem("Mockumentary");
        list.addItem("Alien Film");
        list.addItem("Religious Film");
        list.addItem("Erotica");
        list.addItem("Martial Arts Film");
        list.addItem("Inspirational Drama");
        list.addItem("Remake");
        list.addItem("Demonic child");
        list.addItem("Screwball comedy");
        list.addItem("Gangster Film");
        list.addItem("Americana");
        list.addItem("Revisionist Western");
        list.addItem("Surrealism");
        list.addItem("Marriage Drama");
        list.addItem("Social problem film");
        list.addItem("Illnesses & Disabilities");
        list.addItem("Biopic [feature]");
        list.addItem("Animal Picture");
        list.addItem("Bengali Cinema");
        list.addItem("Hip hop movies");
        list.addItem("Space opera");
        list.addItem("Crime Thriller");
        list.addItem("Prison");
        list.addItem("Roadshow/Carny");
        list.addItem("Sword and Sandal");
        list.addItem("Nature");
        list.addItem("Christmas movie");
        list.addItem("Spy");
        list.addItem("Children's Entertainment");
        list.addItem("Film");
        list.addItem("Fantasy Comedy");
        list.addItem("Jungle Film");
        list.addItem("Adult");
        list.addItem("Tamil cinema");
        list.addItem("Film & Television History");
        list.addItem("Horror Comedy");
        list.addItem("Alien invasion");
        list.addItem("Costume Adventure");
        list.addItem("Revenge");
        list.addItem("Historical Documentaries");
        list.addItem("Heaven-Can-Wait Fantasies");
        list.addItem("Prison film");
        list.addItem("Travel");
        list.addItem("Animated cartoon");
        list.addItem("Mythological Fantasy");
        list.addItem("Jukebox musical");
        list.addItem("Werewolf fiction");
        list.addItem("Heavenly Comedy");
        list.addItem("Horse racing");
        list.addItem("Indian Western");
        list.addItem("Comedy horror");
        list.addItem("Exploitation");
        list.addItem("Action Comedy");
        list.addItem("Inventions & Innovations");
        list.addItem("Punk rock");
        list.addItem("Musical comedy");
        list.addItem("Environmental Science");
        list.addItem("Suspense");
        list.addItem("Women in prison films");
        list.addItem("Fictional film");
        list.addItem("Computers");
        list.addItem("Education");
        list.addItem("Film-Opera");
        list.addItem("Period Horror");
        list.addItem("Tragicomedy");
        list.addItem("Stoner film");
        list.addItem("Courtroom Drama");
        list.addItem("Crime");
        list.addItem("Media Studies");
        list.addItem("Haunted House Film");
        list.addItem("Albino bias");
        list.addItem("Hagiography");
        list.addItem("Epic Western");
        list.addItem("Childhood Drama");
        list.addItem("Adventure Comedy");
        list.addItem("Detective");
        list.addItem("Extreme Sports");
        list.addItem("Pinku eiga");
        list.addItem("Detective fiction");
        list.addItem("Auto racing");
        list.addItem("News");
        list.addItem("Language & Literature");
        list.addItem("Gross out");
        list.addItem("Avant-garde");
        list.addItem("Domestic Comedy");
        list.addItem("Instrumental Music");
        list.addItem("Sexploitation");
        list.addItem("Doomsday film");
        list.addItem("Cyberpunk");
        list.addItem("British Empire Film");
        list.addItem("Samurai cinema");
        list.addItem("Comedy Thriller");
        list.addItem("Coming-of-age film");
        list.addItem("Political Documetary");
        list.addItem("Supernatural");
        list.addItem("Holiday Film");
        list.addItem("Superhero movie");
        list.addItem("Reboot");
        list.addItem("Political thriller");
        list.addItem("Psycho-biddy");
        list.addItem("Juvenile Delinquency Film");
        list.addItem("Addiction Drama");
        list.addItem("Existentialism");
        list.addItem("Ealing Comedies");
        list.addItem("Sci-Fi Adventure");
        list.addItem("Teen");
        list.addItem("Fantasy Drama");
        list.addItem("Gay Interest");
        list.addItem("Health & Fitness");
        list.addItem("Cold War");
        list.addItem("Chase Movie");
        list.addItem("Early Black Cinema");
        list.addItem("Escape Film");
        list.addItem("Workplace Comedy");
        list.addItem("Boxing");
        list.addItem("Stand-up comedy");
        list.addItem("Operetta");
        list.addItem("Foreign legion");
        list.addItem("Roadshow theatrical release");
        list.addItem("Epic");
        list.addItem("Creature Film");
        list.addItem("Erotic thriller");
        list.addItem("Sponsored film");
        list.addItem("Mondo film");
        list.addItem("Live action");
        list.addItem("Legal drama");
        list.addItem("Tokusatsu");
        list.addItem("Slice of life story");
        list.addItem("Sci Fi Pictures original films");
        list.addItem("Feature film");
        list.addItem("Law & Crime");
        list.addItem("School story");
        list.addItem("Goat gland");
        list.addItem("Business");
        list.addItem("Glamorized Spy Film");
        list.addItem("Musical Drama");
        list.addItem("Family-Oriented Adventure");
        list.addItem("Whodunit");
        list.addItem("Monster");
        list.addItem("Master Criminal Films");
        list.addItem("Sword and sorcery films");
        list.addItem("Mumblecore");
        list.addItem("Singing cowboy");
        list.addItem("Filmed Play");
        list.addItem("Romantic thriller");
        list.addItem("Science fiction Western");
        list.addItem("Road-Horror");
        list.addItem("Social issues");
        list.addItem("Clay animation");
        list.addItem("Gulf War");
        list.addItem("Anthology");
        list.addItem("Superhero");
        list.addItem("Buddy Picture");
        list.addItem("Biker Film");
        list.addItem("Statutory rape");
        list.addItem("Airplanes and airports");
        list.addItem("Journalism");
        list.addItem("Giallo");
        list.addItem("Costume Horror");
        list.addItem("Buddy cop");
        list.addItem("Latino");
        list.addItem("Fairy tale");
        list.addItem("Caper story");
        list.addItem("Race movie");
        list.addItem("Northern");
        list.addItem("Family & Personal Relationships");
        list.addItem("Prison escape");
        list.addItem("Libraries and librarians");
        list.addItem("Dystopia");
        list.addItem("Outlaw biker film");
        list.addItem("Czechoslovak New Wave");
		return list;

        
        
		
	}
	
	public ListBox createYearList(){
		ListBox list = new ListBox();
		list.setVisibleItemCount(10);
		list.setWidth("300");
        list.setMultipleSelect(false);
        
        list.addItem("2015");
        list.addItem("2014");
        list.addItem("2013");
        list.addItem("2012");
        list.addItem("2011");
        list.addItem("2010");
        list.addItem("2009");
        list.addItem("2008");
        list.addItem("2007");
        list.addItem("2006");
        list.addItem("2005");
        list.addItem("2004");
        list.addItem("2003");
        list.addItem("2002");
        list.addItem("2001");
        list.addItem("2000");
        list.addItem("1999");
        list.addItem("1998");
        list.addItem("1997");
        list.addItem("1996");
        list.addItem("1995");
        list.addItem("1994");
        list.addItem("1993");
        list.addItem("1992");
        list.addItem("1991");
        list.addItem("1990");
        list.addItem("1989");
        list.addItem("1988");
        list.addItem("1987");
        list.addItem("1986");
        list.addItem("1985");
        list.addItem("1984");
        list.addItem("1983");
        list.addItem("1982");
        list.addItem("1981");
        list.addItem("1980");
        list.addItem("1979");
        list.addItem("1978");
        list.addItem("1977");
        list.addItem("1976");
        list.addItem("1975");
        list.addItem("1974");
        list.addItem("1973");
        list.addItem("1972");
        list.addItem("1971");
        list.addItem("1970");
        list.addItem("1969");
        list.addItem("1968");
        list.addItem("1967");
        list.addItem("1966");
        list.addItem("1965");
        list.addItem("1964");
        list.addItem("1963");
        list.addItem("1962");
        list.addItem("1961");
        list.addItem("1960");
        list.addItem("1959");
        list.addItem("1958");
        list.addItem("1957");
        list.addItem("1956");
        list.addItem("1955");
        list.addItem("1954");
        list.addItem("1953");
        list.addItem("1952");
        list.addItem("1951");
        list.addItem("1950");
        list.addItem("1949");
        list.addItem("1948");
        list.addItem("1947");
        list.addItem("1946");
        list.addItem("1945");
        list.addItem("1944");
        list.addItem("1943");
        list.addItem("1942");
        list.addItem("1941");
        list.addItem("1940");
        list.addItem("1939");
        list.addItem("1938");
        list.addItem("1937");
        list.addItem("1936");
        list.addItem("1935");
        list.addItem("1934");
        list.addItem("1933");
        list.addItem("1932");
        list.addItem("1931");
        list.addItem("1930");
        list.addItem("1929");
        list.addItem("1928");
        list.addItem("1927");
        list.addItem("1926");
        list.addItem("1925");
        list.addItem("1924");
        list.addItem("1923");
        list.addItem("1922");
        list.addItem("1921");
        list.addItem("1920");
        list.addItem("1919");
        list.addItem("1918");
        list.addItem("1917");
        list.addItem("1916");
        list.addItem("1915");
        list.addItem("1914");
        list.addItem("1913");
        list.addItem("1912");
        list.addItem("1911");
        list.addItem("1910");
        list.addItem("1909");
        list.addItem("1908");
        list.addItem("1907");
        list.addItem("1906");
        list.addItem("1905");
        list.addItem("1904");
        list.addItem("1903");
        list.addItem("1902");
        list.addItem("1901");
        list.addItem("1900");
        list.addItem("1899");
        list.addItem("1898");
        list.addItem("1897");
        list.addItem("1896");
        list.addItem("1895");
        list.addItem("1894");
        list.addItem("1893");
        list.addItem("1892");
        list.addItem("1891");
        list.addItem("1890");
        list.addItem("1889");
        list.addItem("1888");
        
        
        
		return list;
		
		
	}
	
	public ListBox createLanguages(){
		ListBox list = new ListBox();
		list.setVisibleItemCount(5);
        list.setMultipleSelect(false);
        
        list.addItem("English");
		list.addItem("Norwegian");
		list.addItem("German");
		list.addItem("Silentfilm");
		list.addItem("Spanish");
		list.addItem("Japanese");
		list.addItem("Turkish");
		list.addItem("Russian");
		list.addItem("Italian");
		list.addItem("Tamil");
		list.addItem("Hindi");
		list.addItem("Malayalam");
		list.addItem("StandardMandarin");
		list.addItem("Afrikaans");
		list.addItem("Cantonese");
		list.addItem("Danish");
		list.addItem("Portuguese");
		list.addItem("Dutch");
		list.addItem("Polish");
		list.addItem("Korean");
		list.addItem("Hungary");
		list.addItem("Telugu");
		list.addItem("French");
		list.addItem("Punjabi");
		list.addItem("Romani");
		list.addItem("Greek");
		list.addItem("Nepali");
		list.addItem("Swahili");
		list.addItem("Finnish");
		list.addItem("Tagalog");
		list.addItem("Swedish");
		list.addItem("Romanian");
		list.addItem("Bengali");
		list.addItem("Czech");
		list.addItem("Arabic");
		list.addItem("Chinese");
		list.addItem("Kannada");
		list.addItem("Irish");
		list.addItem("Hebrew");
		list.addItem("Indonesian");
		list.addItem("Serbian");
		list.addItem("Georgian");
		list.addItem("Croatian");
		list.addItem("Italian");
		list.addItem("Hungarian");
		list.addItem("Bosnian");
		list.addItem("Malay");
		list.addItem("Uzbek");
		list.addItem("Yiddish");
		list.addItem("Kurdish");
		list.addItem("Persian");
		list.addItem("MandarinChinese");
		list.addItem("Tibetans");
		list.addItem("Urdu");
		list.addItem("StandardCantonese");
		list.addItem("Albanian");
		list.addItem("Khmer");
		list.addItem("Oriya");
		list.addItem("Marathi");
		list.addItem("Filipino");
		list.addItem("Saami");
		list.addItem("Thai");
		list.addItem("AmericanSign");
		list.addItem("FrenchSign");
		list.addItem("Vietnamese");
		list.addItem("Icelandic");
		list.addItem("Xhosa");
		list.addItem("Welsh");
		list.addItem("Serbo-Croatian");
		list.addItem("Sinhala");
		list.addItem("Rajasthani");
		list.addItem("Catalan");
		list.addItem("Slovenian");
		list.addItem("Bulgarian");
		list.addItem("Ukrainian");
		list.addItem("Assamese");
		list.addItem("Taiwanese");
		list.addItem("Algonquin");
		list.addItem("Macedonian");
		list.addItem("Esperanto");
		list.addItem("Latin");
		list.addItem("SouthAfricanEnglish");
		list.addItem("Bambara");
		list.addItem("Estonian");
		list.addItem("Armenian");
		list.addItem("Quechua");
		list.addItem("Khmer");
		list.addItem("AmericanEnglish");
		list.addItem("StandardTibetan");
		list.addItem("Farsi");
		list.addItem("Sotho");
		list.addItem("Aceh");
		list.addItem("Pashto");
		list.addItem("AboriginalMalays");
		list.addItem("ScottishGaelic");
		list.addItem("Bhojpuri");
		list.addItem("BrazilianPortuguese");
		list.addItem("Mongolian");
		list.addItem("OldEnglish");
		list.addItem("Burmese");
		list.addItem("Thai");
		list.addItem("Chechen");
		list.addItem("Inuktitut");
		list.addItem("Plautdietsch");
		list.addItem("Apache");
		list.addItem("German");
		list.addItem("Egyptian");
		list.addItem("SwissGerman");
		list.addItem("Azerbaijani");
		list.addItem("Lithuanian");
		list.addItem("Aramaic");
		list.addItem("Sunda");
		list.addItem("Amharic");
		list.addItem("Gaelic");
		list.addItem("Sioux");
		list.addItem("MinNan");
		list.addItem("Zulu");
		list.addItem("Slovak");
		list.addItem("Hopi");
		list.addItem("Shanxi");
		list.addItem("Japan");
		list.addItem("JamaicanCreoleEnglish");
		list.addItem("Kinyarwanda");
		list.addItem("Friulian");
		list.addItem("Dzongkha");
		list.addItem("Dari");
		list.addItem("Sanskrit");
		list.addItem("Gujarati");
		list.addItem("Mende");
		list.addItem("Flemish");
		list.addItem("France");
		list.addItem("Gumatj");
		list.addItem("Shanghainese");
		list.addItem("Galician");
		list.addItem("TokPisin");
		list.addItem("Maya");
		list.addItem("Crow");
		list.addItem("Somali");
		list.addItem("Judeo-Georgian");
		list.addItem("EgyptianArabic");
		list.addItem("Chinese");
		list.addItem("Luxembourgish");
		list.addItem("Sumerian");
		list.addItem("Banyumasan");
		list.addItem("Navajo");
		list.addItem("Frisian");
		list.addItem("Venetian");
		list.addItem("Wolof");
		list.addItem("AustralianEnglish");
		list.addItem("Hokkien");
		list.addItem("Hariyani");
		list.addItem("Cree");
		list.addItem("Maasai");
		list.addItem("KoreanSign");
		list.addItem("AustralianAboriginalPidginEnglish");
		list.addItem("Napoletano-Calabrese");
		list.addItem("Hiligaynon");
		list.addItem("Tzotzil");
		list.addItem("Tulu");
		list.addItem("Belarusian");
		list.addItem("GuanzhongHua");
		list.addItem("Palawakani");
		list.addItem("Klingon");
		list.addItem("Akan");
		list.addItem("YolnguMatha");
		list.addItem("Hmong");
		list.addItem("Osetin");
		list.addItem("Deutsch");
		list.addItem("Nahuatls");
		list.addItem("Hazaragi");
		list.addItem("Cebuano");
		list.addItem("Hainanese");
		list.addItem("Assyrian");
		list.addItem("Samis");
		list.addItem("Corsican");
		list.addItem("Hausa");
		list.addItem("Hinglish");
		list.addItem("Picard");
		list.addItem("Pawnee");
		list.addItem("AssyrianNeo-Aramaic");
		list.addItem("Cheyenne");
		list.addItem("Tamang");
		list.addItem("Hawaiian");
		list.addItem("Kriolu");
		list.addItem("Sicilian");
		list.addItem("Hindustani");
		list.addItem("IndianEnglish");
		list.addItem("Teochew");
		list.addItem("Scanian");
		list.addItem("Mohawk");
		list.addItem("Haryanvi");
		list.addItem("ClassicalArabic");
		list.addItem("Fulfulde");
		list.addItem("ChadianArabic");
		return list;

	}
	
	public FormPanel createLength(){
		 FormPanel form = new FormPanel();  
	        form.setBorder(false);  
	        form.setFrame(false);  
	  
	        FieldSet fieldSet = new FieldSet("Sort Direction");  
	        fieldSet.setFrame(false);  
	  
	        
	        final Radio shortM = new Radio();  
	        shortM.setName("direction");  
	        shortM.setBoxLabel("<90 min");  
	        shortM.setChecked(true);  
	        fieldSet.add(shortM); 
	        
	        final Radio mediumM = new Radio();  
	        mediumM.setName("direction");  
	        mediumM.setBoxLabel("90-120 min");  
	        mediumM.setChecked(true);  
	        fieldSet.add(mediumM);  
	  
	        final Radio longM = new Radio();  
	        longM.setName("direction");  
	        longM.setBoxLabel("120-160min");  
	        longM.setChecked(false);  
	        fieldSet.add(longM);  
	        
	        final Radio ultralongM = new Radio();  
	        ultralongM.setName("direction");  
	        ultralongM.setBoxLabel(">160");  
	        ultralongM.setChecked(false);  
	        fieldSet.add(ultralongM);  
	        
	        
	  
	        form.add(fieldSet);
			return form;  

	}
	
	public String[][] getFilteredArrayBack(){
		return filteredMoviesArrays;
	}
	
	private static String[][] getStates() {  
		
	        return new String[][]{  
	        	new String[]{"US", "United States of America"},  
	        	new String[]{"NO", "Norway"},  
	        	new String[]{"GB", "United Kingdom"},  
	        	new String[]{"DE", "Germany"},  
	        	new String[]{"ZA", "South Africa"},  
	        	new String[]{"AR", "Argentina"},  
	        	new String[]{"JP", "Japan"},  
	        	new String[]{"TR", "Turkey"},  
	        	new String[]{"DE", "German Democratic Republic"},  
	        	new String[]{"RU", "Soviet Union"},  
	        	new String[]{"FR", "France"},  
	        	new String[]{"IN", "India"},  
	        	new String[]{"NZ", "New Zealand"},  
	        	new String[]{"MX", "Mexico"},  
	        	new String[]{"AU", "Australia"},  
	        	new String[]{"HK", "Hong Kong"},  
	        	new String[]{"IT", "Italy"},  
	        	new String[]{"DK", "Denmark"},  
	        	new String[]{"CA", "Canada"},  
	        	new String[]{"BR", "Brazil"},  
	        	new String[]{"NL", "Netherlands"},  
	        	new String[]{"PL", "Poland"},  
	        	new String[]{"ES", "Spain"},  
	        	new String[]{"KP", "South Korea"},  
	        	new String[]{"HU", "Hungary"},  
	        	new String[]{"DE", "West Germany"},  
	        	new String[]{"PK", "Pakistan"},  
	        	new String[]{"NP", "Nepal"},  
	        	new String[]{"FI", "Finland"},  
	        	new String[]{"IE", "Ireland"},  
	        	new String[]{"CN", "China"},  
	        	new String[]{"AT", "Austria"},  
	        	new String[]{"PH", "Philippines"},  
	        	new String[]{"RO", "Romania"},  
	        	new String[]{"SK", "Slovakia"},  
	        	new String[]{"SE", "Sweden"},  
	        	new String[]{"EG", "Egypt"},  
	        	new String[]{"CZ", "Czechoslovakia"},  
	        	new String[]{"IE", "Northern Ireland"},  
	        	new String[]{"IS", "Iceland"},  
	        	new String[]{"ID", "Indonesia"},  
	        	new String[]{"GR", "Greece"},  
	        	new String[]{"MK", "Republic of Macedonia"},  
	        	new String[]{"MK", "Yugoslavia"},  
	        	new String[]{"PT", "Portugal"},  
	        	new String[]{"GB", "England"},  
	        	new String[]{"BA", "Bosnia and Herzegovina"},  
	        	new String[]{"BE", "Belgium"},  
	        	new String[]{"HR", "Croatia"},  
	        	new String[]{"IL", "Israel"},  
	        	new String[]{"MY", "Malaysia"},  
	        	new String[]{"CZ", "Czech Republic"},  
	        	new String[]{"UZ", "Uzbekistan"},  // was here
	        	new String[]{"CH", "Switzerland"},  
	        	new String[]{"RU", "Russia"},  
	        	new String[]{"DE", "Nazi Germany"},  
	        	new String[]{"DE", "Weimar Republic"},  
	        	new String[]{"IR", "Iran"},  
	        	new String[]{"PR", "Puerto Rico"},  
	        	new String[]{"AL", "Albania"},  
	        	new String[]{"KH", "Cambodia"},  
	        	new String[]{"TH", "Thailand"},  
	        	new String[]{"TW", "Taiwan"},  
	        	new String[]{"EE", "Estonia"},  
	        	new String[]{"GB", "Scotland"},  
	        	new String[]{"VE", "Venezuela"},  
	        	new String[]{"VN", "Vietnam"},  
	        	new String[]{"LK", "Sri Lanka"},  
	        	new String[]{"SG", "Singapore"},  
	        	new String[]{"BD", "Bangladesh"},  
	        	new String[]{"CO", "Colombia"},  
	        	new String[]{"SN", "Senegal"},  
	        	new String[]{"RS", "Serbia"},  
	        	new String[]{"SI", "Slovenia"},  
	        	new String[]{"BG", "Bulgaria"},  
	        	new String[]{"UA", "Ukraine"},  
	        	new String[]{"SK", "Slovak Republic"},  
	        	new String[]{"AZ", "Azerbaijan"},  
	        	new String[]{"CU", "Cuba"},  
	        	new String[]{"MT", "Malta"},  
	        	new String[]{"BO", "Bolivia"},  
	        	new String[]{"UY", "Uruguay"},  
	        	new String[]{"CL", "Chile"},  
	        	new String[]{"PE", "Peru"},  
	        	new String[]{"KE", "Kenya"},  
	        	new String[]{"BF", "Burma"},  
	        	new String[]{"GB", "Kingdom of Great Britain"},  
	        	new String[]{"BF", "Burkina Faso"},  
	        	new String[]{"GE", "Georgia"},  
	        	new String[]{"RS", "Serbia and Montenegro"},  
	        	new String[]{"IM", "Isle of Man"},  
	        	new String[]{"KR", "Korea"},  
	        	new String[]{"CR", "Costa Rica"},  
	        	new String[]{"MA", "Morocco"},  
	        	new String[]{"DZ", "Algeria"},  
	        	new String[]{"GE", "Georgian SSR"},  
	        	new String[]{"TN", "Tunisia"},  
	        	new String[]{"LB", "Lebanon"},  
	        	new String[]{"ZW", "Zimbabwe"},  
	        	new String[]{"JO", "Jordan"},  
	        	new String[]{"LT", "Lithuania"},  
	        	new String[]{"CD", "Democratic Republic of the Congo"},  
	        	new String[]{"MN", "Mongolia"},  
	        	new String[]{"LU", "Luxembourg"},  
	        	new String[]{"AM", "Armenia"},  
	        	new String[]{"AE", "United Arab Emirates"},  
	        	new String[]{"JM", "Jamaica"},  
	        	new String[]{"UA", "Ukrainian SSR"},  
	        	new String[]{"GB", "Wales"},  
	        	new String[]{"NG", "Nigeria"},  
	        	new String[]{"AF", "Afghanistan"},  
	        	new String[]{"UZ", "Uzbek SSR"},  
	        	new String[]{"BT", "Bhutan"},  
	        	new String[]{"ET", "Ethiopia"},  
	        	new String[]{"RS", "Federal Republic of Yugoslavia"},  
	        	new String[]{"BS", "Bahamas"},  
	        	new String[]{"RS", "Socialist Federal Republic of Yugoslavia"},  
	        	new String[]{"IQ", "Iraq"},  
	        	new String[]{"TM", "Turkmenistan"},  
	        	new String[]{"BH", "Bahrain"},  
	        	new String[]{"KW", "Kuwait"},  
	        	new String[]{"ML", "Mali"},  
	        	new String[]{"GW", "Guinea-Bissau"},  
	        	new String[]{"CM", "Cameroon"},  
	        	new String[]{"HT", "Haiti"},  
	        	new String[]{"ZM", "Zambia"},  
	        	new String[]{"PS", "Palestinian territories"},  
	        	new String[]{"MY", "Malayalam Language"},  
	        	new String[]{"PS", "Mandatory Palestine"},  
	        	new String[]{"QA", "Qatar"},  
	        	new String[]{"CY", "Cyprus"},  
	        	new String[]{"LY", "Libya"},  
	        	new String[]{"UA", "Ukranian SSR"},  
	        	new String[]{"RU", "Soviet occupation zone"},  
	        	new String[]{"PA", "Panama"},  
	        	new String[]{"IT", "Kingdom of Italy"},  
	        	new String[]{"MC", "Monaco"},  
	        	new String[]{"GN", "Guinea"},  
	        	new String[]{"IQ", "Iraqi Kurdistan"},  
	        	new String[]{"AW", "Aruba"},  
	        	new String[]{"CG", "Congo"},  
	        	new String[]{"ME", "Montenegro"},  
	        	new String[]{"CN", "Republic of China"},  
	        	new String[]{"MO", "Macau"},  
	        	new String[]{"DE", "German Language"},  
  
	        };  
	    }  


	public void arrayListtoArrayConverter(ArrayList<String[]> filteredArrayList ){
		
		String [][] convertedArray = new String[filteredArrayList.size()-1][9];
		for (int i=0; i<filteredArrayList.size();i++){
			for (int k=0; k<9;k++){
				
				convertedArray[i][k] = filteredArrayList.get(i)[k];
			}
		}
		filteredMoviesArrays = convertedArray;
			
		
	}
	
	public String getTestData() {
		return getTextString;
		
		// TODO Auto-generated method stub

	}
	public FormPanel createSearchPanel() {
		Panel searchPanel = new Panel();  
		searchPanel.setBorder(false);  
		searchPanel.setPaddings(15); 
        searchPanel.setTitle("Search for a Movie");  
		searchPanel.setHeight(400);  
		searchPanel.setLayout(new AccordionLayout(true)); 
		
		final ComboBox searchfield = new ComboBox(); 
		searchfield.setFieldLabel("Search"); 
		searchfield.setMinChars(1);  
		searchfield.setFieldLabel("Search");  
		searchfield.setDisplayField("Search");  
		searchfield.setMode(ComboBox.LOCAL);  
		searchfield.setEmptyText("Search Movie");  
		searchfield.setLoadingText("Searching...");  
		searchfield.setTypeAhead(true);  
        searchfield.setSelectOnFocus(true);  
        searchfield.setWidth(150);  
        //do not show drop fown icon  
        searchfield.setHideTrigger(true);  
  
 
        baddtoFilter.addClickHandler(new ClickHandler() {
	        public void onClick (ClickEvent event) {
	            filterConditionArray[5]= searchfield.getText();
	        	
	        }	
	    });

        
        searchPanel.add(searchfield);
        searchPanel.add(baddtoFilter);
        
        FormPanel form = new FormPanel();  
        form.setLabelWidth(35);  
        form.setBorder(false);  
        
        form.add(searchPanel);
        
		return form;
	}
	
public FormPanel createSearchs(){
		
        FormPanel form = new FormPanel();  
        form.setLabelWidth(35);  
        form.setBorder(false);         
        
       final ComboBox searchMovie = new ComboBox();
       searchMovie.setWidth(120);
       searchMovie.setHideTrigger(false);  
       searchMovie.setEmptyText("Movie Name");
       searchMovie.setFieldLabel("1. ");  
       form.add(searchMovie);  
       
       final ComboBox searchLang = new ComboBox();
       searchLang.setWidth(120);
       searchLang.setEmptyText("Language");
       searchMovie.setFieldLabel("2. ");  
       form.add(searchLang); 
       
       final ComboBox searchYear = new ComboBox();
       searchYear.setWidth(120);
       searchYear.setEmptyText("Year");
       searchMovie.setFieldLabel("3. ");  
       form.add(searchYear); 
       
       final ComboBox searchCountry = new ComboBox();
       searchCountry.setWidth(120);
       searchCountry.setEmptyText("Country");
       searchMovie.setFieldLabel("4. ");  
       form.add(searchCountry); 
       
       final ComboBox searchGenre = new ComboBox();
       searchGenre.setWidth(120);
       searchGenre.setEmptyText("Genre");
       searchMovie.setFieldLabel("5. ");  
       form.add(searchGenre); 
       
       final ComboBox searchlength= new ComboBox();
       searchlength.setWidth(120);
       searchlength.setEmptyText("Movielength");
       searchMovie.setFieldLabel("6. ");  
       form.add(searchlength); 
       
       final Label muti = new Label();
        form.add(muti);
        
        
        bresetSearchFilter.addClickHandler(new ClickHandler() {        	
	        public void onClick (ClickEvent event) {
	        	
	        	searchMovie.clearValue();
	        	searchLang.clearValue();
	        	searchYear.clearValue();
	        	searchCountry.clearValue();
	        	searchGenre.clearValue();
	        	searchlength.clearValue();
	        	
	        	filterConditionArray[0]= "";
	        	filterConditionArray[1]= "";
	        	filterConditionArray[2]= "";
	        	filterConditionArray[3]= "";
	        	filterConditionArray[4]= "";
	            filterConditionArray[5]= "";
	        	muti.setText(searchMovie.getText() + ", " + searchLang.getText() + ", " + searchGenre.getText() + ", " + searchlength.getText() + ", " + searchCountry.getText());
	        	
	        
	        
	        }	
	    });
        
        baddtoFilter.addClickHandler(new ClickHandler() {
	        public void onClick (ClickEvent event) {
	        	filterConditionArray[0]= searchYear.getText();
	        	filterConditionArray[1]= searchLang.getText();
	        	filterConditionArray[2]= searchGenre.getText();
	        	filterConditionArray[3]= searchlength.getText();
	        	filterConditionArray[4]= searchCountry.getText();
	            filterConditionArray[5]= searchMovie.getText();
	        	muti.setText(searchMovie.getText() + ", " + searchLang.getText() + ", " + searchGenre.getText() + ", " + searchlength.getText() + ", " + searchCountry.getText());
	        	
	        
	        
	        }	
	    });
        
        		
        
        form.add(baddtoFilter);
        form.add(bresetSearchFilter);

        
		return form;
	}
	
}