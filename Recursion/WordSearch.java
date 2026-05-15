package com.dsa.Recursion;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board =   { {'A', 'B', 'C', 'E'} , {'S' ,'F' ,'C' ,'S'} , {'A', 'D', 'E', 'E'} };
        String word = "SEE";

        System.out.println(exist(board,word));
    }

    public static boolean exist(char[][] board, String word) {
        int rowLen = board.length;
        int colLen = board[0].length;

        for (int row = 0; row < rowLen; row++){
            for (int col = 0; col < colLen; col++){
                if (board[row][col] == word.charAt(0)){
                    boolean res = backTrackWords(0, row, col, rowLen, colLen, board, word);
                    if (res){
                        return true;
                    }
                }
            }
        }

        return false;

    }

    public static boolean backTrackWords(int index, int row, int col, int rowLen, int colLen, char[][] board, String word){
        if (index == word.length()){
            return true;
        }

        if (row < 0 || col < 0 || row >= rowLen || col >= colLen  || word.charAt(index) != board[row][col]) {
            return false;
        }

        char c = board[row][col];
        board[row][col] = ' ';

        boolean ans = backTrackWords(index + 1, row - 1, col, rowLen, colLen, board, word) ||
                backTrackWords(index + 1, row + 1, col, rowLen, colLen, board, word) ||
                backTrackWords(index + 1, row, col + 1, rowLen, colLen, board, word) ||
                backTrackWords(index + 1, row, col - 1, rowLen, colLen, board, word);

        board[row][col] = c;
        return ans;
    }
}
