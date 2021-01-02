package recursion;

import java.util.Arrays;

public class RecursionTest5 {
    public static void main(String[] args) {
        int[] c = merge(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8, 10});
        System.out.println(Arrays.toString(c));
    }

    //归并排序
    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int aNum = 0;
        int bNum = 0;
        int cNum = 0;
        //实现合并
        while (aNum < a.length && bNum < b.length) {
            if (a[aNum] < b[bNum]) {
                c[cNum++] = a[aNum++];
            } else {
                c[cNum++] = b[bNum++];
            }
        }

        //如果b数组先取完
        while (bNum == b.length && aNum < a.length) {
            c[cNum++] = a[aNum++];
        }

        //如果a数组先取完
        while (aNum == a.length && bNum < b.length) {
            c[cNum++] = b[bNum++];
        }

        return c;
    }
}
