package ch.hesge.db;

import java.io.IOException;


import javax.ws.rs.core.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class CalculeThread  extends Thread{
	
	
	public CalculeThread() {
		super();

	}

	//Ne pas modifier cette méthode
	public void run() {

	System.out.println("==>CalculeProcess()");

	System.out.println("==> simulation d'un long calcule......");
    try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	new Database().inc();
	
	}
	
	//Méthode a  modifier
	public  void envoieCallback(String url) {
		System.out.println("==> envoieCallback(url)");

    	HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url); 
		request.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN); 
		try {
			request.setEntity(new StringEntity("reponse envoyee"));
			HttpResponse response=client.execute(request);
			System.out.println(response.getStatusLine().getStatusCode());

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}
	
	

}
