package finalsection;

import java.util.function.Consumer;

public class MainF {
    public static void main(String[] args) {

//        Calling the hello() method and declaring a Consumer variable whose value is sout
        hello("John", null, value -> {
            System.out.println("no lastName provided for " + value);
        });

//        provolanie metody Runnable, nema ziadny Parameter
        hello2("John", null, () -> {
            System.out.println("no last name provided");
        });

    }

//    connection of normal method and Consumer funckcie
//    Consumer ma parameter fistName
    static void hello(String firstName, String lastName, Consumer<String> callBack){
        System.out.println(firstName);
        if (lastName != null){
            System.out.println(lastName);
        }else {
            callBack.accept(firstName);
        }
    }
//      use Runnable, Runnable has no parameter
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
