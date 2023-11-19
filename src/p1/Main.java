package p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        IntStream intStream = Arrays.stream(new int[]{-5, -10, 2, 0, 10, 20, 30, -66, -90, 100});
        intStream.skip(2).limit(5).forEach(System.out::println);

        List<String> names = new ArrayList<>();
        names.addAll(Arrays.asList(new String[]{"Alex", "Masha", "Misha", "Katya",
                "Ivan","Tanya","Petya", "Dima", "Anton", "Marina", "Alena", "Lena", "Natasha"}));
        int pageSize = 5;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Input page number: ");
            int page = scanner.nextInt();
            if (page<1) break;
            names.stream().skip((page-1)*pageSize).limit(pageSize).forEach(System.out::println);
        }

    }
}