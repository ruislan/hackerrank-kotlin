package practice.algorithms.debug.easy;

import java.util.Scanner;

// 方法1
// 这个debug代码是修改代码中错误的地方
// 这里有三处，在代码中标注了
public class XORStrings {
    public static String stringsXOR(String s, String t) {
        String res = new String("");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) // '=' 改为 '=='
                res += "0";  // '=' 改为 '+='
            else
                res += "1";  // '=' 改为 '+='
        }

        return res;
    }

    public static void main(String[] args) {

        String s, t;
        Scanner in = new Scanner(System.in);
        s = in.nextLine();
        t = in.nextLine();
        System.out.println(stringsXOR(s, t));

    }
}
