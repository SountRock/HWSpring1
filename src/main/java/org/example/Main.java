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

        System.out.println(person);
        System.out.println(person.hashCode());

        Person person2 = new Person("Alex", "Hirsh", 28);
        Person person3 = new Person("Marisha", "Jiluu", 34);
        System.out.println(person.equals(person2));
        System.out.println(person.equals(person3));

        person.serialize("serialize");
    }
}