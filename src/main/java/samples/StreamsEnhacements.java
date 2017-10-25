package samples;

import java.util.List;
import java.util.stream.IntStream;

public class StreamsEnhacements {

    public static void main(String[] args) {

        IntStream.iterate(2, x -> x < 1000, x -> x * x)
                .forEach(System.out::println);

        List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .stream()
                .takeWhile(l -> l < 6)
                .forEach(System.out::println);

        List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .stream()
                .dropWhile(l -> l < 6)
                .forEach(System.err::println);

    }

}