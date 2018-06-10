package funprog.techprimers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * FlatMap and Optional Example.
 * <p>
 * <b>Problem Statement:</b>
 * There is a List of Users, with each User containing list of numbers.
 * Need to find number 5.
 *
 * @author Akash Patra
 */
public class FlatMapOptExample {

    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User("Peter", 20, Arrays.asList("1", "2", "3")),
                new User("Sam", 25, Arrays.asList("4", "5")),
                new User("Ryan", 60, Arrays.asList("6", "7")));

        System.out.println("Imperative Style");

        List<String> mobileNosI;
        for (User user : users) {
            mobileNosI = user.getPhoneNumbers();
            for (String mob : mobileNosI) {
                if (mob.equals("5")) {
                    System.out.println(mob);
                    break;
                }
            }
        }

        System.out.println("\nFunctional Style");

        Optional<String> result = users.stream()
                .map(user -> user.getPhoneNumbers().stream())
                .flatMap(numbersStream -> numbersStream.filter(number -> number.equals("5")))
                .findAny();

        result.ifPresent(System.out::println);
    }

    static class User {
        private String name;
        private Integer age = 30;
        private List<String> phoneNumbers;

        public User(String name, Integer age, List<String> phoneNumbers) {
            this.name = name;
            this.age = age;
            this.phoneNumbers = phoneNumbers;
        }

        public List<String> getPhoneNumbers() {
            return phoneNumbers;
        }
    }
}
