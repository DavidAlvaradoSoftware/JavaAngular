//You are tasked with implementing a shopping cart application using Java collections.
// The shopping cart should allow users to add and remove items, calculate the total price,
// and display the items in the cart. Follow the steps below to complete the implementation:
public class ShoppingCartDemo {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product productOne = new Product("Shoes", 100.00);
        Product productTwo = new Product("Shirt", 35.00);
        Product productThree = new Product("Pants", 65.00);
        shoppingCart.addProduct(productOne);
        shoppingCart.addProduct(productTwo);
        shoppingCart.addProduct(productThree);

        shoppingCart.displayCart();
        System.out.println(shoppingCart.calculateTotal());

        shoppingCart.removeProduct(productOne);
        shoppingCart.displayCart();
        System.out.println(shoppingCart.calculateTotal());

    }
}
