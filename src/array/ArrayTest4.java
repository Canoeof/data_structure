package array;

public class ArrayTest4 {
    public static void main(String[] args) {
        ArrayClassSelect arrayClassSelect = new ArrayClassSelect(100);

        arrayClassSelect.insert(6);
        arrayClassSelect.insert(18);
        arrayClassSelect.insert(8);
        arrayClassSelect.insert(15);
        arrayClassSelect.insert(11);
        arrayClassSelect.insert(0);
        arrayClassSelect.insert(9);
        arrayClassSelect.display();
        System.out.println();
        arrayClassSelect.selectSort();
        arrayClassSelect.display();
    }
}

class ArrayClassSelect{
    private long[] arr;   //被封装的数组
    private int nElems;   //数组中存在的元素的个数

    //通过数组类的构造方法初始化


    public ArrayClassSelect(int maxSize) {   //maxSize是数组的最大长度
        arr = new long[maxSize];   //初始化被封装的数组
        nElems = 0;
    }

    //新增数据项，数组元素
    public void insert(long data) {
        arr[nElems] = data;
        nElems++;
    }

    //查找某一特定的数据项
    public int find(long searchData) {
        int i;
        for (i = 0; i < nElems; i++) {
            if (searchData == arr[i]) {
                break;  //找到了数据项，终止循环，i为对应的索引值
            }
        }

        if(i == nElems){
            System.out.println("数组中没有该数据");
            return -1;
        }else {
            return i;
        }
    }

    //删除指定的数据项
    public void delete(long targetData) {
        //查找对应的数据
        int i;
        for (i = 0; i < nElems; i++) {
            if (targetData == arr[i]) {
                break;  //找到了数据项，终止循环，i为对应的索引值
            }
        }

        if (i == nElems) {
            System.out.println("没有找到需要删除的数据");
        }else {
            for (int j = i; j < nElems; j++) {
                arr[j] = arr[j + 1];  //删除数组中要删除的元素
            }
            nElems--;
        }
    }

    //遍历数组中的每一个数据项
    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //实现选择排序算法，从小到大
    public void selectSort() {
        int outer;
        int inner;
        int min;

        for (outer = 0; outer < nElems - 1; outer++) {
            min = outer;   //每次循环初始化min指向outer的位置，剩下元素的第一个
            for (inner = outer + 1; inner < nElems; inner++) {
                if (arr[min] > arr[inner]) {
                    min = inner;
                }
            } //每次循环后找到让min指向真正最小的元素
            //和outer交换位置
            long temp = arr[outer];
            arr[outer] = arr[min];
            arr[min] = temp;
        }
    }


}
