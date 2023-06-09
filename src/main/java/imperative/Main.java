package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE)
        );
        System.out.println("Imperative approach");
//        Imperative approach
        List<Person> females = new ArrayList<>();

        for (Person person : people){
            if (Gender.FEMALE.equals(person.gender)){
                females.add(person);
            }
        }
        for (Person female : females){
            System.out.println("this is " + female);
        }

        System.out.println("Declarative approach");
//        Declarative approach
//        1. moznost bez pouziti premennej
        people.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender))
                .collect(Collectors.toList())
                .forEach(System.out::println);
//        2. moznost s pouzitim premennej
        List<Person> females2 = people.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender))
                .collect(Collectors.toList());
        females2.forEach(System.out::println);
//        3. vyuzitr Predicate - vracia true/false. Ci sa rovna person FEMALE
        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);
        List<Person> females3 = people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
        females3.forEach(System.out::println);
    }

    static class Person{
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }
    }
    enum Gender{
        MALE, FEMALE
    }
}
