package lifecoach.external.rest.server.resources;

import javax.ejb.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Stateless
@LocalBean
@Path("/pixabay")
public class PictureResource {

	// Allows to insert contextual objects into the class,
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@GET
	@Path("/{topic}")
	@Produces({MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public String getMeasureTypes(@PathParam("topic") String topic) {
		System.out.println("Getting "+topic+" pic...");
		String link = lifecoach.external.rest.client.PixabayClient.getPictureByTopic(topic);
		System.out.println(link);
		return link;
	}
}
