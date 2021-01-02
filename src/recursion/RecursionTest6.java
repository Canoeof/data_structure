package recursion;

import java.util.Arrays;

public class RecursionTest6 {
    public static void main(String[] args) {
        int[] rs = mergeSort(new int[] {3, 2, 1}, 0, 2);
        System.out.println(Arrays.toString(rs));
    }

    //实现归并排序
    public static int[] mergeSort(int[] c, int l, int h) {
        if (l >= h) {

        } else {
            int mid = (l + h) / 2;
            mergeSort(c, l, mid);
            mergeSort(c, mid + 1, h);
            //把分出来的子数组归并
            merge(c, l, mid, h);
        }
        return c;

    }

    //实现子数组合并
    public static void merge(int[] c, int l, int mid, int h) {
        int i = l;
        int j = mid + 1;
        int[] tmp = new int[h - l + 1];
        int k = 0;

        //实现合并
        while (i <= mid && j <= h) {
            if (c[i] < c[j]) {
                tmp[k++] = c[i++];
            } else {
                tmp[k++] = c[j++];
            }
        }

        while (i <= mid && j > h) {
            tmp[k++] = c[i++];
        }

        while (i > mid && j <= h) {
            tmp[k++] = c[j++];
        }

        for (int g = 0; g < tmp.length; g++) {
            c[l + g] = tmp[g];
        }
    }
}
