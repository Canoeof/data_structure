package heap;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 6, 3, 8, 7, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //堆排序
    public static void sort(int[] arr) {
        //首先把arr调整成一个合法的堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int j = arr.length - 1; j > 0; j--) {
            //交换堆顶元素和堆尾元素
            swap(arr,0,j);
            //交换完后，调整
            adjustHeap(arr,0,j);
        }
    }

    //调整的方法
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;  //k指向左右两个子节点中大的那个
            }
            if (temp >= arr[k]) {
                break;
            } else {
                arr[i] = arr[k];
                i = k; //被调整的节点应该在的位置
            }
        }
        arr[i] = temp;
    }

    //交换
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
