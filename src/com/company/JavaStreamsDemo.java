package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamsDemo {

    private static void printAnArrayList(){
        System.out.println("***************** Print An Array List ***********************");
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        System.out.println("**********************************************************");
    }

    private static void sortListOfIntegers(){
        System.out.println("***************** Sort List of Integers ***********************");

        List<Integer> myList = Arrays.asList(4,34,3,2,12,1);
        System.out.println(myList);

        myList = myList
                .stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(myList);

        System.out.println("**********************************************************");
    }

    private static void  printExtraLines(int n){
        IntStream.range(0,n).forEach( k -> System.out.println(""));
    }

    private static void findFirstElementInList(){

        System.out.println("************************* Find First Element in List *********************************");

        List<Integer> myList = Arrays.asList(4,34,3,2,12,1);
        System.out.println(myList);

        myList
                .stream()
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("**********************************************************");
    }



    private static void findElementByValue(){

        System.out.println("************************* Find Element By Value *********************************");

        List<Integer> myList = Arrays.asList(4,34,3,2,12,1);
        System.out.println(myList);

        myList
                .stream()
                .filter(x -> x == 34).collect(Collectors.toList()).stream().forEach(x-> System.out.println(x));

        System.out.println("**************************************************************************************");
    }


    private static void createAListFromStream(){
        System.out.println("********************************* Create List from Stream *****************************************************");
        List<Integer> mylist = Stream.of(1,2,3,4).collect(Collectors.toList());
        System.out.println(mylist);
        System.out.println("**************************************************************************************");
    }

    private static void findAverage(){
        System.out.println("********************************** Find Average ****************************************************");
        Arrays.stream(new int[] {1, 2, 3})
                .average()
                .ifPresent(System.out::println);
        System.out.println("**************************************************************************************");
    }



    private static void findMaximum(){
        System.out.println("********************************** Find Maximum ****************************************************");
        Arrays.stream(new int[] {1, 2, 3})
                .max()
                .ifPresent(System.out::println);
        System.out.println("**************************************************************************************");
}


    private static void parseIntegersAndFindMinimumInteger(){
        System.out.println("*********************************  parseIntegersAndFindMinimumInteger  *****************************************************");
        Stream.of("A11", "B22", "C32", "D41")
                .map(x-> x.substring(1))
                .mapToInt(Integer::parseInt)
                .min()
                .ifPresent(System.out::println);
        System.out.println("**************************************************************************************");
    }




    private static void findSquareOfListElements(){
        System.out.println("************************************* findSquareOfListElements *************************************************");
        List<Integer> mylist = Arrays.asList(1,2,3,4,5);
        System.out.println(mylist);

        mylist = mylist.stream().map(x->x*x).collect(Collectors.toList());
        System.out.println(mylist);
        System.out.println("**************************************************************************************");
    }

    private static void mapDoubleToIntAndIntToStringStream(){

    Stream.of(1.0,2.0,3.0)
                .mapToInt(Double::intValue)
                .mapToObj(x-> "a" + x)
                .forEach(x-> System.out.println(x));
    }


    private static void filterAndForeEachExecutionPattern(){

        System.out.println("********************************** filterAndForeEachExecutionPattern ****************************************************");

        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: " + s));


        System.out.println("The order of the result might be surprising. A naive approach would be to execute the operations horizontally one after another on all elements of the stream. But instead each element moves along the chain vertically. The first string \"d2\" passes filter then forEach, only then the second string \"a2\" is processed.");
        System.out.println("**************************************************************************************");


        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s));

        System.out.println("here for each is called once, map and filter are called ");

    }



    public static void main(String[] args) {
        printAnArrayList();
        printExtraLines(1);
        sortListOfIntegers();
        findFirstElementInList();
        findElementByValue();
        printExtraLines(1);
        createAListFromStream();
        printExtraLines(1);
        findAverage();
        printExtraLines(1);
        findSquareOfListElements();
        printExtraLines(1);
        findMaximum();
        printExtraLines(1);
        parseIntegersAndFindMinimumInteger();
        printExtraLines(1);
        mapDoubleToIntAndIntToStringStream();
        printExtraLines(1);
        filterAndForeEachExecutionPattern();
    }
}
