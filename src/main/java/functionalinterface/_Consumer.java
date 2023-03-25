package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {

        Customer samuel = new Customer("Samuel", "0910126458");

//        Consumer ->

//        Classic Method
        greetCustomer(new Customer("SAMUEL", "8888888"));
//        Consumer Functional interface
        greetCustomerConsumer.accept(new Customer("Maria", "45875"));

//        BiConsumer  ->

//        BiConsumer Function
        greetCustomerConsumerV2.accept(samuel, false);
//        Normal Method
        greetCustomerV2(samuel, true);
    }

//        Consumer Function
//        has one input and no output - Consumer is like void
    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName + " thanks for registering phone number " + customer.customerName);

//        Normal Method
    static void greetCustomer(Customer customer){
        System.out.println("Hello " + customer.customerName + " thanks for registering phone number " + customer.customerPhoneNumber);
    }

//    BiConsumer Function
//    has two inputs and one output
//    when there are two arguments, it is necessary to put in closures
//    (showPhoneNumber ? customer.customerPhoneNumber : "*****") znamena: ak chce ukazat cislo tak sa ukaze cislo else sa vypisu hviezdicky
    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName + " thanks for registering phone number " + (showPhoneNumber ? customer.customerPhoneNumber : "*****"));

//    Normalna metoda
    static void greetCustomerV2(Customer customer, boolean showPhoneNumber){
        System.out.println("Hello " + customer.customerName + " thanks for registering phone number " + (showPhoneNumber ? customer.customerPhoneNumber : "*******"));
    }

    static class Customer{

        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
