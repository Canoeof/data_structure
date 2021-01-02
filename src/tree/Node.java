package tree;

public class Node {
    private int data;
    private Node leftChild;
    private Node rightChild;
    //把普通的二叉树升级为红黑树
    private boolean color;  //添加一个颜色的属性，true表示红色，false表示黑色
    private Node parent;   //该节点的父节点

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node() {}

    public Node(int data) {
        this.data = data;
    }

    public Node(boolean color,int data, Node leftChild, Node rightChild,  Node parent) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.color = color;
        this.parent = parent;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                ", color=" + color +
                ", parent=" + parent +
                '}';
    }
}
