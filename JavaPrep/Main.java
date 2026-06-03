package com.dsa.JavaPrep;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // List or collection --> Interface
        // We can create object of ArrayList in three type.

        // 1. Because collection is root interface and ArrayList implements List interface so  all its
        // method implementation is present.
        Collection<Integer> cl = new ArrayList<>();

        // 2. List extends Collection interface.
        List<Integer> ls = new ArrayList<>();

        // 3. ArrayList is a class which implements List interface.
        ArrayList<Integer> list = new ArrayList<>();

        // add
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list);

        // size
        System.out.println(list.size());

        // remove the value at given index
        list.remove(0);
        System.out.println(list);

        // addAll -> add all the elements of list2 into list
        List<Integer> list2 = new ArrayList<>();
        list2.add(101);
        list2.add(102);

        list.addAll(list2);
        System.out.println(list);

        // removeAll -> remove all the elements of list2 from list.
        list.removeAll(list2);
        System.out.println(list);

        // clear
        list2.clear();

        // Iterator : Travel list
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        list.add(6);
        list.add(1);
        list.add(10);

        // Sort - Ascending Order
        Collections.sort(list);
        System.out.println(list);

        // Sort - Descending Order
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

    }
}
