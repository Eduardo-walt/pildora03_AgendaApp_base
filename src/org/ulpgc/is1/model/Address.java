package org.ulpgc.is1.model;

public class Address {
    private String street;
    private int number;
    private int floor;
    private String city;

    public Address(String street, int number, int floor, String city) {
        this.street = street;
        this.number = number;
        this.floor = floor;
        this.city = city;
    }

    @Override
    public String toString() {
        return street + " " + number + ", " + floor + "º, " + city;
    }
}
