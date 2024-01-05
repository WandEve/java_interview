package org.example;

public class Solusion {
    private final static int[][] next = {{0,-1},{0,1},{-1,0},{1,0}};
    private int rows;
    private int cols;

    public boolean hasPath(String val, int rows, int cols,String path){
        if(rows == 0 || cols == 0) {
            return false;
        }
        this.rows = rows;
        this.cols = cols;
        char[] array = val.toCharArray();
        char[][] matrix = buildMatrix(array);
        return false;

    }
    private char[][] buildMatrix(char[] array){
        char[][] matrix = new char[rows][cols];
        for(int r = 0, idx = 0; r <rows;r++){
            for(int c = 0; c < cols; c++) {
                matrix[r][c] = array[idx++];
            }
        }
        return matrix;
    }
}
