package com.dsa.PatternWise.SlidingWindow.VariableWIndow;

import java.util.HashMap;

// 904. Fruit Into Baskets
public class FruitIntoBasket {

    public static void main(String[] args) {
        FruitIntoBasket f = new FruitIntoBasket();
        int[] fruits = {1,2,1};
        System.out.println(f.totalFruit(fruits));
    }


    public int totalFruit(int[] fruits) {

        HashMap<Integer, Integer> basket = new HashMap<>();

        int i = 0;
        int j = 0;

        int maxLen = 0;

        while (i <= j && j < fruits.length){
            int fruit = fruits[j];

            basket.put(fruit, basket.getOrDefault(fruit, 0) + 1);

            while (basket.size() > 2) {
                int leftFruit = fruits[i];

                basket.put(leftFruit, basket.get(leftFruit) - 1);
                if (basket.get(leftFruit) == 0){
                    basket.remove(leftFruit);
                }
                i++;
            }

            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }
        return maxLen;
    }

}
