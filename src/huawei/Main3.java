package huawei;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String t = in.nextLine();
        String[] tmp = t.split("\\.");
        Main3 m = new Main3();
        StringBuilder res = new StringBuilder();
        if (tmp.length == 1){
            if (t.charAt(t.length()-1) != '.'){
                System.out.print(tmp[0]);
                return ;
            }
        }
        for (int i = 0; i < tmp.length; i++){
            String str = tmp[i];
            if (str.contains("@")){
                String s = m.change(str);
                if (i == 0){
                    res.append(s);
                    if (tmp.length == 1){
                        res.append(".");
                    }
                }
                else {
                    res.append("."+s);
                }
            }
            else {
                res.append("."+str);
                continue;
            }
        }
        System.out.print(res.toString());
    }
    public String change(String str){
        String[] tmp = str.split("@");
        if (tmp[0].length() < 3){
            return str;
        }
        if (tmp[1].length() > 119){
            return str;
        }
        if (!isValidBefore(tmp[0]) || !isValidAfter(tmp[1])){
            return str;
        }
        StringBuilder t = new StringBuilder();
        for (int i = 0; i < tmp[0].length()-3; i++){
            t.append(tmp[0].charAt(i));
        }
        t.append("***@");
        t.append(tmp[1]);
        return t.toString();
    }

    public boolean isValidAfter(String cmp) {
        for (int i = 0; i < cmp.length(); i++) {
            if ((cmp.charAt(i) >= '0' && cmp.charAt(i) <= '9') ||
                    (cmp.charAt(i) >= 'a' && cmp.charAt(i) <= 'z') ||
                    (cmp.charAt(i) >= 'A' && cmp.charAt(i) <= 'Z') ||
                    cmp.charAt(i) == '-') {
                continue;
            }
            return false;
        }
        return true;
    }

    public boolean isValidBefore(String cmp){
        for (int i = 0; i < cmp.length(); i++){
            char a = cmp.charAt(i);
            if ((cmp.charAt(i) >= '0' && cmp.charAt(i) <= '9') ||
                    (cmp.charAt(i) >= 'a' && cmp.charAt(i) <= 'z') ||
                    (cmp.charAt(i) >= 'A' && cmp.charAt(i) <= 'Z') ||
                    cmp.charAt(i) == '&' || a == '=' || a=='+'||a=='$'||a == ','
                    || a == ';' || a == '?'|| a=='/' || a =='-' || a == '_'||
                    a == '.' || a=='!' || a=='!' || a=='~' ||a=='*' || a=='\'' || a=='('
                    || a==')' || a=='#'){
                continue;
            }
            return false;
        }
        return true;
    }
}
