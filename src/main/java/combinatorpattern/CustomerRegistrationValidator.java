package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import static combinatorpattern.CustomerRegistrationValidator.*;

import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

public interface CustomerRegistrationValidator extends Function <Customer, ValidationResult> {

//    Metoda vracia SUCCESS alebo EMAIL_NOT_VALID
//    customer zoberie email. v ktorom sa musi nachadzat "@" ? ak je to true output bude succes ELSE EMAIL_NOT_VALID
//    Toto je zjednodusena metoda, nizsie je spolu s volanim cez enum Triedu
    static CustomerRegistrationValidator isEmailValid(){
        return customer -> customer.getEmail().contains("@") ?
                SUCCESS : EMAIL_NOT_VALID;
    }

//    static CustomerRegistrationValidator isEmailValid(){
//        return customer -> customer.getEmail().contains("@") ?
//                ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID;
//    }

    static CustomerRegistrationValidator isPhoneNumberValid(){
        return customer -> customer.getPhoneNumber().startsWith("+0") ?
                SUCCESS : kkt;
    }

//      -> oddeluje parameter od tela metody (parameter) -> {body}
    static CustomerRegistrationValidator isAdult(){
        return (customer) -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ?
                SUCCESS : IS_NOT_AN_ADULT;
    }

//    this.apply aplikuje customera a output je enum ValidationResult premenna result v ktorom je customer a potom
//    tento enum result porovna ci sa rovna succes a aktualnou velidaciou v metode do ktorej sme aplikovali customera
//    ked bude true ide dalej ak nie vrati iny enum z metody

    default CustomerRegistrationValidator combinatorValid (CustomerRegistrationValidator other){
        return customer -> {
           ValidationResult result = this.apply(customer);
           return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }


    enum ValidationResult{
        SUCCESS,
        kkt,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }
}
