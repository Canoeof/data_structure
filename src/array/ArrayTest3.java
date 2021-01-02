package array;

/**
 * 冒泡排序算法对无序数组排序
 */
public class ArrayTest3 {
    public static void main(String[] args) {

        ArrayClassBud arrayClassBud = new ArrayClassBud(100);
        //新增数组元素
        arrayClassBud.insert(11);
        arrayClassBud.insert(12);
        arrayClassBud.insert(14);
        arrayClassBud.insert(7);
        arrayClassBud.insert(6);
        arrayClassBud.insert(4);
        arrayClassBud.insert(99);
        arrayClassBud.insert(23);
        arrayClassBud.insert(22);
        arrayClassBud.insert(19);
        arrayClassBud.insert(0);

        arrayClassBud.bubSort();

        arrayClassBud.display();
    }
}


class ArrayClassBud{
    private long[] arr;   //被封装的数组
    private int nElems;   //数组中存在的元素的个数

    //通过数组类的构造方法初始化


    public ArrayClassBud(int maxSize) {   //maxSize是数组的最大长度
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

    //冒泡排序算法，从小到大
    public void bubSort() {
        int outer;
        int inner;

        for (outer = nElems - 1; outer > 0; outer--) {
            for (inner = 0; inner < outer; inner++) {
                if (arr[inner] > arr[inner + 1]) {
                    long temp = arr[inner];
                    arr[inner] = arr[inner + 1];
                    arr[inner+1] = temp;
                }
            }
            inner = 0;   //下一轮循环inner回到第一个元素
        }
    }

}
