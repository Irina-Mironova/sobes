package ru.geekbrains.lesson1.builder;

public class MainApp {
    public static void main(String[] args) {
        Person person = Person.createBuilder()
                .withFirstName("Nik")
                .withLastName("Popov")
                .withAge(22)
                .withCountry("Russia")
                .withPhone("222-333")
                .build();
        System.out.println(person.toString());
    }
}
