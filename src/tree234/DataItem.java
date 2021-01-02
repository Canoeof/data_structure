package tree234;

/**
 * 封装数据项的类
 */
public class DataItem {
    public int data;  //节点里的具体的数据项的值，简化代码的原因，用public，应该用private

    //构造方法初始化data
    public DataItem(int data) {
        this.data = data;
    }

    //打印数据项
    public void displayItem() {
        System.out.print("/" + data);
    }


}
