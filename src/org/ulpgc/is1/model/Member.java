package org.ulpgc.is1.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Member {
    private Contact contact;
    private LocalDateTime date;

    public Member(Contact contact) {
        this.contact = contact;
        this.date = LocalDateTime.now();
    }

    public Contact getContact() {
        return contact;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return contact.getName() + " added on " + date.format(formatter);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Member)) return false;
        Member other = (Member) obj;
        return contact.equals(other.contact);
    }

    @Override
    public int hashCode() {
        return contact.hashCode();
    }
}
