import java.util.Objects;
import java.util.Optional;

/**
 * @author Srinivas_Chintakindhi
 */

public class Test0312 {
    public static void main(String[] args) {
//        Object object = null;
//        Object objec = new Object();
//
//        System.out.println(Objects.nonNull(objec));
//        System.out.println(Objects.nonNull(object));
//
////        Optional<Object> empty = Optional.empty();
////        System.out.println(empty.get());
//
//        Optional optional = Optional.ofNullable("srini");
//        Object get = optional.orElse("srinivas");
//
//        optional.orElseGet(()->Math.random());
//
//        try {
//            optional.orElseThrow(RuntimeException::new);
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        System.out.println(get);


        Person person = new Person("sri");
        Person personNull = null;

        String aDefault = Optional.ofNullable(personNull).map(p -> p.getName()).orElse("default");
        System.out.println("aDefault = " + aDefault);


        Optional optional = Optional.of("srini");
        Object get = optional.orElse("srinivas");
        System.out.println("get = " + get);
    }
}
