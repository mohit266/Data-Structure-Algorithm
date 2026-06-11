package com.dsa.JavaPrep;

import java.util.HashMap;
import java.util.Optional;

public class OptionalClass {

    public static HashMap<Integer, String> mp;

    OptionalClass(){
        mp = new HashMap<>();
        mp.put(1, "Mohit");
        mp.put(2, "Aman");
    }

    public static void main(String[] args) {
        OptionalClass o = new OptionalClass();

        Optional<String> name = o.getName(1);

        // 1.We can either use this approach or 2nd one
        if (name.isPresent()){
            System.out.println(name.get());
        }


        // 2.
        name.ifPresent(System.out::println);


        // getDefaultValue() is executed even though "Java" is present because orElse() eagerly evaluates its argument.
        // Use orElseGet() for lazy evaluation.
        Optional<String> opt =  Optional.of("Java");

        String result = opt.orElse(o.getDefaultValue());

        System.out.println(result);

    }

    public String getDefaultValue(){
        return "NA";
    }

    public Optional<String> getName(int id){
        String name = mp.get(id);
        return Optional.ofNullable(name);
    }



}
