package array;

public class ArrayTest5 {
    public static void main(String[] args) {
        ArrayClassInsert arrayClassInsert = new ArrayClassInsert(100);

        arrayClassInsert.insert(11);
        arrayClassInsert.insert(12);
        arrayClassInsert.insert(15);
        arrayClassInsert.insert(22);
        arrayClassInsert.insert(7);
        arrayClassInsert.insert(656);
        arrayClassInsert.insert(0);

        arrayClassInsert.display();
        System.out.println();
        arrayClassInsert.insertSort();
        arrayClassInsert.display();
    }
}

class ArrayClassInsert{
    private long[] arr;   //被封装的数组
    private int nElems;   //数组中存在的元素的个数

    //通过数组类的构造方法初始化


    public ArrayClassInsert(int maxSize) {   //maxSize是数组的最大长度
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

    //插入排序算法，从小到大
    public void insertSort() {
        int outer;
        int inner;
        long temp;

        for (outer = 1; outer < nElems; outer++) {
            inner = outer;
            temp = arr[outer];

            while (inner > 0 && arr[inner - 1] > temp) {
                arr[inner] = arr[inner - 1];
                --inner;
            }
            //把开始拿走的数据项再插入回来
            arr[inner] = temp;
        }
    }


}