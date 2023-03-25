package functionalinterface;

import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {

        System.out.println(getDBConnectionUrL());
        System.out.println(getDBConnectionUrlSupplier.get());
        System.out.println(getListSupplier.get());

        Customer samuel = new Customer(getListSupplier.get());
        System.out.println(samuel);
        System.out.println(getListSupplier);
    }
//      Normalna Metoda
    static String getDBConnectionUrL (){
        return "jdbc://localhost:8080/student";
    }
//      Supplier metoda
//      Vracia akukolvek hodnotu - String, Integer, Object
//      Neberie ziadne argumenty a vracia akukolvek hodnotu
    static Supplier<String> getDBConnectionUrlSupplier = () -> "jdbc://localhost:8080/student";

    static Supplier<String> getListSupplier = () -> "sad";

    static class Customer{
        private final String meno;

        Customer(String meno) {
            this.meno = meno;
        }
    }

}

