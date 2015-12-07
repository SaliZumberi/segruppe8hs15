package com.google.gwt.sample.SE_group9.server;

import org.junit.*;
import org.junit.Test;
import com.google.gwt.junit.client.GWTTestCase;

public class GreetingServiceImplTest extends GWTTestCase{
	
	public String getModuleName() {                                         
        return "com.google.gwt.sample.SE_group9.SE_group9";		//richtiger name??
    }

	@Test
	public void testImportData() 
		throws Exception{
		GreetingServiceImpl greetingService = new GreetingServiceImpl();
		greetingService.importData("/excelFiles/MoviesCountry.txt");
	}

	@Test
	public void testGetNumberOfLines() 
		throws Exception{
		GreetingServiceImpl greetingService = new GreetingServiceImpl();
		greetingService.getNumberOfLines("/excelFiles/MoviesCountry.txt");
	}

	@Test
	public void testGetNumberOfColumns() 
		throws Exception{
		GreetingServiceImpl greetingService = new GreetingServiceImpl();
		greetingService.getNumberOfColumns("/excelFiles/MoviesCountry.txt");
	}

}
