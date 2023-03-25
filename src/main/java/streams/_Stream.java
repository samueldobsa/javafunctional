package streams;

import imperative.Main;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static streams._Stream.Gender.FEMALE;
import static streams._Stream.Gender.MALE;

public class _Stream {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Alice", FEMALE)
        );
        System.out.println("Stream");
//        This is a data stream of the following method
//        This method has input <Person, > and output < ,String>
        Function<Person, String> personStringFunction = person -> person.name;

//        This function has input <String> and output Integer
        ToIntFunction<String> lenght = String::length;
//        Tato funkcie ma input Integer a len ho vypise
//        System.out::println toto je toto x -> System.out.println()
        IntConsumer pritln = System.out::println;
        people.stream()
                .map(personStringFunction)
                .mapToInt(lenght)
                .forEach(pritln);

//        Toto je Stream tak ako sa ma pisat
//        Kazda metoda ma inaci vstupne metody ako napr. Function, Consumer, Supplier, Predicate
        people.stream()
                .map(person -> person.name)
                .mapToInt(person -> person.length())
                .forEach(System.out::println);

//        stream zmapoval vsetky mena, ktore sa nachadzaju v Liste people a vypisal ich
        System.out.println("All name");
        people.stream()
                .map(person -> person.name)
                .forEach(System.out::println);
//          Stream zmapoval vsetky pohlavia, ktore su v Liste a vdaka Collectors.toSet len vypisal, ktore sa tam nachadzaju ale neduplikoval ich
        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        long countOfPeople = people.stream().count();
        System.out.println(countOfPeople);

        people.stream()
                .map(person -> person.name)
                .mapToInt(name -> name.length())
                .forEach(System.out::println);

//        Hladanie Gender FEMALE v Liste
//        Musi sa zhodovat aspon jedno
        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        boolean containsOnlyFemales = people.stream()
                .anyMatch(personPredicate);

        System.out.println(containsOnlyFemales);

//        Cela logika vyssie v jednej metode
//        .allMatch musi sa zhodovat vsetko
        boolean containsOnlyFemales2 = people.stream()
                .noneMatch(person -> FEMALE.equals(person.gender));
        System.out.println(containsOnlyFemales2);



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
