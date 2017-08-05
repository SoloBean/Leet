package nQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 3){
            return res;
        }
        int[][] used = new int[n][n];
        helper(0, used, new ArrayList<>(), res, n);
        return res;
    }

    public void helper(int k, int[][] used, List<String> list, List<List<String>> res, int n){
        if (k == n-1){
            for (int i = 0; i < n; i++){
                if (used[k][i] == 0){
                    list.add(genStr(i,n));
                    List<String> tmp = new ArrayList<>(list);
                    res.add(tmp);
                    list.remove(list.size()-1);
                }
            }
        }
        else {
            for (int i = 0; i < n; i++){
                if (used[k][i] == 0){
                    addUsed(k, i, used, n);
                    list.add(genStr(i, n));
                    helper(k+1, used, list, res, n);
                    list.remove(list.size()-1);
                    deUsed(k, i, used, n);
                }
            }
        }
    }
    public void addUsed(int x, int y, int[][] used, int n){
        for (int i = x, j = y; i < n && j < n; i++, j++){
            used[i][j]++;
        }
        for (int i = x, j = y; i < n && j >= 0; i++, j--){
            used[i][j]++;
        }
        for (int i = x; i < n; i++){
            used[i][y]++;
        }
    }
    public void deUsed(int x, int y, int[][] used, int n){
        for (int i = x, j = y; i < n && j < n; i++, j++){
            used[i][j]--;
        }
        for (int i = x, j = y; i < n && j >= 0; i++, j--){
            used[i][j]--;
        }
        for (int i = x; i < n; i++){
            used[i][y]--;
        }
    }

    public String genStr(int i, int n){
        String res = "";
        int j = 0;
        while (j < i){
            res += ".";
            j++;
        }
        res += "Q";
        j++;
        while (j < n){
            res +=".";
            j++;
        }
        return res;
    }

    public static void main(String[] args){
        NQueens t = new NQueens();
        t.solveNQueens(4);
    }
}
class Solution {
    public List<List<String>> solveNQueens(int n) {
        long bit_col = (1<<n) -1;
        long left_diag = (1 <<(n*2-1))-1;
        long right_diag = (1 <<(n*2-1)) -1;
        int[] rows = new int[n];
        List<List<String>> ans = new ArrayList<List<String>>();
        dfsHelper(0,ans,rows,bit_col,left_diag,right_diag);
        return ans;
    }

    private void dfsHelper(int row, List<List<String>> ans, int[] rows, long bit_col, long left_diag, long right_diag){
        if(row == rows.length){
            List<String> temp = new ArrayList<String>();
            for(int i=0; i< rows.length;i++){
                char[] sArray = new char[rows.length];
                Arrays.fill(sArray, '.');
                sArray[rows[i]] = 'Q';
                temp.add(new String(sArray));
            }
            ans.add(temp);
            return;
        }else{
            for(int col=0; col< rows.length; col++){
                long bit_col_temp = 1<<col, left_diag_temp = 1<<(col-row+rows.length-1),right_diag_temp = 1<<(col+row);
                if((bit_col_temp&bit_col)>0 &&(left_diag_temp&left_diag)>0 &&(right_diag_temp&right_diag)>0){
                    rows[row] = col;
                    dfsHelper(row+1, ans, rows,bit_col&(~bit_col_temp),
                            left_diag&(~left_diag_temp),right_diag&(~right_diag_temp));

                }
            }
        }
    }
}
