package org.dhiren.springcore.model;

import java.util.Map;

public class Customer {
    private String name;

    private Map<Integer, String> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, String> getProducts() {
        return products;
    }

    public void setProducts(Map<Integer, String> products) {
        this.products = products;
    }
}
