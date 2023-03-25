
package functionalinterface;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

//        Normalna metoda
        System.out.println("Normal method");
        System.out.println(isPhoneNumberValid("07000007895"));
        System.out.println(isPhoneNumberValid("070000078"));
//        Predicate Metoda
        System.out.println("Predicate Method");
        System.out.println(isPhoneNumberValidPredicate.test("07000007895"));
        System.out.println(isPhoneNumberValidPredicate.test("45547"));
//        .and spaja dve metody ktore sa otestuju cez .test
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("07003000020"));
//        .or jedna z method musi byt True, output bude true
        System.out.println(isPhoneNumberValidPredicate.or(containsNumber3).test("07000000020"));

//        BiConsumer Metoda
        System.out.println(isPhoneNumberValidBiPredicate.test("+421910126458", "Slovakia"));

    }
//    Normalna Metoda
    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }
//    Predicate Metoda
//    Predicate Metoda vracia Boolean
//    Lambda sa uchovava do premeneej isPhoneNumberValidPredicate
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("3");

//    BiPredicate Metoda
    static BiPredicate<String, String> isPhoneNumberValidBiPredicate = (phoneNUmber, state) -> phoneNUmber.startsWith("+421") && state.contains("Slovakia");
 }