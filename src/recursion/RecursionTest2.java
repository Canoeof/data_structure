package recursion;

import java.util.Scanner;

/**
 * 数字三角形最大路径计算
 * 1
 * 2 3
 * 4 5 6
 */
public class RecursionTest2 {

    private static int[][] data;  //存放数字三角形的数字
    private static int n;  //三角形的行数

    public static void main(String[] args) {
        //二维数组的初始化
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字三角形的高度：");
        n = sc.nextInt();
        //实例化二维数组
        data = new int[n][n];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.println("请输入第" + i + "行，第" + j + "列的数字");
                data[i-1][j-1] = sc.nextInt();
            }
        }
        System.out.println("--------------数字三角形------------");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(data[i-1][j-1] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------测试结果--------------");
        int rs;
        rs = maxSum(1, 1);
        System.out.println("结果为：" + rs);
    }

    public static int maxSum(int i, int j) {
        if (i == n) {  //边界条件
            return data[i-1][j-1];
        } else {
            int x = maxSum(i + 1, j);
            int y = maxSum(i + 1, j + 1);
            return Math.max(x, y) + data[i - 1][j - 1];
        }
    }

}

