package BCDtoString;

import java.util.Scanner;

public class BCDToString {
    public static String bcd2Str(byte[] bytes) {
        StringBuffer temp = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            temp.append((byte) ((bytes[i] & 0xf0) >>> 4));
            temp.append((byte) (bytes[i] & 0x0f));
        }
        return temp.toString().substring(0, 1).equalsIgnoreCase("0") ? temp.toString().substring(1) : temp.toString();
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            String line=scanner.nextLine();
            String[] var=line.split(",");
            String s="";
            for (int i=0;i<var.length;i++)
            {
                char[] chars=var[i].toCharArray();
                s=s+chars[3];
                if(chars[2]!='F')
                {
                    s=s+chars[2];
                }
            }
            System.out.println(s);
        }
    }

}
