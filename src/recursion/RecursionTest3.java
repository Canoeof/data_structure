package recursion;

public class RecursionTest3 {
    public static void main(String[] args) {
        int[] arr = {1,2,4,6,7,8,9};
        int rs;
        rs = binarySearchRecursion(arr,7,0,6);
        System.out.println(rs);
    }

    public static int binarySearchRecursion(int[] arr, int value, int l, int h) {
        int mid = (h + l) / 2;
        if (value == arr[mid]) {
            return mid;
        } else if (l > h) {
            return -1;
        } else {
            if (value > arr[mid]) {
                return binarySearchRecursion(arr, value, mid + 1, h);
            }
            if (value < arr[mid]) {
                return binarySearchRecursion(arr, value, l, mid - 1);
            }
        }
        return -1;
    }

    //for循环实现二分查找
    public static int binarySearchfor(int[] array, int value) {
        int low = 0;
        int high = array.length-1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (value == array[mid]) {
                return mid;
            } else {
                if (value > array[mid]) {
                    low = mid + 1;
                }
                if (value < array[mid]) {
                    high = mid - 1;
                }
            }
        }
        return -1;  //数组中不存在我们要找的值
    }
}
