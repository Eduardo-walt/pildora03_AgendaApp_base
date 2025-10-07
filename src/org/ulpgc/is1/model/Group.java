package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private List<Member> members;

    public Group(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addContact(Contact contact) {
        Member member = new Member(contact);
        if (!members.contains(member)) {
            members.add(member);
        }
    }

    public void removeContact(Contact contact) {
        members.removeIf(m -> m.getContact().equals(contact));
    }

    public Member getMember(Contact contact) {
        for (Member m : members) {
            if (m.getContact().equals(contact)) return m;
        }
        return null;
    }

    public List<Member> getMembers() {
        return members;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Group)) return false;
        Group other = (Group) obj;
        return this.name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }
}
