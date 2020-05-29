package org.maximser.lab2;

import java.io.*;
import java.util.Objects;

import com.google.gson.*;

public class Person {
    private  String firstName;
    private  String secondName;
    private  double height;
    private  double weight;
    private  int age;

    public Person(String firstName, String secondName, double height, double weight, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    public void ToJson(File file) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(this);
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println(json);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static Person FromJson(File file) {
        Gson gson = new Gson();
        Person person = null;
        try {
            person = gson.fromJson(new FileReader(file), Person.class);
        } catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;

        return age == person.age
                && Double.compare(person.height, height) == 0
                && Double.compare(person.weight, weight) == 0
                && Objects.equals(firstName, person.firstName)
                && Objects.equals(secondName, person.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, height, weight, age);
    }
}
