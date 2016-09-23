package webService;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.TransactionDAO;
import dto.AccountOwner;
import dto.Transaction;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Transaction service resource class.
 */
@Path("/transaction")
public class TransactionService {

    Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

    @GET
    @Path("/getTransactionByTransactionId/{transaction_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTransactionByTransactionId(@PathParam("transaction_id") int transaction_id){
        Transaction transaction = new TransactionDAO().getTransactionById(transaction_id);
        return gson.toJson(transaction);
    }

    @GET
    @Path("/getTransactionByAccountId/{acct_id}/{fromDate}/{toDate}/{startIndex}/{pageSize}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTransactionByAccountId(@PathParam("acct_id") int acct_id, @PathParam("fromDate") String fromDate, @PathParam("toDate") String toDate, @PathParam("startIndex") int startIndex, @PathParam("pageSize") int pageSize){
        List<Transaction> transactions = new TransactionDAO().getTransactionByAccountId(acct_id,fromDate,toDate,startIndex,pageSize);
        return gson.toJson(transactions);
    }

    @GET
    @Path("/getCounterPartiesByPartyId/{party_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCounterPartiesByPartyId(@PathParam("party_id") int party_id){
        List<AccountOwner> accountOwners = new TransactionDAO().getCounterPartiesByPartyId(party_id);
        return gson.toJson(accountOwners);
    }
}
