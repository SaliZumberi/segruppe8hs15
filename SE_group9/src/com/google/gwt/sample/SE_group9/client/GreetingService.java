package com.google.gwt.sample.SE_group9.client;

import java.io.File;
import java.io.IOException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


/*path to the xml file*/
@RemoteServiceRelativePath("data")
public interface GreetingService extends RemoteService {

	/**
	 * The Client-side stub for the RPC service. LUCAS LUCAS
	 */
	String [][] importData (String path);
	public Integer getNumberOfColumns (String path);
	public Integer getNumberOfLines (String path);

}
