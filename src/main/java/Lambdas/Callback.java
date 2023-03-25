package Lambdas;

import java.util.function.Consumer;

public class Callback {
    public static void main(String[] args) {

        //        Zavolanie metody hello() a deklarovane premenne a Consumer ktoreho hodnota value je sout
        hello("John", null, value -> {
            System.out.println("no lastName provided for " + value);
        });

//        provolanie metody Runnable, nema ziadny Parameter
        hello2("John", null, () -> {
            System.out.println("no last name provided");
        });

    }
    //    spojenie normalnej metody a Consumer funckcie
//    Consumer ma parameter fistName
    static void hello(String firstName, String lastName, Consumer<String> callBack){
        System.out.println(firstName);
        if (lastName != null){
            System.out.println(lastName);
        }else {
            callBack.accept(firstName);
        }
    }
    //      pouzitie Runnable, Runnable nema ziadny parameter
    static void hello2(String firstName, String lastName, Runnable callBack){
        System.out.println(firstName);
        if (lastName != null){
            System.out.println(lastName);
        }else {
            callBack.run();
        }
    }
//    function hello(firstName, lastName, callBack){
//        console.log(firstName);
//        if (firstName){
//            console.log(lasName);
//        }else {
//            callBack;
//        }
//    }
}
