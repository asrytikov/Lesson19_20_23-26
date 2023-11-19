package p6;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<SCar> sCars = new ArrayList<>();
        sCars.addAll(Arrays.asList(new SCar[]{
                new SCar("Kia Rio", 20_000, "Oleg"),
                new SCar("Mersedes S100", 100_000, "Masha"),
                new SCar("Tesla XXX", 50_000, "Mask Ilon"),
                new SCar("Reno Duster", 20_000, "Masha"),
        }));

        Map<String, List<SCar>> carsByOwners = sCars.stream().collect(Collectors.groupingBy(SCar::getOwner));
        for (Map.Entry<String, List<SCar>> item : carsByOwners.entrySet()){
            System.out.println(item.getKey());
            for(SCar car : item.getValue()){
                System.out.println(car.getModel());
            }
            System.out.println();
        }

        System.out.println("------------------------");

        Map<Boolean, List<SCar>> carsByOwner = sCars.stream().collect(Collectors.partitioningBy(car->car.getOwner()=="Oleg"));
        for (Map.Entry<Boolean, List<SCar>> item : carsByOwner.entrySet()){
            System.out.println(item.getKey());
            for(SCar car : item.getValue()){
                System.out.println(car.getModel());
            }
            System.out.println();
        }

        System.out.println("------------------------");

        Map<String, Long> carsCountByOwners = sCars.stream().collect(Collectors.groupingBy(SCar::getOwner, Collectors.counting()));
        for (Map.Entry<String, Long> item : carsCountByOwners.entrySet()){
            System.out.println(item.getKey() + " " + item.getValue());
        }

        System.out.println("------------------------");

        Map<String, Integer> carsPriceByOwners = sCars.stream().collect(
                Collectors.groupingBy(SCar::getOwner, Collectors.summingInt(SCar::getPrice)));
        for (Map.Entry<String, Integer> item : carsPriceByOwners.entrySet()){
            System.out.println(item.getKey() + " " + item.getValue());
        }
        System.out.println("------------------------");

        Map<String, Optional<SCar>> carsMinPriceByOwners = sCars.stream().collect(
                Collectors.groupingBy(SCar::getOwner, Collectors.minBy(Comparator.comparing(SCar::getPrice))));

        for (Map.Entry<String, Optional<SCar>> item : carsMinPriceByOwners.entrySet()){
            System.out.println(item.getKey() + " " + item.getValue().get().getModel());
        }
        System.out.println("------------------------");

        Map<String, IntSummaryStatistics> carsSumPriceByOwners = sCars.stream().collect(
                Collectors.groupingBy(SCar::getOwner, Collectors.summarizingInt(SCar::getPrice)));

        for (Map.Entry<String, IntSummaryStatistics> item : carsSumPriceByOwners.entrySet()){
            System.out.println(item.getKey() + " " + item.getValue().getMax());
        }
        System.out.println("------------------------");

        Map<String, List<String>> carsPriceByOwnersToList = sCars.stream().collect(
                Collectors.groupingBy(SCar::getOwner, Collectors.mapping(SCar::getModel, Collectors.toList())));

        for (Map.Entry<String, List<String>> item : carsPriceByOwnersToList.entrySet()){
            System.out.println(item.getKey());

            for(String model : item.getValue()){
                System.out.println(model);
            }
        }





    }

}
