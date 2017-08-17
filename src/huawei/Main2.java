package huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
    public static void main(String[] args) {
        Map<String, String> dependence = new HashMap<>();
        ArrayList<String> module=new ArrayList<>();
        Scanner in = new Scanner(System.in);
        Pattern pattern =Pattern.compile("\\{(.*?), (.*?)\\},?");
        Matcher matcher;
        String temp=in.nextLine();
        while(temp.charAt(temp.length()-1)==','){
            matcher = pattern.matcher(temp);
            if(matcher.find()) {
                if(!module.contains(matcher.group(1))) module.add(matcher.group(1));
                if(!module.contains(matcher.group(2))) module.add(matcher.group(2));
                dependence.put(matcher.group(1), matcher.group(2));
            }
            temp=in.nextLine();
        }
        matcher = pattern.matcher(temp);
        if(matcher.find()) {
            dependence.put(matcher.group(1), matcher.group(2));
            if(!module.contains(matcher.group(1))) module.add(matcher.group(1));
            if(!module.contains(matcher.group(2))) module.add(matcher.group(2));
        }
        Main2 t = new Main2();
        StringBuilder res = t.print(module, dependence, temp);
        if(res.length()>2) System.out.println(res.substring(0, res.length()-2));
        else System.out.println(res.toString());
    }

    public StringBuilder print(ArrayList<String> module, Map<String, String> dependence, String temp){
        StringBuilder res=new StringBuilder();
        Set<String> visit =new HashSet<>();
        for (String string : module) {
            if(!dependence.containsKey(string)) {
                res.append("{"+string+", false},\n");
                continue;
            }
            visit.clear();
            visit.add(string);
            temp=dependence.get(string);
            while(true){
                if(temp.equals(string)) {
                    res.append("{"+string+", true},\n");
                    break;
                }
                else if(visit.contains(temp)) {
                    res.append("{"+string+", false},\n");
                    break;
                }
                visit.add(temp);
                if(dependence.containsKey(temp)) temp=dependence.get(temp);
                else {
                    res.append("{"+string+", false},\n");
                    break;
                }
            }
        }
        return res;
    }
}
