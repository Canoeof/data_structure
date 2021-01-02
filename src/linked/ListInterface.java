package linked;

public interface ListInterface<T> {  //规定了链表应该实现哪些功能
    //返回当前的节点个数
    public int getSize();

    //在链表表头添加新节点
    public void addHead(T data);

    //在链表尾部添加新节点
    public void addTail(T data);

}
