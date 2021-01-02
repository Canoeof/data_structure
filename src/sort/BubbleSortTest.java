package sort;


/**
 * 冒泡排序
 */
public class BubbleSortTest {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 6, 5, 9, 7, 8};
        arr = new BubbleSort(arr).sort();
        for (int c : arr) {
            System.out.print(c + "  ");
        }
        System.out.println();
    }
}

//冒泡排序:从小到大
class BubbleSort{
    private int[] arr;
    private int nElems;

    public BubbleSort(int[] arr) {
        this.arr = arr;
        nElems = arr.length;
    }

    public int[] sort() {
        int outer;
        int inner;
        for(outer=nElems-1;outer>0;outer--)  {
            for (inner = 0; inner < outer; inner++) {
                if(arr[inner] > arr[inner+1]) {
                    int temp = arr[inner];
                    arr[inner] = arr[inner + 1];
                    arr[inner + 1] = temp;
                }
            }
        }
        return arr;
    }
}
