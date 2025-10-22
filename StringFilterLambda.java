package sectionb;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * StringFilterLambda
 * -------------------
 * Filters strings shorter than 5 chars, converts remaining to uppercase using Stream API.
 */
public class StringFilterLambda {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "lambda", "code", "expression", "api");

        List<String> result = words.stream()
                .filter(s -> s.length() >= 5)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
