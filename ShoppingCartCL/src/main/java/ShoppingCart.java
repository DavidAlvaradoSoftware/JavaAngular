import java.util.ArrayList;
import java.util.HashMap;

class ShoppingCart {

    private ArrayList<Product> shoppingCart;

    public ShoppingCart() {
        shoppingCart = new ArrayList<>();
    }

    public void addProduct(Product product){
        if( shoppingCart == null) shoppingCart = new ArrayList<Product>();
        shoppingCart.add(product);
    }

    public void removeProduct(Product product){
        if(shoppingCart.isEmpty()) {shoppingCart = new ArrayList<>();}
        shoppingCart.remove(product);
    }

    public double calculateTotal(){
        double result = 0.00;
        if (shoppingCart.isEmpty()){ return result; }
        for (Product product: shoppingCart) {
            result += product.getPrice();
        }
        return result;
    }

    public void displayCart(){
        for (Product product: shoppingCart) {
            System.out.print(product.toString() + ", ");
        }
        System.out.println();
    }



    // Display cart method
}
