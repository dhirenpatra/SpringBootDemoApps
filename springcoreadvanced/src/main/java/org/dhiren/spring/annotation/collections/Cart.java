package org.dhiren.spring.annotation.collections;

import java.util.List;

public class Cart {

    private List<String> cartItems;

    public List<String> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<String> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartItems=" + cartItems +
                '}';
    }
}
