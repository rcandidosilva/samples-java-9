package samples;

import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalSample {

    public static void main(String[] args) {
        // OF
        Optional<String> v1 = Optional.of("a");
        System.out.println(v1.stream().map(String::toUpperCase).collect(Collectors.toList()));
        // Empty
        Optional<String> v2 = Optional.empty();
        System.out.println(v2.stream().map(String::toUpperCase).collect(Collectors.toList()));
    }
}
