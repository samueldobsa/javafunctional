package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
//        provolanie normalnej metody
        int increment = incrementByOne(1);
        System.out.println(increment);

//      provolanie Function cez .apply
        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyBy10Function.apply(increment2);
        System.out.println(multiply);

//        spojenie viacerych Function
        Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println(addBy1AndThenMultiplyBy10.apply(4));

//        BiFunction
//        normalna metoda
        System.out.println(incrementByOneAndMultiply(4, 100));

//        BiFunction
        System.out.println(incrementByOneAndMultiplyByBiFunction.apply(4,100));


    }

//    Function
//    toto je ta ista metoda ako incrementByOne
//    -> prebera na seba hodnotu alebo metodu
//    ma jeden input a jeden output, <Integer, Integer> prva je hodnota inputu a druha hodnota je outputu. Vracia aj Objekty napr. <Customer, Integer>, <Customer, String>
//    pouziva sa static kvoli tomu, ze je metoda mimo classe v ktorej sa pouziva, static metodu alebo premennu je mozne provolat bez vytvorenia objektu
    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

//    Normalna metoda
    static int incrementByOne(int number){
        return number + 1;
    }

//  BiFunction
//    Ta ista metoda ako incrementByOneAndMultiply
//    ma dva inputy a jeden output
//    (numberToIncrementByOne, numberToMultiplyBy) -> toto je lambda
//    numberToIncrementByOne, numberToMultiplyBy toto su parametre, hodnoty pre tieto parametre su <Integer, Integer, >
//    < , , Integer> tento je pro output
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyByBiFunction =
        (numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

//    Normalna metoda
    static int incrementByOneAndMultiply(int number, int numToMultiplyBy){
        return (number + 1) * numToMultiplyBy;
    }
}
