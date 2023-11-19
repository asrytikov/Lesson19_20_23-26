package p5;

import p2.Car;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.addAll(Arrays.asList(new String[]{"Alex", "Masha", "Misha", "Katya",
                "Ivan","Tanya","Petya", "Dima", "Anton", "Marina", "Alena", "Lena", "Natasha"}));

        List<String> filterNames = names.stream().filter(s -> s.length()==4).collect(Collectors.toList());

        for (String name: filterNames){
            System.out.println(name);
        }

        Stream<Car> carStream = Stream.of(
                new Car("Kia Rio", 20_000),
                new Car("Mersedes S100", 100_000),
                new Car("Tesla XXX", 50_000)
        );

        Map<String, Integer> cars = carStream.collect(Collectors.toMap(car -> car.getModel(), car -> car.getPrice()));
        cars.forEach((k,v)-> System.out.println(k + " " + v));

        HashSet<String> fNames = names.stream().filter(s -> s.length()>4).collect(Collectors.toCollection(HashSet::new));
        fNames.forEach(System.out::println);

        System.out.println("-----------------");

        ArrayList<String> arrNames = names.stream().filter(s->s.length()>5).collect(
                ArrayList::new,
                (list, item) -> list.add(item),
                (list1, list2) -> list1.addAll(list2)
        );

        arrNames.forEach(System.out::println);


    }
}
