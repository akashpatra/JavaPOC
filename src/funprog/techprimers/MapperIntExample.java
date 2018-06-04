package funprog.techprimers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * MapToInt and sum Example
 *
 * @author Akash Patra
 */
public class MapperIntExample {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Peter", "Sam", "Greg", "Ryan");

        System.out.println("Imperative Style");

        List<User> usersI = new ArrayList<>();
        User user;
        int sumI = 0;
        for (String name : names) {
            if (isNotSam(name)) {
                user = new User(name);
                usersI.add(user);
                System.out.println(user);
                sumI += user.getAge();
            }
        }
        System.out.println("Sum of Ages: " + sumI);

        System.out.println("\nFunctional Style");

        names.stream()
                .filter(MapperIntExample::isNotSam)
                .map(User::new)
                .forEach(System.out::println);

        List<User> users = names.stream()
                .filter(MapperIntExample::isNotSam)
                .map(User::new)
                .collect(Collectors.toList());

        int sum = users.stream()
                .mapToInt(new ToIntFunction<User>() {
                    @Override
                    public int applyAsInt(User user) {
                        return user.getAge();
                    }
                })
                .sum();

        System.out.println("Sum of Ages: " + sum);
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

        public Integer getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Age: " + age;
        }
    }
}
