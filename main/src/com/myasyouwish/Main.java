package com.myasyouwish;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        //use of Optional.*.or
        Integer value = Optional.ofNullable(5).or(() -> Optional.of(6)).get();

        //use of Optional.*.orElseThrow
        Integer value1 = Optional.ofNullable(5).orElseThrow();

        //Returns immutable List, Unmodifiable list
        var intList = List.of(1, 2, 3, 4);

        //creating map using collection factory
        var map2 = Map.of(1,"One",2,"Two");

        //creating map using collection factory
        var map = Map.ofEntries(Map.entry(1,"One"),Map.entry(2,"Two"));

        //Returns immutable List, Unmodifiable list
        var intListFromOfCopy = List.copyOf(intList);

        //intListFromOfCopy.add(5);     throws UnsupportedOperationException

        //Converting Optional into streams
        Optional.ofNullable(intListFromOfCopy).stream().forEach(System.out::println);

        //new Method count Stream
        Stream.of(1, 2, 3, 2, 1).count();

        //Use of Dropwhile, it works only on ordered streams
        Stream.of(1, 2, 3, 2, 1)
                .dropWhile(n -> n < 3)
                .forEach(System.out::println);  // [3, 2, 1]

        //Use of takewhile, it works only on ordered streams
        Stream.of(1, 2, 3, 2, 1)
                .takeWhile(n -> n < 3)
                .forEach(System.out::println);  // [1, 2]

        //using var in for loops
        for (var integer : intList) {
            System.out.print(integer);
        }

        // new methods in String API
        System.out.println( " ".isBlank());                // true
        System.out.println(" Foo Bar ".strip());          // "Foo Bar"
        System.out.println(" Foo Bar ".stripTrailing());  // " Foo Bar"
        System.out.println(" Foo Bar ".stripLeading());   // "Foo Bar "
        System.out.println("Java".repeat(3));             // "JavaJavaJava"
        System.out.println( "A\nB\nC".lines().count());    // 3
        Optional.ofNullable(intList).orElseThrow();


        //var used inside predicate and new method toUnmodifiableList used
        var newMutableList= intList.stream().map((var x) -> x*2 ).collect(Collectors.toUnmodifiableList());
        newMutableList.forEach(System.out::print);
//        newMutableList.add(5);  throws UnsupportedOperationException
    }
}
