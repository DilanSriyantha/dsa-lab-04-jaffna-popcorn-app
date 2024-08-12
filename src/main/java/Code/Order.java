package Code;

public class Order {
    private int orderNumber;
    private String[] products;
    private int [] quantity;
    
    public Order(int orderNumber, String[] products, int[] quantity){
        this.orderNumber = orderNumber;
        this.products = products;
        this.quantity = quantity;
    }
    
    public String[] getProducts() {
        return products;
    }
    
    public int[] getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        String str = "\t------------------------Order #" + orderNumber + "------------------------\n";
        for(int i = 0; i < products.length; i++)
            str += "\t" + (i + 1) + ". " + products[i] + "\t: " + quantity[i] + "\n";
        str += "\t------------------------------------------------------------";
        
        return str;
    }
}