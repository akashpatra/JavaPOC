package funprog.techprimers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Fetching data in streams, converting to another object and storing in a collection.
 *
 * @author Akash Patra
 */
public class MapperExample {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Peter", "Sam", "Greg", "Ryan");

        System.out.println("Imperative Style");

        List<User> usersI = new ArrayList<>();
        User user;
        for (String name : names) {
            if (isNotSam(name)) {
                user = new User(name);
                usersI.add(user);
                System.out.println(user);
            }
        }

        System.out.println("\nFunctional Style");

        names.stream()
                .filter(MapperExample::isNotSam)
                .map(User::new)
                .forEach(System.out::println);

        // TODO: Find a way to Print the object in this only
        List<User> users = names.stream()
                .filter(MapperExample::isNotSam)
                .map(User::new)
                .collect(Collectors.toList());
    }

    private static boolean isNotSam(String name) {
        return !"Sam".equals(name);
    }

    static class User {
        private String name;
        private Integer age = 30;

        public User(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Age: " + age;
        }
    }
}
