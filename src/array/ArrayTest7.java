package array;

import java.util.Arrays;

public class ArrayTest7 {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.insert("1");
        myArrayList.insert("2");
        myArrayList.insert("3");
        myArrayList.insert("4");
        myArrayList.insert("5");
        myArrayList.insert("6");
        myArrayList.insert("7");
        myArrayList.insert("8");
        myArrayList.insert("9");
        myArrayList.insert("10");
        myArrayList.insert("11");

        myArrayList.display();

        System.out.println(myArrayList.find("8"));
    }
}

class MyArrayList{
    private Object[] arr;
    private int nElems;  //数组的真实长度

    //构造方法,初始化数组
    public MyArrayList(){
        arr = new Object[10];
        nElems = 0;
    }

    //实现插入数据项，注意要实现arr数组的自动扩容
    public void insert(Object o){
        //判断当前nElems有没有越界，如果说现在插入数组的新元素，下标要超过原数组的最大长度，实施扩容
        if (nElems == arr.length) {
            arr = Arrays.copyOf(arr, arr.length + (arr.length >> 1));
        }
        arr[nElems++] = o;
    }

    //遍历
    public void display(){
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + "    ");
        }
    }

    //查找指定的元素，找到了返回元素在数组中的索引值，找不到返回-1
    public int find(Object o) {
        int i;
        for ( i = 0; i < nElems; i++) {
            if (o.equals(arr[i])) {
                break;
            }
        }
        if (i < nElems) {
            return i;
        } else {
            return -1;
        }
    }

    //删除指定的元素
    public void delete(Object o) {
        int i = find(o);
        if (i != -1) {
            System.arraycopy(arr, i + 1, arr, i, nElems - 1 - i);
            nElems--;
        }
    }
}