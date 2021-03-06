package interleavingString;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        if (s2.length() == 0){
            return s3.equals(s1);
        }
        if (s1.length() == 0){
            return s3.equals(s2);
        }
        boolean[][] record = new boolean[s1.length()+1][s2.length()+1];
        record[0][0] = true;
        for (int i = 1; i <= s1.length(); i++){
            if (s3.charAt(i-1) == s1.charAt(i-1) && record[i-1][0]){
                record[i][0] = true;
            }
            else {
                record[i][0] = false;
            }
        }
        for (int j = 1; j <= s2.length(); j++){
            if (s3.charAt(j-1) == s2.charAt(j-1) && record[0][j-1]){
                record[0][j] = true;
            }
            else {
                record[0][j] = false;
            }
        }
        for (int i = 1; i <= s1.length(); i++){
            for (int j = 1; j <= s2.length(); j++){
                if (record[i][j-1] && s3.charAt(i+j-1) == s2.charAt(j-1)){
                    record[i][j] = true;
                }
                if (record[i-1][j] && s3.charAt(i+j-1) == s1.charAt(i-1)){
                    record[i][j] = true;
                }
            }
        }
        return record[s1.length()][s2.length()];
    }
}
