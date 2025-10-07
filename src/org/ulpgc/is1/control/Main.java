package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;

import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        // 1. Crear dos contactos en la agenda de tipo Person
        Address addr1 = new Address("Main Street", 123, 4, "Anytown");
        Address addr2 = new Address("Other Street", 456, 1, "Othertown");

        agenda.addPerson("John", "Doe", "123456789", "john.doe@example.com", addr1);
        agenda.addPerson("Jane", "Doe", "987654321", "jane.doe@example.com", addr2);

        // 2. Crear un grupo en la agenda llamado "trabajo"
        agenda.addGroup("trabajo");

        // 3. Añadir al grupo “trabajo” uno de los contactos creados en el paso 1
        Group trabajoGroup = agenda.getGroupByName("trabajo");
        Contact contactToAdd = agenda.getContactList().get(0);
        agenda.addMember2Group(contactToAdd, trabajoGroup);

        // 4. Imprimir por pantalla el número de contactos de la agenda
        System.out.println("Número de contactos en la agenda: " + agenda.getContactList().size());

        // 5. Imprimir por pantalla el número de contactos del grupo “trabajo”
        System.out.println("Número de contactos en el grupo 'trabajo': " + trabajoGroup.getMembers().size());

        // Imprimir la fecha de alta del miembro en el grupo “trabajo”
        Member member = trabajoGroup.getMember(contactToAdd);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("Fecha de alta en el grupo: " + member.getDate().format(formatter));

        // 6. Borrar el primer contacto del grupo “trabajo"
        trabajoGroup.removeContact(contactToAdd);

        // 7. Volver a imprimir por pantalla el número de contactos del grupo “trabajo”
        System.out.println("Número de contactos en el grupo 'trabajo' después de borrar: " + trabajoGroup.getMembers().size());

        // 8. Probar a añadir un contacto duplicado
        System.out.println("\nIntentando añadir un contacto duplicado...");
        agenda.addPerson("John", "Doe", "123456789", "john.doe@example.com", addr1);
        System.out.println("Número de contactos en la agenda: " + agenda.getContactList().size());
    }
}
