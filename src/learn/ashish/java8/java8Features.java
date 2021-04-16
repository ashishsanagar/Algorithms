package learn.ashish.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author Ashish Sanagar
 */
public class java8Features {

    public static void main(String[] args) {
        //forEach();
        streams();
    }

    private static void streams() {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(10);
        list.add(11);

        List<Integer> newList = list.stream().filter(element -> element > 10).collect(Collectors.toList());

        newList.forEach(a -> System.out.println(a));

        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("jacka", 40)
        );

        String name = persons.stream().filter(person -> person.name.contains("jack")).map(Person::getName).findAny().orElse("").replace("a", "new");
        System.out.println("Name: " + name);

    }

    /**
     * foreach - Java 8 has introduced forEach method in java.lang.Iterable interface
     */
    private static void forEach() {
        List<Integer> sampleIntList = new ArrayList<Integer>();
        for (int i = 0; i < 15; i++) sampleIntList.add(i);

        sampleIntList.forEach(new Consumer<Integer>() {
            public void accept(Integer value) {
                System.out.println("value: " + value);
            }
        });

        sampleIntList.forEach(System.out::println);
    }

    public static class Person {
        private String name;
        private int id;

        public Person(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
