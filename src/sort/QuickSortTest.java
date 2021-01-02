package sort;

import java.util.Arrays;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] data = {22,11,3,5,34,23,6,7,4};
        quickSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

    //宏观的快速排序算法的实现，依赖递归算法应用
    public static void quickSort(int[] data, int left, int right) {
        //边界条件
        if (left >= right) {
            return;
        }else {
            //递归之前把数组分割成两部分,前半部分的所有元素都应该小于后半部分
            int partition = partitionLR(data, left, right);
            //分割后进行递归
            quickSort(data, left, partition - 1);
            quickSort(data, partition + 1, right);
        }
    }

    //实现具体的数组的分割功能
    public static int partitionLR(int[] data, int left, int right) {
        int i = left;
        int j = right + 1;
        int base = data[left];   //基准值：等待被分割的数组的第一个元素
        while (true) {
            while (i < right && data[++i] < base) { }
            while (j > left && data[--j] > base) { }

            if (i >= j) {
                break;
            } else {
                swap(data,i,j);
            }
        }
        swap(data,left,j);
        return j;
    }

    //交换数组元素
    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
