package com.kavlad.customerapi;

public class Address {

    private String type;
    private String city;
    private String country;
    private String addressLine;

    public Address(String type, String city, String country, String addressLine) {
        this.type = type;
        this.city = city;
        this.country = country;
        this.addressLine = addressLine;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getType() {
        return type;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getAddressLine() {
        return addressLine;
    }
}