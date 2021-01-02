package recursion;

public class RecursionTest4 {
    public static void main(String[] args) {
        move(3,"A","B","C");
    }

    public static void move(int dish, String from, String tmp, String to) {
        if (dish == 1) {
            System.out.println("将第" + dish + "个盘子从" + from + "移动到目标塔座" + to);
        } else {
            move(dish - 1, from, to, tmp);
            System.out.println("将第" + dish + "个盘子从" + from + "移动到目标塔座" + to);
            move(dish - 1, tmp, from, to);
        }
    }
}
