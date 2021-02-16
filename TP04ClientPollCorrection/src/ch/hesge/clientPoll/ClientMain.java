package ch.hesge.clientPoll;

import java.io.*;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.impl.client.*;
import org.apache.http.client.methods.*;
public class ClientMain {
	
	private static final String URL= "http://localhost:8080/TP04ServicePollCorrection/service1/number";
	private static final String TAB="     ";

	public static void main(String[] args) throws Exception { 
		
		HttpClient client = HttpClientBuilder.create().disableRedirectHandling().build();
		HttpGet request = new HttpGet(URL);
		request.setHeader(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN);
		HttpResponse response = client.execute(request);
		
		System.out.println(TAB+": Appel au service 1");
		int statusReq1=response.getStatusLine().getStatusCode();
		
		System.out.println(TAB+"status reçu: "+statusReq1);

		System.out.println("----");
						
		if (statusReq1 == HttpServletResponse.SC_SEE_OTHER)
		{
			// l'url du service 2(qui va prendre en charge la request) est recue dans le Header Location
			System.out.println("Reception de l'URL du service2 ");
			String urlDeRedirection = response.getFirstHeader(HttpHeaders.LOCATION).getValue();
			
			System.out.println(TAB+" Debut du Poll au service2 ");
			
			int statusReq2;
			int cpt=0;
			
			do {
				client = HttpClientBuilder.create().build();
				request = new HttpGet(urlDeRedirection);
				request.setHeader(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN);
				response = client.execute(request);
				statusReq2=response.getStatusLine().getStatusCode();
				
				System.out.println("La requete pas encore prete, veuillez patienter.....");
				cpt++;

			} while (statusReq2 != HttpServletResponse.SC_OK);
						BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
						StringBuffer result = new StringBuffer();
						String line = "";
						while ((line = rd.readLine()) != null) result.append(line);
						
						System.out.println(TAB+result.toString()+" apres "+ cpt+" Poll(s)" );
		}
		
   }
}
