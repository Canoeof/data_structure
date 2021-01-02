package array;

/**
 * 删除和查找数据都存在问题，无法对重复值进行处理
 */
public class ArrayTest {
    //程序的执行入口，测试用
    public static void main(String[] args) {
        ArrayClass arrayClass = new ArrayClass(100);

        //新增数组元素
        arrayClass.insert(11);
        arrayClass.insert(12);
        arrayClass.insert(15);
        arrayClass.insert(22);
        arrayClass.insert(7);
        arrayClass.insert(656);
        arrayClass.insert(0);

        arrayClass.display();
        arrayClass.delete(11);
        arrayClass.display();
    }
}

/**
 * 创建一个封装数组的类
 */
class ArrayClass{
    private long[] arr;   //被封装的数组
    private int nElems;   //数组中存在的元素的个数

    //通过数组类的构造方法初始化


    public ArrayClass(int maxSize) {   //maxSize是数组的最大长度
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

}
