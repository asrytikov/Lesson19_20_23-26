package p2;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.addAll(Arrays.asList(new String[]{"Alex", "Masha", "Misha", "Katya",
                "Ivan","Tanya","Petya", "Dima", "Anton", "Marina", "Alena", "Lena", "Natasha"}));

        System.out.println(names.stream().count());
        System.out.println(names.stream().filter(n->n.length()>4).count());
        System.out.println(names.stream().findFirst().get());
        System.out.println(names.stream().findAny().get());
        System.out.println(names.stream().anyMatch(s -> s.length()>4));
        System.out.println(names.stream().allMatch(s -> s.length()>3));
        System.out.println(names.stream().noneMatch(s -> s=="Vlad"));

        IntStream intStream = Arrays.stream(new int[]{-5, -10, 2, 0, 10, 20, 30, -66, -90, 100});

        OptionalInt min = intStream.min();
        System.out.println(min.getAsInt());

        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(new Integer[]{-5, -10, 2, 0, 10, 20, 30, -66, -90, 100}));

        Optional<Integer> minList = list.stream().min(Integer::compare);
        System.out.println(minList.get());
        Optional<Integer> maxList = list.stream().max(Integer::compare);
        System.out.println(maxList.get());


        ArrayList<Car> cars = new ArrayList<>();
        cars.addAll(Arrays.asList(new Car[]{
                new Car("Kia Rio", 20_000),
                new Car("Mersedes S100", 100_000),
                new Car("Tesla XXX", 50_000)
        }));


        Car minPriceCar = cars.stream().min(Car::compare).get();
        Car maxPriceCar = cars.stream().max(Car::compare).get();
        System.out.printf("Min price car: %s Price: %d\n", minPriceCar.getModel(), minPriceCar.getPrice());
        System.out.printf("Max price car: %s Price: %d\n", maxPriceCar.getModel(), maxPriceCar.getPrice());






    }
}
