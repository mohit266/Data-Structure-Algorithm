package com.dsa.Graphs;

import java.util.*;

public class WordLadderII {
    public static void main(String[] args) {
        String startWord = "der";
        String targetWord = "dfs";
        List<String> wordList = Arrays.asList("des", "der", "dfr", "dgt", "dfs");

        WordLadderII w = new WordLadderII();
        System.out.println(w.findLadders(startWord, targetWord, wordList));
        System.out.println(w.findSequences(startWord, targetWord, wordList));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        Set<String> st = new HashSet<>(wordList);

        Queue<List<String>> q = new LinkedList<>();
        q.offer(new ArrayList<>(Collections.singleton(beginWord)));

        st.remove(beginWord);

        int ans = 0;

        while (!q.isEmpty()){
            int size = q.size();

            List<String> newWordsLs = new ArrayList<>();

            for (int i = 0; i < size; i++){
                List<String> words = q.poll();

                String lastWord = words.get(words.size() - 1);

                if ((ans == 0 || words.size() <= ans) && endWord.equals(lastWord)){
                    ans = words.size();
                    result.add(new ArrayList<>(words));
                }

                char[] chars = lastWord.toCharArray();

                for (int pos = 0; pos < chars.length; pos++){
                    char original = chars[pos];
                    for (char ch = 'a'; ch <= 'z'; ch++){
                        chars[pos] = ch;
                        String newWord =  new String(chars);
                        if (st.contains(newWord)){
                            newWordsLs.add(newWord);
                            List<String> re = new ArrayList<>(words);
                            re.add(newWord);
                            q.offer(re);
                        }
                    }
                    chars[pos] = original;
                }
            }
            newWordsLs.forEach(st::remove);
        }

        return result;
    }

    private void dfs(String word, String beginWord, List<String> seq,
                     Map<String, Integer> mpp, List<List<String>> ans) {

        if (word.equals(beginWord)) {
            Collections.reverse(seq);
            ans.add(new ArrayList<>(seq));
            Collections.reverse(seq);
            return;
        }

        int val = mpp.get(word);

        for (int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder(word);
            for (char ch = 'a'; ch <= 'z'; ch++) {
                sb.setCharAt(i, ch);
                String newWord = sb.toString();

                if (mpp.containsKey(newWord) &&
                        mpp.get(newWord) + 1 == val) {
                    seq.add(newWord);

                    dfs(newWord, beginWord, seq, mpp, ans);

                    seq.remove(seq.size() - 1);
                }
            }
        }
    }

    public List<List<String>> findSequences(String beginWord, String endWord,
                                            List<String> wordList) {

        int len = beginWord.length();
        Set<String> st = new HashSet<>(wordList);

        Map<String, Integer> mpp = new HashMap<>();

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        st.remove(beginWord);

        int steps = 1;

        mpp.put(beginWord, steps);

        while (!q.isEmpty()) {
            String word = q.poll();
            steps = mpp.get(word);

            for (int i = 0; i < len; i++) {
                StringBuilder sb = new StringBuilder(word);

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    sb.setCharAt(i, ch);
                    String newWord = sb.toString();

                    if (st.contains(newWord)) {
                        mpp.put(newWord, steps + 1);
                        q.add(newWord);

                        st.remove(newWord);
                    }
                }
            }
        }

        if (!mpp.containsKey(endWord))
            return new ArrayList<>();

        List<List<String>> ans = new ArrayList<>();

        List<String> seq = new ArrayList<>();
        seq.add(endWord);

        dfs(endWord, beginWord, seq, mpp, ans);

        return ans;
    }
}
