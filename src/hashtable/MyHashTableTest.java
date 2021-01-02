package hashtable;

public class MyHashTableTest {
    //测试哈希表的入口
    public static void main(String[] args) {
        MyHashTable myHashTable = new MyHashTable(100);
        myHashTable.insert(new DataItem(12));
        myHashTable.insert(new DataItem(200));
        myHashTable.insert(new DataItem(120));
        myHashTable.insert(new DataItem(30));
        myHashTable.insert(new DataItem(50));

        myHashTable.display();

        DataItem item = myHashTable.find(12);
        System.out.println();
    }
}

//定义哈希表中保存的数据项对应的类
class DataItem{
    private int data;  //数据项中的值

    //初始化
    public DataItem(int data) {
        this.data = data;
    }

    //在外部获取数据值的方法
    public int getData() {
        return data;
    }
}

class MyHashTable{
    //声明hashtable中底层的属性
    private DataItem[] hashArray;  //保存在哈希表中的数据项
    private int arraySize;   //保存上面数组的长度
    private int itemNum;  //保存上面的数组中真正含有的数据项的个数
    private DataItem delItem;  //表示哈希表中被删除的数据项

    //初始化
    public MyHashTable(int arraySize) {
        this.arraySize = arraySize;
        hashArray = new DataItem[arraySize];
        itemNum = 0;
        delItem = new DataItem(-1);  //这里规定，被删除的数据项，里面的值为-1
    }

    //判断数组是不是满的
    public boolean isFull() {
        return itemNum == arraySize;
    }

    //判断数组是不是空的
    public boolean isEmpty() {
        return itemNum == 0;
    }

    //实现打印哈希表中数据项的值
    public void display() {
        System.out.println("hashtable: ");
        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] != null) {
                System.out.println(hashArray[i].getData() + "   ");
            } else {
                System.out.println("**");
            }
        }
    }

    //实现哈希函数
    public int hashFunction(int key) {
        return key%arraySize;
    }

    //插入数据
    public void insert(DataItem item) {
        //如果hash表已经满了，对hash表进行扩容
        if (isFull()) {
            //进行扩容，本质上是扩大hash表内部的数组的长度
            System.out.println("hash表已经满了，现在进行扩容: ");
            extandHashTable();
        }

        int data = item.getData();
        //对data进行hash化
        int hashval = hashFunction(data);  //hashval，目的是用通过这个hash值来作为保存的数值的index
        while (hashArray[hashval] != null && hashArray[hashval].getData() != -1) {
            //满足上述条件说明该位置被占
            //进行线性探索，查找下面相邻的空位
            hashval++;
            hashval = hashFunction(hashval);
        }

        //while循环正常结束，表示找到了下面的空位
        hashArray[hashval] = item;
        itemNum++;
    }

    //对hash表进行扩容
    public void extandHashTable() {
        //需要注意的地方：不能像我们前面课程中对数组扩容的方法来做
        //不能把旧数组的数据项，直接复制到新的更大的数组的相同的位置
        int num = arraySize;  //旧数组的长度临时保存起来
        itemNum = 0;  //对hash表中保存的数据项个数重新计数
        arraySize = arraySize*2;
        DataItem[] oldDataItemArr = hashArray;  //把旧数组的数据也临时保存起来
        hashArray = new DataItem[arraySize];
        for (int i = 0; i < num; i++) {
            insert(oldDataItemArr[i]);
        }
    }

    //删除数据项
    public DataItem delete(int data) {
        //首先判断hash表是不是空的
        if (isEmpty()) {
            System.out.println("hash表是空的");
            return null;
        } else {
            //查找要删除的目标
            int hashval = hashFunction(data);
            while (hashArray[hashval] != null) {
                if (hashArray[hashval].getData() == data) {
                    //找到了要删除的目标
                    DataItem tmp = hashArray[hashval];
                    hashArray[hashval] = delItem;  //真正有意义的删除动作
                    itemNum--;
                    return tmp;
                }
                hashval++;
                hashval = hashFunction(hashval);
            }
            return null;  //表示hash表中没有要删除的数据项
        }
    }

    //实现在hash表中查找指定的数据项
    public DataItem find(int data) {
        int hashval = hashFunction(data);
        while (hashArray[hashval] != null) {
            if (hashArray[hashval].getData() == data) {
                return hashArray[hashval];
            }
            hashval++;
            hashval = hashFunction(hashval);
        }
        return null;
    }
}
