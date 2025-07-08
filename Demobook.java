public class Demobook extends Book {

    private boolean forSale = false;

    public Demobook(String title, String isbn, int publicationYear, double price) {
        super(title, isbn, publicationYear, price);
    }

    @Override
    public void newBookType() {
        System.out.println("This is a demo book type.");
    }

   
    
}
