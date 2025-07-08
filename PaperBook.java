public class PaperBook extends Book {


    private ShippingService shippingService;
    public PaperBook(String title, String isbn, int publicationYear, double price) {
        super(title, isbn, publicationYear, price);
    
    }

    @Override
    public void newBookType() {
        System.out.println("This is a paper book.");
    }

    public void setShippingService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

 
   public void sendPaperbook(String address) {
        if (shippingService != null) 
            shippingService.sendPaperbook(address);
         else 
            System.out.println("No shipping service available !");
        
    }
    
}
