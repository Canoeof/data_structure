package tree;

/**
 * 二叉树基本的类结构
 */
public class BinaryTree {
    private Node root;

    public BinaryTree() {
        root = null;
    }

    //查找某个节点
    public Node find(int data) {
        Node current = root;
        while (current != null) { //当前节点不是null的时候，才继续循环
            if (data < current.getData()) {
                current = current.getLeftChild();
            } else if (data > current.getData()) {
                current = current.getRightChild();
            } else {
                return current;
            }
        }
        //循环完了，current==null说明树里根本没有我们要找的节点
        return null;
    }

    //插入节点
    public void insert(int data) {
        Node newNode = new Node(true,data,null,null,null);
        if (root == null) {
            root = newNode;
            root.setColor(false);
            return;
        } else {
            Node current = root;
            Node parentNode = null;
            while (current != null) {
                parentNode = current;
                if (data < current.getData()) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parentNode.setLeftChild(newNode);
                        newNode.setParent(parentNode);
                    }
                } else {
                    current = current.getRightChild();
                    if (current == null) {
                        parentNode.setRightChild(newNode);
                        newNode.setParent(parentNode);
                    }
                }
            }
        }

        //新的节点插入以后可能会破坏树的平衡，检查红黑规则秒如果不符合，纠正
        insertFixup(newNode);
    }

    //实现红黑树的自我修正
    private void insertFixup(Node node) {
        Node parent;
        Node grandfather;
        Node uncle;

        //修正违反红黑规则的节点
        while (((parent = node.getParent()) != null) && parent.isColor()) {
            //不能直接拿到叔叔节点，先拿到祖父节点
            grandfather = parent.getParent();

            //判断node是父节点的左子节点还是右子节点
            if (parent == grandfather.getLeftChild()) {
                uncle = grandfather.getRightChild();

                //细分情况
                //第一张情况，parent是红的，uncle也是红的
                if (uncle != null && uncle.isColor()) {
                    parent.setColor(false);
                    uncle.setColor(false);
                    grandfather.setColor(true);
                    node = grandfather;
                    continue;
                }

                //第二种情况
                //parent是红的，uncle是黑的，node在parent的右边
                if (node == parent.getRightChild()) {
                    leftRotate(parent);
                    Node temp = parent;
                    parent = node;
                    node = temp;
                }

                //第三种情况
                //parent是红的，uncle是黑的，node在parent的左边
                parent.setColor(false);
                grandfather.setColor(true);
                rightRotate(grandfather);
            } else {
                uncle = grandfather.getLeftChild();

                //第一种情况
                if (uncle != null && uncle.isColor()) {
                    parent.setColor(false);
                    uncle.setColor(false);
                    grandfather.setColor(true);
                    node = grandfather;
                    continue;
                }

                //第二种情况
                //parent是红的，uncle是黑的，node在parent的左边
                if (node == parent.getLeftChild()) {
                    rightRotate(parent);
                    Node temp = parent;
                    parent = node;
                    node = temp;
                }

                //第三种情况
                //parent是红的，uncle是黑的，node在parent的右边
                parent.setColor(false);
                grandfather.setColor(true);
                leftRotate(grandfather);
            }
        }
    }

    //遍历节点
    //中序遍历
    public void midOrder(Node current) {
        //先左
        if (current == null) {
            return;
        } else {
            midOrder(current.getLeftChild());
            System.out.println(current.getData());
            midOrder(current.getRightChild());
        }
    }

    //前序遍历
    public void preOrder(Node current) {
        if (current == null) {
            return;
        } else {
            System.out.println(current.getData());
            preOrder(current.getLeftChild());
            preOrder(current.getRightChild());
        }
    }

    //后序遍历
    public void afterOrder(Node current) {
        if (current == null) {
            return;
        } else {
            afterOrder(current.getLeftChild());
            afterOrder(current.getRightChild());
            System.out.println(current.getData());
        }
    }

    //查找最大值和最小值
    public Node getMaxNode() {
        Node current = root;
        Node maxNode = current;
        while (current != null) {
            maxNode = current;
            current = current.getRightChild();
        }
        return maxNode;
    }

    public Node getMinNode() {
        Node current = root;
        Node minNode = current;
        while (current != null) {
            minNode = current;
            current = current.getLeftChild();
        }
        return minNode;
    }

    //删除节点
    public boolean delete(int data) {
        //找到要删除的节点
        Node current = root;
        Node parent = null;
        boolean isLeftChild = false;  //判断当前节点是其父节点的左孩子还是右孩子
        while (current.getData() != data) {
            parent = current;
            if (data < current.getData()) {
                current = current.getLeftChild();
                isLeftChild = true;
            } else {
                current = current.getRightChild();
                isLeftChild = false;
            }
            if (current == null) {  //树里根本没有要删除的节点
                return false;  //结束方法，循环结束
            }
        }
        //正常循环结束，找到了要删除的节点

        //删除找到的节点
        if (current.getLeftChild() == null && current.getRightChild() == null) { //要删除节点是叶子节点
            if (current == root) {
                root = null;
            } else {
                if (isLeftChild) {  //当前节点是父节点的左孩子
                    parent.setLeftChild(null);
                } else {
                    parent.setRightChild(null);
                }
            }
            return true;
        } else if (current.getLeftChild() != null && current.getRightChild() == null) {
            if (current == root) {
                root = current.getLeftChild();
            } else {
                if (isLeftChild) {
                    parent.setLeftChild(current.getLeftChild());
                } else {
                    parent.setRightChild(current.getLeftChild());
                }
            }
            return true;
        } else if (current.getLeftChild() == null && current.getRightChild() != null) {
            if (current == root) {
                root = current.getRightChild();
            } else {
                if (isLeftChild) {
                    parent.setLeftChild(current.getRightChild());
                } else {
                    parent.setRightChild(current.getRightChild());
                }
            }
            return true;
        } else { //要删除的节点有两个子节点的情况
            //先找到要被删除的节点的右子树中的最小节点
            Node replaceNode = getReplaceNode(current);

            if (current == root) {
                root = replaceNode;
            } else {
                if (isLeftChild) {
                    parent.setLeftChild(replaceNode);
                } else {
                    parent.setRightChild(replaceNode);
                }
            }
            replaceNode.setLeftChild(current.getLeftChild());
            return true;
        }
    }

    public Node getReplaceNode(Node delNode) {
        Node replaceNode = delNode;
        Node replaceNodeParent = delNode;
        Node grnCurrent = delNode.getRightChild();

        while (grnCurrent != null) {
            replaceNodeParent = replaceNode;
            replaceNode = grnCurrent;
            grnCurrent = grnCurrent.getLeftChild();
        }

        if (replaceNode != delNode.getRightChild()) {
            replaceNodeParent.setLeftChild(replaceNode.getRightChild());
            replaceNode.setRightChild(delNode.getRightChild());
        }
        return replaceNode;   //我们要找的右子树中的最小节点
    }

    //左旋
    private void leftRotate(Node x) {
        //把Y节点的左子节点变成x的右子节点
        Node y = x.getRightChild();
        x.setRightChild(y.getLeftChild());  //把y节点的左子节点赋值给x的右子节点
        if (y.getLeftChild() != null) {
            y.getLeftChild().setParent(x);
        }

        //把x的父节点变成y的父节点
        y.setParent(x.getParent());
        if (x.getParent() == null) {  //x是根节点
            root = y;
        } else {
            if (x == x.getParent().getLeftChild()) {
                x.getParent().setLeftChild(y);
            } else {
                x.getParent().setRightChild(y);
            }
        }

        //y的左子节点变成x,y变成x的父节点
        y.setLeftChild(x);
        x.setParent(y);
    }

    //右旋
    private void rightRotate(Node y) {
        Node x = y.getLeftChild();
        //把x的右子节点变成y的左子节点
        y.setLeftChild(x.getRightChild());
        if(x.getRightChild()!=null) {
            x.getRightChild().setParent(y);
        }

        //把y的父节点变成x的父节点
        x.setParent(y.getParent());
        if (y.getParent() == null) {
            root = x;
        } else {
            if (y == y.getParent().getLeftChild()) {
                y.getParent().setLeftChild(x);
            } else {
                y.getParent().setRightChild(x);
            }
        }

        //把y变成x的右子节点，y的父节点设为x
        x.setRightChild(y);
        y.setParent(x);
    }
}
