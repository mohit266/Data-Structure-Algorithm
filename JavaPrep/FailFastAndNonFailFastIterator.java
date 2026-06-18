package com.dsa.JavaPrep;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastAndNonFailFastIterator {
    public static void main(String[] args) {

        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);

        Iterator<Integer> itr = ls.iterator();

        while(itr.hasNext()){
            // This line of code will throw exception bcz we are doing structural changes in the list.
            ls.remove(2);
            System.out.println(itr.next());

            // Correct approach is to remove using itr method.
//            Integer val = itr.next();
//
//            if (val == 2){
//                itr.remove();
//            }
        }
        ls.forEach(System.out::println);


        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        Iterator<Map.Entry<String, Integer>> cItr = map.entrySet().iterator();
        map.put("D", 1);

        while(cItr.hasNext()){
            System.out.println(cItr.next());
        }

        CopyOnWriteArrayList<Integer> cp = new CopyOnWriteArrayList<>();
        cp.add(1);
        cp.add(2);
        cp.add(3);

        Iterator<Integer> cpItr = cp.iterator();
        cp.add(4);

        while (cpItr.hasNext()){
            System.out.println(cpItr.next());
        }

    }

}
