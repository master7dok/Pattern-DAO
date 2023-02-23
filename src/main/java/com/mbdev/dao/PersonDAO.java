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

        people.add(new Person(++PEOPLE_COUNTER, "Tom"));
        people.add(new Person(++PEOPLE_COUNTER, "Bob"));
        people.add(new Person(++PEOPLE_COUNTER, "Mike"));
        people.add(new Person(++PEOPLE_COUNTER, "Sveta"));
        people.add(new Person(++PEOPLE_COUNTER, "Max"));
    }

    public List<Person> index(){
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNTER);
        people.add(person);
    }

    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
    }

    public void delete(int id){
        people.removeIf(p -> p.getId() ==id);
    }
}
