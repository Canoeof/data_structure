package tree234;

public class Tree234Test {
    public static void main(String[] args) {
        Tree234 tree234 = new Tree234();
        tree234.insert(20);
        tree234.insert(22);
        tree234.insert(15);
        tree234.insert(98);
        tree234.insert(45);
        tree234.insert(6);

        tree234.displayTree();
    }
}
