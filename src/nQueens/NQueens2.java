package nQueens;

import java.util.ArrayList;
import java.util.List;

public class NQueens2 {
    public int totalNQueens(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0){
            return 0;
        }
        helper(n, res, new ArrayList<>());
        return res.size();
    }
    public void helper(int n, List<List<Integer>> res, List<Integer> col){
        if (col.size() == n){
            List<Integer> list = new ArrayList<>(col);
            res.add(list);
        }
        for (int colIndex = 0; colIndex < n; colIndex++){
            if (isOK(col, colIndex)){
                col.add(colIndex);
                helper(n, res, col);
                col.remove(col.size()-1);
            }
        }
    }
    public boolean isOK(List<Integer> col, int colIndex){
        int row = col.size();
        for (int i = 0; i < col.size(); i++){
            if (col.get(i) == colIndex){
                return false;
            }
            else if (colIndex - col.get(i) == row - i){
                return false;
            }
            else if(col.get(i) - colIndex == row - i){
                return false;
            }
        }
        return true;
    }
}
class Solution2 {
    public int sum = 0;
    public int totalNQueens(int n) {
        if (n == 0){
            return 0;
        }
        int[] usedCol = new int[n];
        helper(n, usedCol, 1);
        return sum;
    }
    public void helper(int n, int[] used, int k){
        if (k == n + 1){
            sum++;
            return;
        }
        for (int i = 0; i < n; i++){
            if (isOK(k, i, used)){
                used[i] = k;
                helper(n, used, k+1);
                used[i] = 0;
            }
        }
    }
    public boolean isOK(int x, int y, int[] used){
        if (used[y] > 0){
            return false;
        }
        for (int i = 0; i < used.length; i++){
            if (Math.abs(y - i) == x - used[i] && used[i] != 0){
                return false;
            }
        }
        return true;
    }
}
