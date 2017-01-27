package lifecoach.external.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.json.JSONObject;

public class CatClient {

	public CatClient(){		

	}
	
	public static void main(String args[]){
		System.out.println(getCatPicture());
	}

    public static String getCatPicture() {
    	ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		//https://nijikokun-random-cats.p.mashape.com/random/kitten
		WebTarget service = client.target("https://nijikokun-random-cats.p.mashape.com");
		Response response = service.path("/random/kitten")
				.request()
				.header("X-Mashape-Key", "GGmEzV4iwjmshB4dEG1U9xbYFpD2p1BFYxijsncZ4MVvqkCp5g")
				.accept(MediaType.APPLICATION_JSON).get();

		JSONObject obj = new JSONObject(response.readEntity(String.class));
		
		return obj.getString("source");
    }
}