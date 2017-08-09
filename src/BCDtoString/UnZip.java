package BCDtoString;

public class UnZip {
    public String unzip(char[] input){
        if (input.length == 0){
            return "";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            int count = 0;
            boolean flag = false;
            while (input[i] >= '0' && input[i] <= '9'){
                count = count * 10 + (input[i] - '0');
                i++;
                flag = true;
            }
            if (flag && count <= 2) {
                return "!error";
            }
            if (!flag){
                count = 1;
            }
            for (int j = 0; j < count; j++) {
                res.append(input[i]);
            }
            if (i >= 2) {
                if (input[i] == input[i-1] && input[i] == input[i-2]){
                    return "!error";
                }
                else if (input[i] == input[i-1] && (input[i-2] >= '0' && input[i-2] <= '9')){
                    return "!error";
                }
            }
        }
        return res.toString();
    }
    public static void main(String[] args){
        UnZip t = new UnZip();
        char[] input = new char[]{'1','a'};
        String res = t.unzip(input);
        System.out.println(res);
    }
}
