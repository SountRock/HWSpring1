package org.example;

import com.google.gson.Gson;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.*;

/**
 * Класс описывающий персону
 */
public class Person {
    private String firstName;
    private String lastName;
    private int age;

    private static Gson gson = new Gson();
    private static int countPersons = 0;
    private int countPerson;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

        countPerson = countPersons++;
    }

    @Override
    public int hashCode() {
        return (-1) * new HashCodeBuilder(15, 25).
                append(firstName).
                append(lastName).
                append(age).
                toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Person)){
            return false;
        }

        Person that = (Person) obj;
        return new EqualsBuilder()
                .append(this.firstName, that.firstName)
                .append(this.lastName, that.lastName)
                .append(this.age, that.age)
                .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).
                append("first name", firstName).
                append("last name", lastName).
                append("age", age).
                toString();
    }

    /**
     * Метод для сериализации Персоны в файл json. С возможность указать директорию для размещения файла.
     * @param directory
     */
    public void serialize(String directory) {
        File repo = new File(directory);
        repo.mkdirs();

        repo = new File(directory, "person" + countPerson + ".json");
        try(FileWriter fw = new FileWriter(repo)) {
            String temp = gson.toJson(this, Person.class);
            fw.write(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод для десериализации Персоны из файла json.
     * @param directory
     * @param fileName
     * @return deserializePerson
     */
    public static Person deserialize(String directory, String fileName) {
        File repo = new File(directory, fileName + ".json");
        try(BufferedReader fw = new BufferedReader(new FileReader(repo))) {
            String json = fw.readLine();
            System.out.println(json);
            return gson.fromJson(json, Person.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Получить Имя Персоны
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Сменить Имя персоны
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Получить Фамилию Персоны
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Сменить Фамилию персоны
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Получить Возраст Персоны
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Сменить Возраст персоны
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }
}
