package huawei;

public class NextPer {
    public String LeftRotateString(String A, int n, int p) {
        if (n < p || n == 0 || n == 1){
            return A;
        }
        String a = A.substring(0,p+1);
        String b = A.substring(p+1, n);
        return b+a;
    }
    public static void main(String[] args){
        NextPer t = new NextPer();
        String tmp = t.LeftRotateString("ABCDEFGH", 8, 4);
        System.out.print(tmp);
    }
}
