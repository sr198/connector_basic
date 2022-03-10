package com.srijan.connectors.pooling;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class Indexer {
	public static void main(String[] args) throws Exception
	{
		//Create a connection pool manager
		PoolingHttpClientConnectionManager poolManager = new PoolingHttpClientConnectionManager();
		CloseableHttpClient client1 = HttpClients.custom().setConnectionManager(poolManager).build();
		CloseableHttpClient client2 = HttpClients.custom().setConnectionManager(poolManager).build();
		
		HttpGet get1 = new HttpGet( "http://localhost:3004/doc_ids" );
		HttpGet get2 = new HttpGet( "http://localhost:3000/docs" );
		
		//Create thread instance 1
		QueryStep step1 = new QueryStep( client1, get1, "IDS" );
		QueryStep step2 = new QueryStep( client2, get2, "DOCS" );
		
		step1.start();
		step2.start();
		
		step1.join();
		step2.join();		
	}
}
