package sort;

/**
 * 选择排序
 */
public class SelectionSortTest {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 6, 5, 9, 7, 8};
        selectionSort(arr);

        for (int c : arr) {
            System.out.print(c + "  ");
        }
        System.out.println();
    }

    public static void selectionSort(int[] arr) {
        int outer;
        int inner;
        int min;
        for(outer=0;outer<arr.length-1;outer++) {
            min = outer;
            for(inner=outer+1;inner<arr.length;inner++) {
                if (arr[min] > arr[inner]) {
                    min = inner;
                }
            }
            int temp = arr[min];
            arr[min] = arr[outer];
            arr[outer] = temp;
        }
    }
}


