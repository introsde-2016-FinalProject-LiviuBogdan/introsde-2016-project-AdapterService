package lifecoach.external.server;

import javax.ejb.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Stateless
@LocalBean
@Path("/catpic")
public class PictureResource {

	// Allows to insert contextual objects into the class,
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@GET
	@Produces({MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public String getMeasureTypes() {
		System.out.println("Getting cat pic...");
		String a = lifecoach.external.client.CatClient.getCatPicture();
		System.out.println(a);
		return a;
	}
}
