public abstract class Book {

    private String title;
    private String ISBN;    
    private int publicationYear;  
    private double price;      

    public void newBookType(){
        System.out.println("This is a book.");
    }
    public Book(String title, String ISBN, int publicationYear, double price) {
        this.title = title;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    int getPublicationYear() {
        return publicationYear;
    }
    double getPrice() {
        return price;
    }
    String getTitle() {
        return title;
    }
    String getISBN() {
        return ISBN;
    }
    
} 