package p7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1,2,3,4,5,6);
        System.out.println(integerStream.parallel().reduce((x,y)->x*y).get());

        List<String> names = Arrays.asList("Alex", "Masha", "Misha", "Katya",
                "Ivan","Tanya","Petya", "Dima", "Anton", "Marina", "Alena", "Lena", "Natasha");
        System.out.println("1 line");
        names.stream().filter(name -> name.length()>4).forEach(System.out::println);

        System.out.println("Many line");
        names.parallelStream().filter(name -> name.length()>4).forEach(System.out::println);
    }

}
