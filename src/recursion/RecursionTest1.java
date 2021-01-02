package recursion;

import java.util.Scanner;

public class RecursionTest1 {
    public static void main(String[] args) {
        //提示
        System.out.println("请输入一个整数:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //调用一个方法，获取n!
        int rs = getFactoriaFor(n);
        System.out.println("n!是: " + rs);
    }

    //通过循环实现n！
    public static int getFactoriaFor(int n) {
        if (n >= 0) {
            int tmp = 1;
            for (int i = 1; i <= n; i++) {
                tmp = tmp * i;
            }
            return tmp;
        } else {
            return -1;  //负数没有阶乘
        }
    }

    //通过递归的算法实现n!
    public static int getFactorialRecursion(int n) {
        if (n >= 0) {
            if (n == 0) {
                return 1;
            } else {
                int tmp = n * getFactorialRecursion(n - 1);
                return tmp;
            }
        } else {
            return -1;
        }
    }
}
