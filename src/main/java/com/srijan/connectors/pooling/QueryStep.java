package com.srijan.connectors.pooling;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class QueryStep extends Thread {
	private CloseableHttpClient myClient;
	private HttpGet myGet;
	private String myApi;
	
	public QueryStep( CloseableHttpClient client, HttpGet get, String api )
	{
		this.myClient = client;
		this.myGet = get;
		this.myApi = api;
	}
	
	public void run()
	{
		try {
			HttpResponse response = myClient.execute(myGet);
			HttpEntity entity = response.getEntity();
			Gson gson = new Gson();
			if( myApi.equals("IDS"))
			{
				String jsonResponse = EntityUtils.toString(entity);
				IdentifierDocument docs[] = gson.fromJson(jsonResponse, IdentifierDocument[].class);
				for( IdentifierDocument doc : docs)
				{
					System.out.println( doc.toString() );
				}
			}
			else if(myApi.equals("DOCS")) 
			{
				String jsonResponse = EntityUtils.toString(entity);
				SearchDocument docs[] = gson.fromJson(jsonResponse, SearchDocument[].class);
				for( SearchDocument doc : docs)
				{
					System.out.println( doc.toString() );
				}
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
