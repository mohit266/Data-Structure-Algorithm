package com.dsa.StackAndQueues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        //
        int[] arr= {1, 3, 2, 4};
        //Output: [3, 4, 4, -1]

        int[] nums1= {4,1,2};
        int[] nums2= {1,3,4,2};


        System.out.println(Arrays.toString(nextLargerElement(arr)));
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    public static int[] nextLargerElement(int[] arr) {

        if(arr.length == 0) return new int[]{-1};

        int len = arr.length;
        int[] newArr = new int[len];

        Stack<Integer> st = new Stack<>();

        for (int i = len-1; i >= 0; i--){
            if (!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }

            if (st.isEmpty()){
                newArr[i] = -1;
            } else {
                newArr[i] = st.peek();
            }
            st.push(arr[i]);

        }
        return newArr;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            int nextGreater = st.isEmpty() ? -1 : st.peek();
            map.put(nums2[i], nextGreater);

            st.push(nums2[i]);
        }

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}
