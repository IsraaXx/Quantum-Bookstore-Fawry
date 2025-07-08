public class myShippingService implements ShippingService {
    public void sendPaperbook(String address) {
        System.out.println("Shipping paper book to " + address);
    }
}