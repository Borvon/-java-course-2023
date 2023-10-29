package edu.hw3.task5;

public class Contact {

    private String firstname;
    private String surname;

    public Contact(String firstname) {
        this.firstname = firstname;
        surname = null;
    }

    public Contact(String firstname, String surname) {
        this.firstname = firstname;
        this.surname = surname;
    }

    public String toString() {
        return (surname == null) ? firstname : firstname + " " + surname;
    }

    String getFirstname() {
        return firstname;
    }

    String getSurname() {
        return surname;
    }
}
