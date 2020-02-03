package org.dhiren.spring.annotation.stereo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(scopeName = "prototype")
public class Instructor {

    @Value("#{T(java.lang.Integer).MIN_VALUE}")
    private int min_int;

    @Value("#{T(java.lang.Integer).MAX_VALUE}")
    private int max_int;

    @Value("#{T(java.lang.Math).abs(-33)}")
    private int abs_int;

    @Value("#{new Integer(100)}")
    private int new_int;

    @Value("101")
    private int id;

    @Value("#{'Anushka'.toUpperCase()}")
    private String name;

    @Value("#{cartItemsList}")
    private List<String> cartItems;

    @Autowired
    private MyProfile profile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<String> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "min_int=" + min_int +
                ", max_int=" + max_int +
                ", abs_int=" + abs_int +
                ", new_int=" + new_int +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", cartItems=" + cartItems +
                ", profile=" + profile +
                '}';
    }
}
