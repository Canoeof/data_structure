package recursion;

/**
 * 计算一个数的乘方
 */
public class RecursionTest8 {
    public static void main(String[] args) {
        System.out.println(pow(2,6));
    }

    //递归方法
    public static int pow(int x, int y) {
        if (y == 0) {
            return 1;
        }
        if (y == 1) {
            return x;
        }
        if (y % 2 == 1) {
            return pow(x * x,y/2) * x;
        }else {
            return pow(x * x, y / 2);
        }
    }
}
