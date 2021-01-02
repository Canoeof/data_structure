package sort;

import java.util.Arrays;


public class ShellSortTest {
    public static void main(String[] args) {
        //int[] nums = {1,2,4,5,3,7,20,6};
        int[] nums = {2,1};
        shellSort(nums);
    }

    //实现希尔排序
    public static void shellSort(int[] data) {
        System.out.println("排序前：" + Arrays.toString(data));
        int outer;
        int inner;
        int temp;
        int len = data.length;
        if (len == 2) {
            if (data[1] < data[0]) {
                temp = data[1];
                data[1] = data[0];
                data[0] = temp;
            }
            System.out.println("排序后：" + Arrays.toString(data));
            return;
        }
        for(int step=(int)((double)len/2.2); step>0; step=(int)((double)step/2.2)) {
            for (outer = step; outer < len; outer++) {
                inner = outer;
                temp = data[outer];
                while (inner - step >= 0 && temp < data[inner - step]) {
                    data[inner] = data[inner - step];
                    inner = inner - step;
                }
                data[inner] =temp;
            }
            System.out.println("间隔是" + step + "时排序: " + Arrays.toString(data));
        }
        System.out.println("排序后：" + Arrays.toString(data));
    }
}
