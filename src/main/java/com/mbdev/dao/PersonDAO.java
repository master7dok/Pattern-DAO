package com.mbdev.dao;

import com.mbdev.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;

    private static int PEOPLE_COUNTER;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNTER, "Tom", 24, "tom@gmail.com"));
        people.add(new Person(++PEOPLE_COUNTER, "Bob", 22, "Bob@gmail.com"));
        people.add(new Person(++PEOPLE_COUNTER, "Mike" ,25, "Mike@gmail.com"));
        people.add(new Person(++PEOPLE_COUNTER, "Sveta", 26, "Sveta@gmail.com"));
        people.add(new Person(++PEOPLE_COUNTER, "Max", 27, "Max@gmail.com"));
    }

    public List<Person> index(){
        return people;
    }
    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNTER);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}