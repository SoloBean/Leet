package replaceSpace;

public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        if (str.length() == 0){
            return "";
        }
        String t = str.toString();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < t.length(); i++){
            if (t.charAt(i) == ' '){
                res.append("%20");
            }
            else {
                res.append(t.charAt(i));
            }
        }
        return res.toString();
    }
    public static void main(String[] args){
        String t = "hello world ";
        String[] tmp = t.split(" ");
        int b = tmp.length;
    }
}
