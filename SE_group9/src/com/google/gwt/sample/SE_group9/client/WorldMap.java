package com.google.gwt.sample.SE_group9.client;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwt.charts.client.ChartLoader;
import com.googlecode.gwt.charts.client.ChartPackage;
import com.googlecode.gwt.charts.client.ChartType;
import com.googlecode.gwt.charts.client.ChartWrapper;
import com.googlecode.gwt.charts.client.ColumnType;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.controls.Dashboard;
import com.googlecode.gwt.charts.client.controls.filter.ChartRangeFilter;
import com.googlecode.gwt.charts.client.controls.filter.ChartRangeFilterOptions;
import com.googlecode.gwt.charts.client.controls.filter.NumberRangeFilter;
import com.googlecode.gwt.charts.client.controls.filter.NumberRangeFilterOptions;
import com.googlecode.gwt.charts.client.corechart.AreaChart;
import com.googlecode.gwt.charts.client.corechart.AreaChartOptions;
import com.googlecode.gwt.charts.client.geochart.GeoChart;
import com.googlecode.gwt.charts.client.geochart.GeoChartColorAxis;
import com.googlecode.gwt.charts.client.geochart.GeoChartOptions;
import com.googlecode.gwt.charts.client.table.TableOptions;
import com.gwtext.client.widgets.Panel;
public class WorldMap {
	public DataTable dataTable;
	public Panel mapPanel = new Panel ();
	private GeoChart geoChart;
	GeoChartOptions goptions;
	Label lb = new Label("top");
	Label lb2 = new Label("top");
	public VerticalPanel dlp = new VerticalPanel();
	String [][] twoDArray;
	int numberOfRows;
	

	public void initialize() {
		ChartLoader chartLoader = new ChartLoader(ChartPackage.GEOCHART);
		chartLoader.loadApi(new Runnable() {

			@Override
			public void run() {
				// Create and attach the chart
				geoChart = new GeoChart();
				
				draw2();
			}
		});
	}
    //current method to draw geomap
	public void draw(int year, final List<String> arrayCountry) {

	int uscount = 0;
	int NOcount = 0;
	int GBcount = 0;
	int DEcount = 0;
	int ZAcount = 0;
	int ARcount = 0;
	int JPcount = 0;
	int TRcount = 0;
	int RUcount = 0;
	int FRcount = 0;
	int INcount = 0;
	int NZcount = 0;
	
	int MXcount = 0;
	int AUcount = 0;
	int HKcount = 0;
	int ITcount = 0;
	int DKcount = 0;
	int CAcount = 0;
	int BRcount = 0;
	int NLcount = 0;
	int PLcount = 0;
	int EScount = 0;
	int KPcount = 0;
	int HUcount = 0;
	
	int PKcount = 0;
	int NPcount = 0;
	int FIcount = 0;
	int IEcount = 0;
	int CNcount = 0;
	int ATcount = 0;
	int PHcount = 0;
	int ROcount = 0;
	int SKcount = 0;
	int SEcount = 0;
	int EGcount = 0;
	int CZcount = 0;
	
	int IScount = 0;
	int IDcount = 0;
	int GRcount = 0;
	int MKcount = 0;
	int PTcount = 0;
	int BAcount = 0;
	int BEcount = 0;
	int HRcount = 0;
	int ILcount = 0;
	int MYcount = 0;
	int UZcount = 0;
		
	int CHcount = 0;
	int IRcount = 0;
	int PRcount = 0;
	int ALcount = 0;
	int KHcount = 0;
	int THcount = 0;
	int TWcount = 0;
	int EEcount = 0;
	int VEcount = 0;
	int VNcount = 0;
	int LKcount = 0;

	int SGcount = 0;
	int BDcount = 0;
	int COcount = 0;
	int SNcount = 0;
	int RScount = 0;
	int SIcount = 0;
	int BGcount = 0;
	int UAcount = 0;
	int MTcount = 0;
	int AZcount = 0;
	int CUcount = 0;
	
	int BOcount = 0;

	int CLcount = 0;
	int PEcount = 0;
	int KEcount = 0;
	int BFcount = 0;
	int IMcount = 0;
	int KRcount = 0;
	int CRcount = 0;
	int MAcount = 0;
	int GZcount = 0;
	
	int GEcount = 0;
	int TNcount = 0;
	int LBcount = 0;
	int ZWcount = 0;
	int JOcount = 0;
	int LTcount = 0;
	int CDcount = 0;
	int MNcount = 0;
	int LUcount = 0;
	int AMcount = 0;
	int AEcount = 0;
	
	int JMcount = 0;
	int NGcount = 0;
	int AFcount = 0;
	int ETcount = 0;
	int BZcount = 0;
	int BScount = 0;
	int IQcount = 0;
	int TMcount = 0;
	int BHcount = 0;
	int KWcount = 0;
	int MLcount = 0;
	
	int GWcount = 0;
	int CMcount = 0;
	int HTcount = 0;
	int ZMcount = 0;
	int PScount = 0;
	int QAcount = 0;
	int CYcount = 0;
	int LYcount = 0;
	int UAount = 0;
	int PAcount = 0;
	int MCcount = 0;
	
	int GNcount = 0;
	int AWcount = 0;
	int CGcount = 0;
	int MEcount = 0;
	int MOcount = 0;
	int UYcount = 0;
	int DZcount = 0;
	int BTcount = 0;

		for(int i =  0; i< arrayCountry.size();i++){
			if(arrayCountry.get(i).contains("United States")){
				uscount++;
			}
			if(arrayCountry.get(i).contains("Norway")){
				NOcount++;
			}
			if(arrayCountry.get(i).contains("United Kingdom")){
				GBcount++;
			}
			if(arrayCountry.get(i).contains("England")){
				GBcount++;
			}
			if(arrayCountry.get(i).contains("German")){
				DEcount++;
			}
			if(arrayCountry.get(i).contains("South Africa")){
				ZAcount++;
			}
			if(arrayCountry.get(i).contains("Argentina")){
				ARcount++;
			}
			if(arrayCountry.get(i).contains("Japan")){
				JPcount++;
			}
			if(arrayCountry.get(i).contains("Turkey")){
				TRcount++;
			}
			if(arrayCountry.get(i).contains("Soviet Union")){
				RUcount++;
			}
			if(arrayCountry.get(i).contains("France")){
				FRcount++;
			}
			if(arrayCountry.get(i).contains("India")){
				INcount++;
			}
			if(arrayCountry.get(i).contains("New Zealand")){
				NZcount++;
			}


			if(arrayCountry.get(i).contains("Mexico")){
				MXcount++;
			}
			if(arrayCountry.get(i).contains("Australia")){
				AUcount++;
			}
			if(arrayCountry.get(i).contains("Hong Kong")){
				HKcount++;
			}
			if(arrayCountry.get(i).contains("Italy")){
				ITcount++;
			}
			if(arrayCountry.get(i).contains("Denmark")){
				DKcount++;
			}
			if(arrayCountry.get(i).contains("Canada")){
				CAcount++;
			}
			if(arrayCountry.get(i).contains("Brazil")){
				BRcount++;
			}
			if(arrayCountry.get(i).contains("Netherlands")){
				NLcount++;
			}
			if(arrayCountry.get(i).contains("Poland")){
				PLcount++;
			}
			if(arrayCountry.get(i).contains("Spain")){
				EScount++;
			}
			if(arrayCountry.get(i).contains("South Korea")){
				KPcount++;
			}
			if(arrayCountry.get(i).contains("Hungary")){
				HUcount++;
			}
			if(arrayCountry.get(i).contains("Russia")){
				RUcount++;
			}
			
			
			if(arrayCountry.get(i).contains("Pakistan")){
				PKcount++;
			}
			if(arrayCountry.get(i).contains("Nepal")){
				NPcount++;
			}
			if(arrayCountry.get(i).contains("Finland")){
				FIcount++;
			}
			if(arrayCountry.get(i).contains("Ireland")){
				IEcount++;
			}
			if(arrayCountry.get(i).contains("China")){
				CNcount++;
			}
			if(arrayCountry.get(i).contains("Austria")){
				ATcount++;
			}
			if(arrayCountry.get(i).contains("Philippines")){
				PHcount++;
			}
			if(arrayCountry.get(i).contains("Romania")){
				ROcount++;
			}
			if(arrayCountry.get(i).contains("Slovakia")){
				SKcount++;
			}
			if(arrayCountry.get(i).contains("Sweden")){
				SEcount++;
			}
			if(arrayCountry.get(i).contains("Egypt")){
				EGcount++;
			}
			if(arrayCountry.get(i).contains("Czechoslovakia")){
				CZcount++;
			}
			
			
			if(arrayCountry.get(i).contains("Iceland")){
				IScount++;
			}
			if(arrayCountry.get(i).contains("Indonesia")){
				IDcount++;
			}
			if(arrayCountry.get(i).contains("Greece")){
				GRcount++;
			}
			if(arrayCountry.get(i).contains("Republic of Macedonia")){
				MKcount++;
			}
			if(arrayCountry.get(i).contains("Yugoslavia")){
				MKcount++;
			}
			if(arrayCountry.get(i).contains("Portugal")){
				PTcount++;
			}
			if(arrayCountry.get(i).contains("Bosnia and Herzegovina")){
				BAcount++;
			}
			if(arrayCountry.get(i).contains("Belgium")){
				BEcount++;
			}
			if(arrayCountry.get(i).contains("Croatia")){
				HRcount++;
			}
			if(arrayCountry.get(i).contains("Israel")){
				ILcount++;
			}
			if(arrayCountry.get(i).contains("Malaysia")){
				MYcount++;
			}
			if(arrayCountry.get(i).contains("Czech Republic")){
				CZcount++;
			}
			if(arrayCountry.get(i).contains("Uzbekistan")){
				UZcount++;
			}
			
			
			
			if(arrayCountry.get(i).contains("Uzbekistan")){
				UZcount++;
			}
			if(arrayCountry.get(i).contains("Switzerland")){
				CHcount++;
			}
			if(arrayCountry.get(i).contains("Nazi Germany")){
				DEcount++;
			}
			if(arrayCountry.get(i).contains("Weimar Republic")){
				DEcount++;
			}
			if(arrayCountry.get(i).contains("Iran")){
				IRcount++;
			}
			if(arrayCountry.get(i).contains("Puerto Rico")){
				PRcount++;
			}
			if(arrayCountry.get(i).contains("Albania")){
				ALcount++;
			}
			if(arrayCountry.get(i).contains("Cambodia")){
				KHcount++;
			}
			if(arrayCountry.get(i).contains("Thailand")){
				THcount++;
			}
			if(arrayCountry.get(i).contains("Taiwan")){
				TWcount++;
			}
			if(arrayCountry.get(i).contains("Estonia")){
				EEcount++;
			}
			if(arrayCountry.get(i).contains("Scotland")){
				GBcount++;
			}
			if(arrayCountry.get(i).contains("Venezuela")){
				VEcount++;
			}
			
			
			
			if(arrayCountry.get(i).contains("Vietnam")){
				VNcount++;
			}
			if(arrayCountry.get(i).contains("Sri Lanka")){
				LKcount++;
			}
			if(arrayCountry.get(i).contains("Singapore")){
				SGcount++;
			}
			if(arrayCountry.get(i).contains("Bangladesh")){
				BDcount++;
			}
			if(arrayCountry.get(i).contains("Colombia")){
				COcount++;
			}
			if(arrayCountry.get(i).contains("Senegal")){
				SNcount++;
			}
			if(arrayCountry.get(i).contains("Serbia")){
				RScount++;
			}
			if(arrayCountry.get(i).contains("Slovenia")){
				SIcount++;
			}
			if(arrayCountry.get(i).contains("Bulgaria")){
				BGcount++;
			}
			if(arrayCountry.get(i).contains("Ukraine")){
				UAcount++;
			}
			if(arrayCountry.get(i).contains("Slovak Republic")){
				SKcount++;
			}
			if(arrayCountry.get(i).contains("Azerbaijan")){
				AZcount++;
			}
			if(arrayCountry.get(i).contains("Cuba")){
				CUcount++;
			}
			
			
			
			if(arrayCountry.get(i).contains("Malta")){
				MTcount++;
			}
			if(arrayCountry.get(i).contains("Bolivia")){
				BOcount++;
			}
			if(arrayCountry.get(i).contains("Uruguay")){
				UYcount++;
			}
			if(arrayCountry.get(i).contains("Chile")){
				CLcount++;
			}
			if(arrayCountry.get(i).contains("Peru")){
				PEcount++;
			}
			if(arrayCountry.get(i).contains("Kenya")){
				KEcount++;
			}
			if(arrayCountry.get(i).contains("Burma")){
				BFcount++;
			}
			if(arrayCountry.get(i).contains("Burkina Faso")){
				BFcount++;
			}
			if(arrayCountry.get(i).contains("Georgia")){
				GEcount++;
			}
			if(arrayCountry.get(i).contains("Isle of Man")){
				IMcount++;
			}
			if(arrayCountry.get(i).contains("Korea")){
				KRcount++;
			}
			if(arrayCountry.get(i).contains("Costa Rica")){
				CRcount++;
			}
			if(arrayCountry.get(i).contains("Morocco")){
				MAcount++;
			}
			
			
			
			if(arrayCountry.get(i).contains("Algeria")){
				DZcount++;
			}
			if(arrayCountry.get(i).contains("Tunisia")){
				TNcount++;
			}
			if(arrayCountry.get(i).contains("Lebanon")){
				LBcount++;
			}
			if(arrayCountry.get(i).contains("Zimbabwe")){
				ZWcount++;
			}
			if(arrayCountry.get(i).contains("Jordan")){
				JOcount++;
			}
			if(arrayCountry.get(i).contains("Lithuania")){
				LTcount++;
			}
			if(arrayCountry.get(i).contains("Congo")){
				CDcount++;
			}
			if(arrayCountry.get(i).contains("Mongolia")){
				MNcount++;
			}
			if(arrayCountry.get(i).contains("Luxembourg")){
				LUcount++;
			}
			if(arrayCountry.get(i).contains("Armenia")){
				AMcount++;
			}
			if(arrayCountry.get(i).contains("United Arab Emirates")){
				AEcount++;
			}
			if(arrayCountry.get(i).contains("Jamaica")){
				JMcount++;
			}
			if(arrayCountry.get(i).contains("Ukrainian SSR")){
				UAcount++;
			}
			
			
			
			if(arrayCountry.get(i).contains("Wales")){
				GBcount++;
			}
			if(arrayCountry.get(i).contains("Nigeria")){
				NGcount++;
			}
			if(arrayCountry.get(i).contains("Afghanistan")){
				AFcount++;
			}
			if(arrayCountry.get(i).contains("Bhutan")){
				BTcount++;
			}
			if(arrayCountry.get(i).contains("Ethiopia")){
				ETcount++;
			}
			if(arrayCountry.get(i).contains("Bahamas")){
				BScount++;
			}
			if(arrayCountry.get(i).contains("Iraq")){
				IQcount++;
			}
			if(arrayCountry.get(i).contains("Turkmenistan")){
				TMcount++;
			}
			if(arrayCountry.get(i).contains("Bahrain")){
				BHcount++;
			}
			if(arrayCountry.get(i).contains("Kuwait")){
				KWcount++;
			}
			if(arrayCountry.get(i).contains("Mali")){
				MLcount++;
			}
			if(arrayCountry.get(i).contains("Guinea-Bissau")){
				GWcount++;
			}
			if(arrayCountry.get(i).contains("Cameroon")){
				CMcount++;
			}
			
			
			
			if(arrayCountry.get(i).contains("Haiti")){
				HTcount++;
			}
			if(arrayCountry.get(i).contains("Zambia")){
				ZMcount++;
			}
			if(arrayCountry.get(i).contains("Palestin")){
				PScount++;
			}
			if(arrayCountry.get(i).contains("Qatar")){
				QAcount++;
			}
			if(arrayCountry.get(i).contains("Cyprus")){
				CYcount++;
			}
			if(arrayCountry.get(i).contains("Libya")){
				LYcount++;
			}
			if(arrayCountry.get(i).contains("Panama")){
				PAcount++;
			}
			if(arrayCountry.get(i).contains("Monaco")){
				MCcount++;
			}
			if(arrayCountry.get(i).contains("Guinea")){
				GNcount++;
			}
			if(arrayCountry.get(i).contains("Aruba")){
				AWcount++;
			}
			if(arrayCountry.get(i).contains("Congo")){
				CGcount++;
			}
			if(arrayCountry.get(i).contains("Montenegro")){
				MEcount++;
			}
			if(arrayCountry.get(i).contains("Macau")){
				MOcount++;
			}
		}
		
	
		geoChart.clearChart();
		// Prepare the data
		DataTable dataTable = DataTable.create();
		dataTable.addColumn(ColumnType.STRING, "Coutry");
		dataTable.addColumn(ColumnType.NUMBER, "Anzahl Filme: ");
		dataTable.addRows(122);
		dataTable.setValue(0, 0, "United States");
		dataTable.setValue(0, 1, uscount);
		dataTable.setValue(1, 0, "Norway");
		dataTable.setValue(1, 1, NOcount);
		dataTable.setValue(2, 0, "United Kingdom");
		dataTable.setValue(2, 1, GBcount);
		dataTable.setValue(3, 0, "Germany");
		dataTable.setValue(3, 1, DEcount);
		dataTable.setValue(4, 0, "South Africa");
		dataTable.setValue(4, 1, ZAcount);
		dataTable.setValue(5, 0, "Canada");
		dataTable.setValue(5, 1, CAcount);
		dataTable.setValue(6, 0, "Brazil");
		dataTable.setValue(6, 1, BRcount);
		dataTable.setValue(7, 0, "Netherlands");
		dataTable.setValue(7, 1, NLcount);
		dataTable.setValue(8, 0, "Poland");
		dataTable.setValue(8, 1, PLcount);
		dataTable.setValue(9, 0, "India");
		dataTable.setValue(9, 1, INcount);
		dataTable.setValue(10, 0, "New Zealand");
		dataTable.setValue(10, 1, NZcount);
		
		dataTable.setValue(11, 0, "Mexico");
		dataTable.setValue(11, 1, MXcount);
		dataTable.setValue(12, 0, "Australia");
		dataTable.setValue(12, 1, AUcount);
		dataTable.setValue(13, 0, "Hong Kong");
		dataTable.setValue(13, 1, HKcount);
		dataTable.setValue(14, 0, "Italy");
		dataTable.setValue(14, 1, ITcount);
		dataTable.setValue(15, 0, "Denmark");
		dataTable.setValue(15, 1, DKcount);
		dataTable.setValue(16, 0, "Argentina");
		dataTable.setValue(16, 1, ARcount);
		dataTable.setValue(17, 0, "Japan");
		dataTable.setValue(17, 1, JPcount);
		dataTable.setValue(18, 0, "Turkey");
		dataTable.setValue(18, 1, TRcount);
		dataTable.setValue(19, 0, "France");
		dataTable.setValue(19, 1, FRcount);
		dataTable.setValue(20, 0, "Spain");
		dataTable.setValue(20, 1, EScount);
		dataTable.setValue(21, 0, "South Korea");
		dataTable.setValue(21, 1, KPcount);
		dataTable.setValue(22, 0, "Hungary");
		dataTable.setValue(22, 1, HUcount);
		dataTable.setValue(35, 0, "Russia");
		dataTable.setValue(35, 1, RUcount);
		
		dataTable.setValue(23, 0, "Pakistan");
		dataTable.setValue(23, 1, PKcount);
		dataTable.setValue(24, 0, "Nepal");
		dataTable.setValue(24, 1, NPcount);
		dataTable.setValue(25, 0, "Finland");
		dataTable.setValue(25, 1, FIcount);
		dataTable.setValue(26, 0, "Ireland");
		dataTable.setValue(26, 1, IEcount);
		dataTable.setValue(27, 0, "China");
		dataTable.setValue(27, 1, CNcount);
		dataTable.setValue(28, 0, "Austria");
		dataTable.setValue(28, 1, ATcount);
		dataTable.setValue(29, 0, "Philippines");
		dataTable.setValue(29, 1, PHcount);
		dataTable.setValue(30, 0, "Romania");
		dataTable.setValue(30, 1, ROcount);
		dataTable.setValue(31, 0, "Slovakia");
		dataTable.setValue(31, 1, SKcount);
		dataTable.setValue(32, 0, "Sweden");
		dataTable.setValue(32, 1, SEcount);
		dataTable.setValue(33, 0, "Egypt");
		dataTable.setValue(33, 1, EGcount);
		dataTable.setValue(34, 0, "Czechoslovakia");
		dataTable.setValue(34, 1, CZcount);
		
		dataTable.setValue(36, 0, "Iceland");
		dataTable.setValue(36, 1, IScount);
		dataTable.setValue(37, 0, "Indonesia");
		dataTable.setValue(37, 1, IDcount);
		dataTable.setValue(38, 0, "Greece");
		dataTable.setValue(38, 1, GRcount);
		dataTable.setValue(40, 0, "Yugoslavia");
		dataTable.setValue(40, 1, MKcount);
		dataTable.setValue(41, 0, "Portugal");
		dataTable.setValue(41, 1, PTcount);
		dataTable.setValue(42, 0, "England");
		dataTable.setValue(42, 1, GBcount);
		dataTable.setValue(43, 0, "Bosnia and Herzegovina");
		dataTable.setValue(43, 1, BAcount);
		dataTable.setValue(44, 0, "Belgium");
		dataTable.setValue(44, 1, BEcount);
		dataTable.setValue(45, 0, "Croatia");
		dataTable.setValue(45, 1, HRcount);
		dataTable.setValue(46, 0, "Israel");
		dataTable.setValue(46, 1, ILcount);
		dataTable.setValue(47, 0, "Malaysia");
		dataTable.setValue(47, 1, MYcount);
		dataTable.setValue(48, 0, "Uzbekistan");
		dataTable.setValue(48, 1, UZcount);
		
		dataTable.setValue(49, 0, "Switzerland");
		dataTable.setValue(49, 1, CHcount);
		dataTable.setValue(50, 0, "Iran");
		dataTable.setValue(50, 1, IRcount);
		dataTable.setValue(51, 0, "Puerto Rico");
		dataTable.setValue(51, 1, PRcount);
		dataTable.setValue(52, 0, "Albania");
		dataTable.setValue(52, 1, ALcount);
		dataTable.setValue(53, 0, "Albania");
		dataTable.setValue(53, 1, KHcount);
		dataTable.setValue(54, 0, "Thailand");
		dataTable.setValue(54, 1, THcount);
		dataTable.setValue(55, 0, "Taiwan");
		dataTable.setValue(55, 1, TWcount);
		dataTable.setValue(56, 0, "Estonia");
		dataTable.setValue(56, 1, EEcount);
		dataTable.setValue(57, 0, "Scotland");// A
		dataTable.setValue(57, 1, GBcount);
		dataTable.setValue(58, 0, "Venezuela");
		dataTable.setValue(58, 1, VEcount);
		dataTable.setValue(59, 0, "Vietnam");
		dataTable.setValue(59, 1, VNcount);
		dataTable.setValue(60, 0, "Sri Lanka");
		dataTable.setValue(60, 1, LKcount);
		
		dataTable.setValue(61, 0, "Singapore");
		dataTable.setValue(61, 1, SGcount);
		dataTable.setValue(62, 0, "Bangladesh");
		dataTable.setValue(62, 1, BDcount);
		dataTable.setValue(63, 0, "Colombia");
		dataTable.setValue(63, 1, COcount);
		dataTable.setValue(64, 0, "Senegal");
		dataTable.setValue(64, 1, SNcount);
		dataTable.setValue(65, 0, "Serbia");
		dataTable.setValue(65, 1, RScount);
		dataTable.setValue(66, 0, "Slovenia");
		dataTable.setValue(66, 1, SIcount);
		dataTable.setValue(67, 0, "Bulgaria");
		dataTable.setValue(67, 1, BGcount);
		dataTable.setValue(68, 0, "Ukraine");
		dataTable.setValue(68, 1, UAcount);
		dataTable.setValue(69, 0, "Slovak Republic");
		dataTable.setValue(69, 1, SKcount);
		dataTable.setValue(70, 0, "Azerbaijan");
		dataTable.setValue(70, 1, AZcount);
		dataTable.setValue(71, 0, "Cuba");
		dataTable.setValue(71, 1, CUcount);
		dataTable.setValue(72, 0, "Malta");
		dataTable.setValue(72, 1, MTcount);
		
		dataTable.setValue(73, 0, "Bolivia");
		dataTable.setValue(73, 1, BOcount);
		dataTable.setValue(74, 0, "Uruguay");
		dataTable.setValue(74, 1, UYcount);
		dataTable.setValue(75, 0, "Chile");
		dataTable.setValue(75, 1, CLcount);
		dataTable.setValue(76, 0, "Peru");
		dataTable.setValue(76, 1, PEcount);
		dataTable.setValue(77, 0, "Kenya");
		dataTable.setValue(77, 1, KEcount);
		dataTable.setValue(78, 0, "Burma");
		dataTable.setValue(78, 1, BFcount);
		dataTable.setValue(79, 0, "Georgia");
		dataTable.setValue(79, 1, GEcount);
		dataTable.setValue(80, 0, "Isle of Man");
		dataTable.setValue(80, 1, IMcount);
		dataTable.setValue(81, 0, "Korea");
		dataTable.setValue(81, 1, KRcount);
		dataTable.setValue(82, 0, "Costa Rica");
		dataTable.setValue(82, 1, CRcount);
		dataTable.setValue(83, 0, "Morocco");
		dataTable.setValue(83, 1, MAcount);
		dataTable.setValue(84, 0, "Algeria");
		dataTable.setValue(84, 1, DZcount);
		
		dataTable.setValue(85, 0, "Tunisia");
		dataTable.setValue(85, 1, TNcount);
		dataTable.setValue(86, 0, "Lebanon");
		dataTable.setValue(86, 1, LBcount);
		dataTable.setValue(87, 0, "Zimbabwe");
		dataTable.setValue(87, 1, ZWcount);
		dataTable.setValue(88, 0, "Jordan");
		dataTable.setValue(88, 1, JOcount);
		dataTable.setValue(89, 0, "Lithuania");
		dataTable.setValue(89, 1, LTcount);
		dataTable.setValue(90, 0, "Congo");
		dataTable.setValue(90, 1, CDcount);
		dataTable.setValue(91, 0, "Mongolia");
		dataTable.setValue(91, 1, MNcount);
		dataTable.setValue(92, 0, "Luxembourg");
		dataTable.setValue(92, 1, LUcount);
		dataTable.setValue(93, 0, "Armenia");
		dataTable.setValue(93, 1, AMcount);
		dataTable.setValue(94, 0, "United Arab Emirates");
		dataTable.setValue(94, 1, AEcount);
		dataTable.setValue(95, 0, "Jamaica");
		dataTable.setValue(95, 1, JMcount);
		dataTable.setValue(96, 0, "Nigeria");
		dataTable.setValue(96, 1, NGcount);
		
		dataTable.setValue(97, 0, "Afghanistan");
		dataTable.setValue(97, 1, AFcount);
		dataTable.setValue(98, 0, "Uzbek");
		dataTable.setValue(98, 1, UZcount);
		dataTable.setValue(99, 0, "Bhutan");
		dataTable.setValue(99, 1, BTcount);
		dataTable.setValue(100, 0, "Ethiopia");
		dataTable.setValue(100, 1, ETcount);
		dataTable.setValue(101, 0, "Bahamas");
		dataTable.setValue(101, 1, BScount);
		dataTable.setValue(102, 0, "Iraq");
		dataTable.setValue(102, 1, IQcount);
		dataTable.setValue(103, 0, "Turkmenistan");
		dataTable.setValue(103, 1, TMcount);
		dataTable.setValue(104, 0, "Bahrain");
		dataTable.setValue(104, 1, BHcount);
		dataTable.setValue(105, 0, "Kuwait");
		dataTable.setValue(105, 1, KWcount);
		dataTable.setValue(106, 0, "Mali");
		dataTable.setValue(106, 1, MLcount);
		dataTable.setValue(107, 0, "Guinea-Bissau");
		dataTable.setValue(107, 1, GWcount);
		dataTable.setValue(108, 0, "Cameroon");
		dataTable.setValue(108, 1, CMcount);
		
		dataTable.setValue(109, 0, "Haiti");
		dataTable.setValue(109, 1, HTcount);
		dataTable.setValue(110, 0, "Zambia");
		dataTable.setValue(110, 1, ZMcount);
		dataTable.setValue(111, 0, "Palestine");
		dataTable.setValue(111, 1, PScount);
		dataTable.setValue(112, 0, "Qatar");
		dataTable.setValue(112, 1, QAcount);
		dataTable.setValue(113, 0, "Cyprus");
		dataTable.setValue(113, 1, CYcount);
		dataTable.setValue(114, 0, "Libya");
		dataTable.setValue(114, 1, LYcount);
		dataTable.setValue(115, 0, "Panama");
		dataTable.setValue(115, 1, PAcount);
		dataTable.setValue(116, 0, "Monaco");
		dataTable.setValue(116, 1, MCcount);
		dataTable.setValue(117, 0, "Guinea");
		dataTable.setValue(117, 1, GNcount);
		dataTable.setValue(118, 0, "Aruba");
		dataTable.setValue(118, 1, AWcount);
		dataTable.setValue(119, 0, "Montenegro");
		dataTable.setValue(119, 1, MEcount);
		dataTable.setValue(120, 0, "Macau");
		dataTable.setValue(120, 1, MOcount);
		dataTable.setValue(121, 0, "Greenland");
		dataTable.setValue(121, 1, 0);
		
	
		// Set options
		GeoChartOptions options = GeoChartOptions.create();
		GeoChartColorAxis geoChartColorAxis = GeoChartColorAxis.create();
		
		options.setColorAxis(geoChartColorAxis);
		options.setDatalessRegionColor("gray");
		options.setHeight(300);
		options.setWidth(800);

		// Draw the chart
	geoChart.draw(dataTable, options);
		dlp.clear();
		
		dlp.add(geoChart);
	
		this.dataTable = dataTable;
		goptions = options;
		
	}
	public void draw2() {
		// Prepare the data
		DataTable dataTable = DataTable.create();
		dataTable.addColumn(ColumnType.STRING, "Country");
		dataTable.addColumn(ColumnType.NUMBER, "Anzahl Filme:");
	
		dataTable.addRows(6);

		// Set options
		GeoChartOptions options = GeoChartOptions.create();
		GeoChartColorAxis geoChartColorAxis = GeoChartColorAxis.create();
		
		options.setColorAxis(geoChartColorAxis);
		options.setDatalessRegionColor("gray");
		options.setHeight(300);
		options.setWidth(800);

		// Draw the chart
		geoChart.draw(dataTable, options);
		dlp.clear();
	
		dlp.add(geoChart);
	
		this.dataTable = dataTable;
		goptions = options;
	
	}
	
	
		     		
			
}
