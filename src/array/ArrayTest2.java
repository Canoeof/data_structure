package array;

public class ArrayTest2 {
    //程序的入口
    public static void main(String[] args) {
        OrderArray orderArray = new OrderArray(100);
        orderArray.insert(15);
        orderArray.insert(18);
        orderArray.insert(16);
        orderArray.insert(9);

        orderArray.display();

        System.out.println(orderArray.find(15));

        orderArray.delete(15);
        orderArray.display();
    }
}

class OrderArray{
    private long[] arr;
    private int nElems;

    //OrderArray的构造方法初始化数组类

    public OrderArray(int maxSize) {
        arr = new long[maxSize];
        nElems = 0;
    }

    //插入数据项
    public void insert(long data) {
        //找到插入数据的位置
        int i;
        for (i = 0; i < nElems; i++) {
            if (arr[i] > data) {
                break;
            }
        }

        //找到和没找到
        if(i < nElems) {  //找到的情况
            for(int j=nElems; j>i;j--) {
                if(j < arr.length) arr[j] = arr[j - 1];
            }
            arr[i] = data;
            nElems++;
        }else {   //没找到
            if(nElems < arr.length)  arr[nElems] = data;
            nElems++;
        }
    }

    //遍历
    public void display(){
        for (int i = 0; i < nElems; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    //查找某个指定的元素，二分查找算法
    //找到了要找的数据，返回数据对应的索引，没找到返回数组的当前长度
    public int find(long searchData) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curint;   //二分查找时，处在中间位置元素的索引

        while (true) {
            curint = (lowerBound + upperBound) / 2;
            if (arr[curint] == searchData) {
                return curint;
            } else if (lowerBound > upperBound) {
                //数组中没有找到指定的元素
                return nElems;
            } else {
                if (arr[curint] > searchData) {
                    upperBound = curint - 1;
                } else {
                    lowerBound = curint + 1;
                }
            }
        }
    }

    //删除指定的元素
    public void delete(long data) {
        int i = find(data);
        if (i < nElems) {
            for (int j = i; j < nElems; j++) {
                arr[j] = arr[j + 1];
            }
            nElems--;
        }
    }
}