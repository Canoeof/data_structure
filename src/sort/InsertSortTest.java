package sort;

public class InsertSortTest {
    public static void main(String[] args) {
        int[] nums = {1,2,4,5,3,7,20,6};
        insertSort(nums);
        for (int i : nums) {
            System.out.print(i + "  ");
        }
    }

    //实现插入排序
    public static void insertSort(int[] arr) {
        int outer;
        int inner;
        int temp;

        for (outer = 1; outer < arr.length; outer++) {
            inner = outer;
            temp = arr[outer];
            while (inner > 0 && temp < arr[inner-1]) {
                arr[inner] = arr[inner - 1];
                inner--;
            }
            arr[inner] = temp;
        }
    }
}
