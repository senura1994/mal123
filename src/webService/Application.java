package webService;



/**
 * Application entry point.
 */
public class Application {
    public static void main(String[] args) {
        int port=7878;
        if (args.length>0){
            try {
                port = Integer.parseInt(args[0]);
            }catch(Exception ex){
                System.out.println("Invalid port. Default port 8080 will be used.");
            }
        }
        new MicroservicesRunner(port)
                .deploy(new BankService(), new AccountService(), new TransactionService(), new PersonService(), new OrganizationService())
                .start();
    }
}
