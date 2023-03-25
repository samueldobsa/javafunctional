package Lambdas;

import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {

//        -> = toto je lambda
//        name = toto je argument, tento name je priamo to, čo pochádza z dátového typu <String, >
        Function<String, String> upperCaseName = name -> name.toUpperCase();
//        Zjednodusena metoda
        Function<String, String> upperCaseName2 = String::toUpperCase;

//        pre pridanie logiky do Function musime pouzit {}
        Function<String,String> upperCaseName3 = name -> {
            if (name.isBlank())throw new IllegalArgumentException("samko");
            return name.toUpperCase();
        };

//        Ak chceme do Function pridat logiku je potrebne prida {}
//        <String,Integer, > su hodnoty pro parametre (name, age)
//        < , , String> hodnota pro output
        BiFunction<String,Integer, String> upperCaseName4 = (name, age) -> {
            if (name.isBlank())
                throw new IllegalStateException();
            System.out.println(name + age);
            return name.toUpperCase();
        };

//        Mozeme Function provolat takto
//        toto len zavolame metodu ale nevykona sa name.toUpperCase
        upperCaseName4.apply("Danka ", 5);

//        Takto
//        Tu sa vykona name.toUpperCase
        String uppeCase = upperCaseName4.apply("Saminek ", 20);
        System.out.println(uppeCase);

//        Aj takto
//        Tu tiez name.toUpperCase
        System.out.println(upperCaseName4.apply("Jozef ", null));

        System.out.println(upperCaseName5.apply("Hovno"));
    }
//    Static Pouziva sa na pristup k metode, premennej alebo class na provolani bez toho aby sme musli vytvorit objekt triedy v ktorej sa nachadza
    static Function<String,String> upperCaseName5 = name -> {
        if (name.isBlank())throw new IllegalArgumentException("samko");
        return name.toUpperCase();
    };

    class Service{
//        Functional programing matoda sa nastavuje pristup, nemali by byt static
        public Consumer<String> blah = s ->{

        };
    }

}
