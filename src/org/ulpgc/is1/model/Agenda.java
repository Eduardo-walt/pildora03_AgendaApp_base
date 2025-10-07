package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contact> contactList = new ArrayList<>();
    private List<Group> groupList = new ArrayList<>();

    public void addPerson(String firstName, String lastName, String telephone, String email, Address address) {
        Person person = new Person(firstName, lastName, telephone, email, address);
        if (!contactList.contains(person)) {
            contactList.add(person);
        }
    }

    public void addCompany(String name, String description, String telephone, String email, Address address) {
        Company company = new Company(name, description, telephone, email, address);
        if (!contactList.contains(company)) {
            contactList.add(company);
        }
    }

    public void addGroup(String name) {
        Group group = new Group(name);
        if (!groupList.contains(group)) {
            groupList.add(group);
        }
    }

    public void addMember2Group(Contact contact, Group group) {
        if (!groupList.contains(group)) return;
        group.addContact(contact);
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public Group getGroupByName(String name) {
        for (Group g : groupList) {
            if (g.getName().equalsIgnoreCase(name)) return g;
        }
        return null;
    }
}
