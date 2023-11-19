package p3;

import p2.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(-5, -10, 2, 10, 20, 30, -66, -90, 100);
        Optional<Integer> res = integerStream.reduce((x,y) -> x*y);
        System.out.println(res.get());

        Stream<String> words = Stream.of("I", "love", "Java");
        System.out.println(words.reduce((x, y) -> x + " " + y).get());

        Stream<Integer> numbers = Stream.of(1,2,3);
        int result = numbers.reduce(100, (x, y) -> x+y);
        System.out.println(result);

        ArrayList<Car> cars = new ArrayList<>();
        cars.addAll(Arrays.asList(new Car[]{
                new Car("Kia Rio", 20_000),
                new Car("Mersedes S100", 100_000),
                new Car("Tesla XXX", 50_000)
        }));

        int sum = cars.stream().reduce(0, (x, y) ->{
            if (y.getPrice()<60_000)
                return x+y.getPrice();
            else
                return x + 0;
        }, (x, y) -> x + y);

        System.out.println(sum);
    }
}
