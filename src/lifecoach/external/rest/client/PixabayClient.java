package lifecoach.external.rest.client;

import java.util.Random;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.json.JSONArray;
import org.json.JSONObject;

public class PixabayClient {

	public PixabayClient(){		

	}
	
	public static void main(String args[]){
		System.out.println(getPictureByTopic("cute+cat"));
	}

	//4387580-2dfcf3d477232563311e63a4e
    public static String getPictureByTopic(String topic) {
    	ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget service = client.target("https://pixabay.com/api/?key=4387580-2dfcf3d477232563311e63a4e&q="+topic+"&image_type=photo");
		Response response = service.request()
				.accept(MediaType.APPLICATION_JSON).get();

		System.out.println(response);
		if(response.getStatus()==200){
			JSONObject obj = new JSONObject(response.readEntity(String.class));
			//System.out.println(obj.toString());
	
			JSONArray pics = obj.getJSONArray("hits");
			//System.out.println(pics.length());
			if(pics.length()>0){
				Random random = new Random();
				int randPic = random.nextInt(pics.length());
				//System.out.println(pics.length() +" "+ randPic);
				
				obj = new JSONObject(pics.get(randPic).toString());
				
				return obj.getString("webformatURL"); 
			}
		}
		return " ";
    }
}