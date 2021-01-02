package array;

/**
 * 稀疏数组的压缩算法
 */
public class ArrayTest6 {
    public static void main(String[] args) {
        //压缩算法
        Node[] arr1 = new Node[6];
        arr1[0] = new Node(9, 7, 5);
        arr1[1] = new Node(1, 1, 3);
        arr1[2] = new Node(3, 0, 1);
        arr1[3] = new Node(3, 1, 4);
        arr1[4] = new Node(4, 2, 7);
        arr1[5] = new Node(5, 5, 5);

        System.out.println("对压缩后的数组进行读操作");

        for (int i = 0; i < arr1[0].getRow(); i++) {
            for (int j = 0; j < arr1[0].getCol(); j++) {
                //判断当前(i,j)坐标，有没有有效内容，输出，没有输出0
                int k;
                for (k = 1; k < arr1.length; k++) {
                    if (arr1[k].getRow() == i && arr1[k].getCol() == j)
                        break;
                }
                if (k < arr1.length) { //证明这里存在有效值
                    System.out.print(arr1[k].getVal() + "    ");
                } else {
                    System.out.print("0    ");
                }
            }
            System.out.println();
        }
     }
}

class Node{
    private int row;
    private int col;
    private long val;

    //初始化

    public Node(int row, int col, long val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public long getVal() {
        return val;
    }
}