package optionals;

import java.util.Optional;

public class _Optional {

    public static void main(String[] args) {

//        Optional metody beru inputy metody napr. Function, Supplier, Predicate
//        Tato metoda berie ako input Supplier,teda neberia ziadne agrumenty a dava hodnotu
//        .orElseThrow berie Supplier, teda nema ziadne vstupne argumenty
        Object value = Optional.ofNullable("null")
                .orElseThrow(() -> new IllegalStateException("Exception, you must check box"));

        System.out.println(value);

//        .isPresent berie Consumer, teda vracia boolean
        Optional.ofNullable("ifPresent")
                .ifPresent(value2 -> {
                    System.out.println(value2);
                });
//        Zjednodusena metoda vyssie - prerobena do Functional programing
        Optional.ofNullable("lambda")
                .ifPresent(System.out::println);

        Optional.ofNullable(null)
                .ifPresentOrElse(email -> System.out.println("Sending email to " + email),
                        () -> System.out.println("Cannot send email")
                );

    }
}
