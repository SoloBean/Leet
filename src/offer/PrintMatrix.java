package offer;

import java.util.ArrayList;

public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0){
            return res;
        }
        int h = matrix.length - 1;
        int w = matrix[0].length - 1;
        int row = 0;
        int col = 0;
        add(matrix, row, col, h, w, res);
        return res;
    }
    public void add(int[][] matrix, int row, int col, int h, int w, ArrayList<Integer> res){
        if (row > h || col > w){
            return ;
        }
        if (row == h){
            for (int j = col; j <= w; j++){
                res.add(matrix[row][j]);
            }
            return ;
        }
        else if (col == w){
            for (int i = row; i <= h; i++){
                res.add(matrix[i][col]);
            }
            return ;
        }
        for (int j = col; j <= w-1; j++){
            res.add(matrix[row][j]);
        }
        for (int i = row; i <= h-1; i++){
            res.add(matrix[i][w]);
        }
        for (int j = w; j > col; j--){
            res.add(matrix[h][j]);
        }
        for (int i = h; i > row; i--){
            res.add(matrix[i][col]);
        }
        add(matrix, row+1, col+1, h-1, w-1, res);
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,10}
        };
        PrintMatrix t = new PrintMatrix();
        t.printMatrix(matrix);
    }
}
