package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Mains {
    public static void main(String[] args) {
        Customer customer = new Customer("Samuel", "dobsa@samuel", "+04585651555", LocalDate.of(2000, 01, 05));

//       Combinator pattern je spajanie viac funkcii dokopy
//       Combinator pattern berie ine metody ako argument a vracia novu metodu
        System.out.println(new CustomerValidatorService().isValid(customer));

//        Mozeme ulozit customer do DB ak je Valid

//    pouzitie Combinator pattern
//    Pouzitie importu CustomerRegistrtionValidator
        ValidationResult result = isEmailValid()
                .combinatorValid(isPhoneNumberValid())
                .combinatorValid(isAdult())
                .apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }

//        CustomerRegistrationValidator.isEmailValid()
//                .and(CustomerRegistrationValidator.isPhoneNumberValid())
//                .and(CustomerRegistrationValidator.isAdult());


    }

}
