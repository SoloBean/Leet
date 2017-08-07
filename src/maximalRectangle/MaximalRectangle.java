package maximalRectangle;
class Square {
    int right;
    int down;
    int downRight;
    public Square(int right, int down, int downRight){
        this.right = right;
        this.down = down; this.downRight = downRight;
    }
}
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0){
            return 0;
        }
        Square[][] res = new Square[matrix.length][matrix[0].length];
        char a = matrix[0][0];
        if (a == '1'){
            res[0][0] = new Square(1,1,0);
        }
        else {
            res[0][0] = new Square(0,0,0);
        }
        int max = 0;
        for (int i = 1; i < matrix.length; i++){
            if (matrix[i][0] == '1'){
                res[i][0] = new Square(1, res[i-1][0].down + 1, 0);
                if (max < Math.max(res[i][0].down, max)) max = Math.max(res[i][0].down, max);
            }
            else {
                res[i][0] = new Square(0,0,0);
            }
        }
        for (int j = 1; j < matrix[0].length; j++){
            if (matrix[0][j] == '1'){
                res[0][j] = new Square(res[0][j-1].right + 1, 1, 0);
                if (max < Math.max(res[0][j].right, max)) max = Math.max(res[0][j].right, max);
            }
            else {
                res[0][j] = new Square(0,0,0);
            }
        }
        if (matrix.length > 1 && matrix[0].length > 1){
            for (int i = 1; i < matrix.length; i++){
                for (int j = 1; j < matrix[0].length; j++){
                    if (matrix[i][j] == '1'){
                        int downRight = 0;
                        if (matrix[i-1][j-1] == '1' && matrix[i-1][j] == '1' && matrix[i][j-1] == '1'){
                            downRight = (Math.min(res[i-1][j].right, res[i][j-1].right+1)) *
                                    (Math.min(res[i][j-1].down, res[i-1][j].down+1));
                        }
                        int right = res[i][j-1].right + 1;
                        int down = res[i-1][j].down + 1;
                        if (max < Max(right, down, downRight)) max = Max(right, down, downRight);
                        res[i][j] = new Square(right, down, downRight);
                    }
                    else {
                        res[i][j] = new Square(0, 0, 0);
                    }
                }
            }
        }
        return max;
    }

    public int Max(int x, int y, int z){
        if (x >= y && x >= z){
            return x;
        }
        else if(y >= x && y >= z){
            return y;
        }
        else {
            return z;
        }
    }

    public static void main(String[] arg){
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        MaximalRectangle t = new MaximalRectangle();
        t.maximalRectangle(matrix);
    }
}
