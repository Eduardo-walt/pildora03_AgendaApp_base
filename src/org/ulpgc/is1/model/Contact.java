package org.ulpgc.is1.model;

public abstract class Contact {
    private String telephone;
    private String email;
    private Address address;

    public Contact(String telephone, String email, Address address) {
        this.telephone = telephone;
        this.email = email;
        this.address = address;
    }

    public abstract String getName();

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Contact)) return false;
        Contact other = (Contact) obj;
        return this.telephone.equals(other.telephone) && this.email.equals(other.email);
    }

    @Override
    public int hashCode() {
        return telephone.hashCode() + email.hashCode();
    }
}
