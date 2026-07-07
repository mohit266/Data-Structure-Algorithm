package com.dsa.Graphs;

import java.util.*;
import java.util.stream.IntStream;

public class AccountMerge {

    public static void main(String[] args) {
        List<List<String>> accounts = Arrays.asList(
                Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"),
                Arrays.asList("John","johnsmith@mail.com","john00@mail.com"),
                Arrays.asList("Mary","mary@mail.com"),
                Arrays.asList("John","johnnybravo@mail.com")
        );

        AccountMerge acc = new AccountMerge();
        System.out.println(acc.accountsMerge(accounts));
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        DisjointSet ds = new DisjointSet(n);

        HashMap<String, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++){
            List<String> at = accounts.get(i);

            for (int j = 1; j < at.size(); j++){

                if (!mp.containsKey(at.get(j))){
                    mp.put(at.get(j), i);
                } else {
                    ds.unionBySize(i, mp.get(at.get(j)));
                }
            }
        }

        List<List<String>> mailIds = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> mailIds.add(new ArrayList<>()));

        for (Map.Entry<String, Integer> entry : mp.entrySet()){
            String mails = entry.getKey();
            int node = ds.findParent(entry.getValue());

            mailIds.get(node).add(mails);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++){

            if (mailIds.get(i).isEmpty()){
                continue;
            }

            Collections.sort(mailIds.get(i));
            List<String> res = new ArrayList<>();
            res.add(accounts.get(i).get(0));
            res.addAll(mailIds.get(i));

            ans.add(res);
        }
        ans.sort(Comparator.comparing(list -> list.get(0)));
        return ans;
    }
}

