package webService;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.BankDAO;
import dto.Bank;
import dto.BusinessUnits;

import java.util.List;

/**
 * Bank service resource class.
 */
@Path("/bank")
public class BankService {

    Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

    @GET
    @Path("/getAllBanks")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllBanks(){
        List<Bank> banks = new BankDAO().getAllBanks();
        return gson.toJson(banks);
    }

    @GET
    @Path("/getBankByBankId/{bank_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getBankByBankId(@PathParam("bank_id") int bank_id){
        Bank bank = new BankDAO().getBankByBankId(bank_id);
        return gson.toJson(bank);
    }

    @GET
    @Path("/getBranchesByBankId/{bank_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getBranchesByBankId(@PathParam("bank_id") int bank_id){
        List<BusinessUnits> businessUnitses = new BankDAO().getBranchesByBankId(bank_id);
        return gson.toJson(businessUnitses);
    }
}
