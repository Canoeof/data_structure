package tree234;

/**
 * 234树里的节点
 */
public class Node {
    private  static final int ORDER = 4;
    private int numItems;  //保存节点中含有的数据项的个数
    private Node parent;  //指向当前节点的父节点
    private Node[] childArray = new Node[ORDER];  //保存当前节点的子节点的数组
    private DataItem[] itemArray = new DataItem[ORDER-1];


    //返回节点中数据项的数组
    public DataItem[] getItemArray() {
        return itemArray;
    }

    //链接子节点
    public void connectChild(int childNum, Node child) {
        childArray[childNum] = child;
        if (child != null) {
            child.parent = this;
        }
    }

    //断开子节点,子节点返回
    public Node disconnectChild(int childNum) {
        Node childNode = childArray[childNum];
        childArray[childNum] = null;  //断开
        return childNode;
    }

    //拿到当前节点的某个指定的子节点
    public Node getChild(int childNum) {
        return childArray[childNum];
    }

    //拿到当前节点的父节点
    public Node getParent() {
        return parent;
    }

    //判断当前节点是不是叶子节点
    public boolean isLeaf() {
        return childArray[0] == null;
    }

    //拿到当前节点中包含的数据项的个数
    public int getNumItems() {
        return numItems;
    }

    //判断当前节点是不是满节点
    public boolean isFull() {
        return numItems == ORDER - 1;
    }

    //给出一个数据项，返回此数据项在节点中的位置
    public int findItem(int key) {
        for (int i = 0; i < numItems; i++) {
            if (key == itemArray[i].data) {
                return i;
            }
        }
        return -1;
    }

    //实现新的数据项插入到此节点中对应的位置
    public int insertItem(DataItem newDataItem) {
        numItems++;
        int newData = newDataItem.data;
        for(int i=ORDER-2;i>=0; i--) {
            if (itemArray[i] == null) {
                continue;
            } else {
                int itemArrayData = itemArray[i].data;
                if (newData < itemArrayData) {
                    itemArray[i + 1] = itemArray[i];
                } else {
                    itemArray[i+1] = newDataItem;
                    return i+1;
                }
            }
        }
        //循环完了都没有返回，证明itemArray是空的
        itemArray[0] = newDataItem;
        return 0;
    }

    //移除当前节点的最后一个数据项
    public DataItem removeDataItem() {
        DataItem delData = itemArray[numItems - 1];
        itemArray[numItems-1] = null;
        numItems--;
        return delData;
    }

    //把当前节点中的所有节点打印出来
    public void displayNode() {
        for (int i = 0; i < numItems; i++) {
            itemArray[i].displayItem();
        }
        System.out.println("/");
    }
}
