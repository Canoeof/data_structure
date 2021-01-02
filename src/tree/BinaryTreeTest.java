package tree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(40);
        bt.insert(36);
        bt.insert(37);
        bt.insert(85);
        bt.insert(49);
        bt.insert(88);

        Node root = bt.find(40);

        bt.midOrder(root);

        System.out.println();

        bt.delete(85);

        bt.midOrder(root);
    }
}
