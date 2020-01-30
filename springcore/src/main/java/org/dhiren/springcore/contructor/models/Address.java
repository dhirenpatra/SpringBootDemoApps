package org.dhiren.springcore.contructor.models;

public class Address {
    private String hno;
    private String stree;
    private String city;

    public Address(String hno, String stree, String city) {
        this.hno = hno;
        this.stree = stree;
        this.city = city;
    }

    public String getHno() {
        return hno;
    }

    public void setHno(String hno) {
        this.hno = hno;
    }

    public String getStree() {
        return stree;
    }

    public void setStree(String stree) {
        this.stree = stree;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "hno='" + hno + '\'' +
                ", stree='" + stree + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
