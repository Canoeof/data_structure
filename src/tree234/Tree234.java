package tree234;

/**
 * 实现234树的类
 */
public class Tree234 {
    private Node root;

    //初始化
    public Tree234() {
        root = new Node();
    }

    //实现搜索234树
    //找到了指定的数据，返回这个数据在节点中数据项数组中的索引，没找到返回-1
    public int find(int key) {
        Node current = root;
        int childNumber;
        while (true) {
            if ((childNumber = current.findItem(key)) != -1) {
                //在234树中找到了key
                return childNumber;
            } else if (current.isLeaf()) {
                //在234树中没有要找的数据项
                return -1;
            } else {
                //current指针向正确的子节点上移动
                current = getNextNode(current, key);
            }
        }
    }

    public Node getNextNode(Node theNode, int theValue) {
        int numItems = theNode.getNumItems();  //获取当前指定的节点中含有的数据项个数
        int i;
        for (i = 0; i < numItems; i++) {
            if (theValue < theNode.getItemArray()[i].data) {
                return theNode.getChild(i);
            }
        }
        //循环完毕后，都没有返回，证明theValue比当前节点中所有的数据项都大
        return theNode.getChild(i);
    }

    //实现新的数据项的插入
    public void insert(int insValue) {
        //找到insValue应该被插入的位置
        Node current = root;
        DataItem insDataItem = new DataItem(insValue);
        //遍历树
        while (true) {
            if (current.isFull()) {
                //节点分裂
                split(current);
                current = current.getParent();
                current = getNextNode(current, insValue);
            } else if (current.isLeaf()) {
                //此时的节点不是满节点，且是叶子节点，就是我们的目标
                break;
            } else {
                //不是满节点，也不是叶子节点,继续循环往下遍历
                current = getNextNode(current,insValue);
            }
        }
        current.insertItem(insDataItem); //往目标节点中插入数据项

    }

    //实现节点分裂
    public void split(Node theNode) {
        DataItem itemB;
        DataItem itemC;
        Node child2;  //第三个子节点，索引2
        Node child3;  //第四个子节点，索引3
        Node parent;

        //把上面的四个单位分离出来
        itemC = theNode.removeDataItem();
        itemB = theNode.removeDataItem();
        child2 = theNode.disconnectChild(2);
        child3 = theNode.disconnectChild(3);

        //在右边新建一个节点
        Node rightNewNode = new Node();

        if (theNode == root) {
            //根节点分裂
            root = new Node();
            parent = root;
            root.connectChild(0, theNode);
        } else {
            //不是根节点
            parent = theNode.getParent();
        }

        //不管是根节点还是非根节点，都拿到要分裂节点的父节点，处理父节点
        //首先把分裂节点的B数据插入到父节点
        int itemBinParentIndex = parent.insertItem(itemB);

        //考虑到父节点原本两个数据项的情况，改动原本的子节点对应的索引值
        int n = parent.getNumItems();  //B数据项插入到父节点后，父节点的新数据项个数
        Node tmp;
        for (int i = n - 1; i > itemBinParentIndex; i--) {
            tmp = parent.disconnectChild(i);
            parent.connectChild(i+1,tmp);
        }

        //处理右边新的节点
        //itemC放到新节点
        rightNewNode.insertItem(itemC);
        parent.connectChild(itemBinParentIndex + 1, rightNewNode);  //rightChild链接到父节点
        rightNewNode.connectChild(0, child2);
        rightNewNode.connectChild(1,child3);
    }

    //用递归，将234树所有节点值打印输出
    public void recursionDisplayTree(Node thisNode, int level, int childNum) {
        System.out.println("level=" + level + " child:" + childNum);
        thisNode.displayNode();
        int numItems = thisNode.getNumItems();
        for (int i = 0; i < numItems; i++) {
            Node childNode = thisNode.getChild(i);
            if (childNode == null) {
                return;
            } else {
                recursionDisplayTree(childNode, level + 1, i);
            }
        }
    }

    //输出树中所有的节点
    public void displayTree() {
        recursionDisplayTree(root,0,0);
    }
}
