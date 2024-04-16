package org.example;

import com.google.gson.Gson;

import java.awt.*;
import java.time.LocalDate;

//1. Создайте новый Maven или Gradle проект, через Intellj IDEA.
//2. Добавьте зависимости org.apache.commons:commons-lang3:3.14.0 и com.google.code.gson:gson:2.10.1.
//3. Создайте класс Person с полями firstName, lastName и age.
//4. Используйте библиотеку commons-lang3 для генерации методов toString, equals и hashCode.
//5. Используйте библиотеку gson для сериализации и десериализации объектов класса Person в формат JSON.
public class Main {
    public static void main(String[] args) {
        Person person = new Person("Alex", "Hirsh", 28);

        System.out.println("toString: " + person);
        System.out.println("hashCode: " + person.hashCode());

        Person person1 = new Person("Alex", "Hirsh", 28);
        Person person2 = new Person("Marisha", "Jiluu", 34);

        System.out.println("person: " + person);
        System.out.println("person1: " + person1);
        System.out.println("person2: " + person2);
        System.out.println("person and person1 equals: " + person.equals(person1));
        System.out.println("person and person2 equals: " + person.equals(person2));

        person1.serialize("serialize");

        System.out.println("deserialize person1: " + Person.deserialize("serialize", "person1"));
    }
}