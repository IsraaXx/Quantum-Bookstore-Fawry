import java.util.List;

public class BookStoreMain {
    private Inventory inventory;
    List<Book> removedBooks;
     public BookStoreMain(Inventory inventory) {
        this.inventory = inventory;
    }


     public void addBook(Book book) {
        inventory.addBook(book);
    }
     public void removeOutdatedBooks(int currYear , int maxAge) {
        removedBooks = inventory.removeOutdatedBooks(currYear, maxAge);
    }
    public int getInventoryTotalQuantity() {
        return inventory.getTotalQuantity();
    }
    public int getSpecificBookQuantity(Class<? extends Book> bookType) {
        return inventory.getQuantityOfBook(bookType);
    }
        public void BuyBook(String ISBN , int quantity, String email, String address) {   
            inventory.Buybook(ISBN, quantity, email, address);
}

public static void main(String[] args) {
        myShippingService shipping = new myShippingService() ;
        myMailService mail = new myMailService() ;
        Inventory inventory = new Inventory(shipping, mail);
        BookStoreMain store = new BookStoreMain(inventory);
        Book paperBook = new PaperBook("Java Basics", "111", 2020, 20.0);
        Book ebook = new Ebook("Java Advanced", "222", 2023, 15.0,"PDF");
        Book demoBook = new Demobook("Demo Book", "333", 2010, 0.0);

        store.addBook(paperBook);
        store.addBook(paperBook);
        store.addBook(ebook);
        store.addBook(demoBook);
        
        System.out.println("Total books in inventory: " + store.getInventoryTotalQuantity());
        System.out.println("Quantity of PaperBooks: " + store.getSpecificBookQuantity(PaperBook.class));
        System.out.println("Quantity of Ebooks: " + store.getSpecificBookQuantity(Ebook.class));

        store.removeOutdatedBooks(2025, 10);
 
        System.out.println("Total books in inventory after removing outdated books: " + store.getInventoryTotalQuantity());
        System.out.println("======================================================="); 
        store.BuyBook("111", 1, "user@example.com", "123 Main St");
        System.out.println("-------------------------------------------------------"); 
        store.BuyBook("222", 1, "user@example.com", "123 Main St");
        System.out.println("-------------------------------------------------------"); 
        store.BuyBook("111", 2, "user@example.com", "123 Main St");
        

        System.out.println("Final total books in inventory: " + store.getInventoryTotalQuantity());
    }

}