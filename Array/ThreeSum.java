package com.dsa.Array;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {0, -2, -2, -1, 0, -2, -1, -2, 0, 2, 2, 2, -1};
        System.out.println(threeSum(arr));
        System.out.println(threeSumBetterApproach(arr));

    }


    /*

       Time Complexity: O(NlogN)+O(N2)

       Space Complexity: O(no. of quadruplets). This space is only used to store the answer.
       We are not using any extra space to solve this problem. So, from that perspective,
       space complexity can be written as O(1).

     */
    // Optimal Solution
    public static List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i=0; i < n; i++){

            if (i > 0 && nums[i] == nums [i-1]) continue;

            int j = i+1;
            int k = n-1;
            int sum;

            while (j < k){
                sum = nums[i] + nums[j] + nums[k];

                if (sum < 0){
                    j++;
                }

                if (sum > 0){
                    k--;
                }

                if (sum == 0){
                    List<Integer> ls = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(ls);
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j-1]) j++;
                    while (j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return ans;
    }


    /* Time Complexity: O(N2 * log(no. of unique triplets)),
       Space Complexity: O(2 * no. of the unique triplets) + O(N)
        as we are using a set data structure and a list to store
        the triplets and extra O(N) for storing the array elements in another set.
    */
    public static List<List<Integer>> threeSumBetterApproach(int[] nums) {
        int n = nums.length;

        // Store unique triplets
        Set<List<Integer>> ans = new HashSet<>();
        for (int i =0; i<n; i++){
            Set<Integer> st = new HashSet<>();
            for (int j = i+1; j < n; j++){
                /*
                    nums[i] + nums[j] + nums[k] = 0
                    nums[k] = - nums[i] - nums[j]
                    nums[k] = - (nums[i] + nums[j])
                 */
                int third = -(nums[i] + nums[j]);
                if (st.contains(third)){
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(temp);
                    ans.add(temp);
                }
                st.add(nums[j]);
            }
        }
        return new ArrayList<>(ans);
    }


}
