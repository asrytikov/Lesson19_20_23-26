package p4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(new Integer[]{1,2,3,4,5}));
        Optional<Integer> min = list.stream().min(Integer::compare);
        if (min.isPresent()){
            System.out.println(min.get());
        }
        System.out.println(min.orElse(-1));
        Random random = new Random();
        System.out.println(min.orElseGet(() -> random.nextInt(100)));

        //System.out.println(min.orElseThrow(IllegalStateException::new));

        System.out.println("Min:");
        min.ifPresent(System.out::println);

        min.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Value not found")
        );




    }
}
