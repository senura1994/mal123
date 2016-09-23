package webService;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.PersonDAO;
import dto.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Hello service resource class.
 */
@Path("/person")
public class PersonService {

    Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

    @GET
    @Path("/getPersonByPartyId/{party_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonByPartyId(@PathParam("party_id") int party_id){
        Person person = new PersonDAO().getPersonByPartyId(party_id);
        return gson.toJson(person);
    }

    @GET
    @Path("/getPersonByEMailId/{email_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonByEMailId(@PathParam("email_id") String email_id){
        Person person = new PersonDAO().getPersonByEMailId(email_id);
        return gson.toJson(person);
    }
}
