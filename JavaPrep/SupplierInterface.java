package com.dsa.JavaPrep;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierInterface {
    public static void main(String[] args) {

        Supplier<Integer> supplier = () -> 1;

        System.out.println(supplier.get());

        Supplier<List<Integer>> listSupplier = () -> Arrays.asList(1, 2, 3);
        System.out.println(listSupplier.get());

    }
}
