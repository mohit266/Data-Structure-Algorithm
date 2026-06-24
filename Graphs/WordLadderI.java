package com.dsa.Graphs;

import java.util.*;

public class WordLadderI {
    public static void main(String[] args) {
        WordLadderI w = new WordLadderI();

        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        String startWord = "hit";
        String targetWord = "cog";

        System.out.println(w.wordLadderLength(startWord, targetWord, wordList));
    }

    public int wordLadderLength(String startWord, String targetWord, List<String> wordList) {
        Set<String> st = new HashSet<>(wordList);
        if (!st.contains(targetWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(startWord);
        st.remove(startWord);

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String word = q.poll();

                if (targetWord.equals(word)) {
                    return level + 1;
                }

                char[] chars = word.toCharArray();

                for (int pos = 0; pos < chars.length; pos++) {
                    char original = chars[pos];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[pos] = ch;
                        String newWord = new String(chars);
                        if (st.contains(newWord)) {
                            q.offer(newWord);
                            st.remove(newWord);
                        }
                    }
                    chars[pos] = original;
                }
            }
            level++;
        }
        return 0;
    }
}
