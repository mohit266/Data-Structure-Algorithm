package com.dsa.Recursion;

import java.util.*;

class NQueen {

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        int n = 4;
        System.out.println(nQueen.solveNQueens(n));
    }


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        List<String> board = new ArrayList<>();

        for (int i = 0; i < n; i++){
            board.add(".".repeat(n));
        }

        // boards = ["....", "....", "....","...."]

        func(0, board, ans);

        return ans;


    }

    public void func(int row, List<String> board, List<List<String>> ans){
        if (row == board.size()){
            ans.add(new ArrayList<>(board));
            return;
        }

        for (int col = 0; col < board.get(0).length(); col++){
            if (isSafeToPlaceQueen(row,col, board)){
                char[] arr = board.get(row).toCharArray();
                arr[col] = 'Q';

                board.set(row, new String(arr));
                func(row + 1, board, ans);
                arr[col] = '.';
                board.set(row, new String(arr));
            }
        }
    }

    public boolean isSafeToPlaceQueen(int row, int col, List<String> board){
        int r = row;
        int c = col;

        while (r >= 0 && c >= 0){
            if (board.get(r).charAt(c) == 'Q') return false;
            r--;
            c--;
        }

        r = row;
        c = col;

        while (r >=0){
            if(board.get(r).charAt(c) == 'Q') return false;
            r--;
        }

        r = row;

        while (r >= 0 && c < board.get(row).length()){
            if (board.get(r).charAt(c) == 'Q') return false;
            r--;
            c++;
        }
        return true;
    }


}
