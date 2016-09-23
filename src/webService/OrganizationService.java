package webService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.OrganizationDAO;
import dto.Organization;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Hello service resource class.
 */
@Path("/organization")
public class OrganizationService {

    Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

    @GET
    @Path("/getOrganizationByPartyId/{party_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getOrganizationByPartyId(@PathParam("party_id") int party_id){
        Organization organization = new OrganizationDAO().getOrganizationByPartyId(party_id);
        return gson.toJson(organization);
    }
    @GET
    @Path("/getOrganizationByEMailId/{email_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getOrganizationByEMailId(@PathParam("email_id") String email_id){
        Organization organization = new OrganizationDAO().getOrganizationByEMailId(email_id);
        return gson.toJson(organization);
    }

}
