package com.dsa.JavaPrep;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class UseOfAllFunctions {
    public static void main(String[] args) {

        // Use of all four functions
        Predicate<Integer> checkIsEvenPredicate = x -> x % 2 == 0;
        Function<Integer, Integer> calResultFunction = x -> x * x;
        Consumer<Integer> consume = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 100;

        if (checkIsEvenPredicate.test(supplier.get())){
            consume.accept(calResultFunction.apply(supplier.get()));
        }
    }
}
