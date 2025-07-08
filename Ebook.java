public class Ebook extends Book {
    
    private MailService mailService ;
    private String type;

    public Ebook(String title, String isbn, int publicationYear, double price,String type) {
        super(title, isbn, publicationYear, price);
        this.type = type;
    }
    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public void newBookType() {
        System.out.println("This is an eBook.");
    }
   
    public void sendEBook(String email) {
        if (mailService != null) 
            mailService.SendEBook(email);
         else 
            System.out.println("No mail service provided !");
        
    }
    
   
    
}
