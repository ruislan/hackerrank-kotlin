package practice.algorithms.debug.easy;

import java.util.Scanner;

public class SmartNumber {
    public static boolean isSmartNumber(int num) {
        int val = (int) Math.sqrt(num);
        if (val * val == num) // 修改这里即可，原处是if(num / val == 1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int test_cases;
        Scanner in = new Scanner(System.in);
        test_cases = in.nextInt();
        int num;
        for (int i = 0; i < test_cases; i++) {
            num = in.nextInt();
            boolean ans = isSmartNumber(num);
            if (ans) {
                System.out.println("YES");
            } else System.out.println("NO");
        }
    }
}
