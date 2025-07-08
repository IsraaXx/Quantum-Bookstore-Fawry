import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

public class Inventory {
    private int Totalquantity ; 
    private Map< String,Book> books = new HashMap<>();
    private Map<Class<? extends Book>, Integer> bookQuantities = new HashMap<>();

    private ShippingService shippingService;
    private MailService mailService;

    public Inventory(ShippingService shippingService, MailService mailService) {
        this.shippingService = shippingService;
        this.mailService = mailService;
    }

    public int getTotalQuantity() {
        return Totalquantity;}

    public void addBook(Book book) {
        Class<? extends Book> bookType = book.getClass();
        bookQuantities.put(bookType,bookQuantities.getOrDefault(bookType, 0) + 1);
        books.put(book.getISBN(),book);
        Totalquantity++;    
    }

    public int getQuantityOfBook(Class<? extends Book> bookType) {
        return bookQuantities.getOrDefault(bookType, 0);
    }

public List<Book> removeOutdatedBooks(int currentYear, int maxAge) {
        List<Book> removed = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> it = books.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Book> entry = it.next();
            Book b = entry.getValue();
            if (currentYear - b.getPublicationYear() > maxAge) {
                Class<? extends Book> bookType = b.getClass();
                int qty = bookQuantities.getOrDefault(bookType, 0);
                if (qty > 0) {
                    bookQuantities.put(bookType, qty - 1);
                    Totalquantity--;
                    removed.add(b);
                }
                it.remove();
            }
        }

        System.out.println("List of Removed outdated books: " + removed.size());
        return removed;
    }

    public void Buybook(String ISBN, int quantity, String email, String address) {
            if (!books.containsKey(ISBN)) {
            System.out.println("Book not found for ISBN: " + ISBN);
            return;
        
        }

        Book book = books.get(ISBN);
        Class<? extends Book> bookType = book.getClass();
        int currentQuantity = bookQuantities.getOrDefault(bookType, 0);

        if (currentQuantity < quantity) {
            System.out.println("Not enough quantity available for ISBN: " + ISBN);
            System.out.println("Current stock: " + currentQuantity);
            return;
        
        }

        bookQuantities.put(bookType, currentQuantity - quantity);
        Totalquantity -= quantity;

          double totalPrice = book.getPrice() * quantity;
            if (book instanceof PaperBook) {
                shippingService.sendPaperbook(address);
            } else if (book instanceof Ebook) {
                mailService.SendEBook(email);
            }
            else if (book instanceof Demobook) {
                System.out.println("Demo book isn't for sale.");
                return;
            }


        System.out.println("Book purchased successfully: " + book.getTitle() + ", Quantity: " + quantity);
        System.out.println("Total price: " + totalPrice);
    

    }





}