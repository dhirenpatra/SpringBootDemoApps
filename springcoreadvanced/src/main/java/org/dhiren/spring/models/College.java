package org.dhiren.spring.models;

import org.springframework.beans.factory.annotation.Autowired;

public class College {

    private Address address;

    public College(Address address) {
        this.address = address;
    }

    public College() {
    }

    public Address getAddress() {
        return address;
    }

    @Autowired
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "College{" +
                "address=" + address +
                '}';
    }
}
