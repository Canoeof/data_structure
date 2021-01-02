package recursion;

public class RecursionTest9 {
    public static void main(String[] args) {
        int[] arr = new int[]{11, 8, 7, 6, 5};
        Knapsack knapsack = new Knapsack(arr);
        knapsack.doKnapsack(22,0);
    }
}

//解决背包问题的类
class Knapsack{
    private int[] data;  //用来被选择的数据项组成的数组
    private boolean[] selects;  //这个数组和上面的数组的长度是一样的，true表示被选中

    //初始化上面的属性
    public Knapsack(int[] data) {
        this.data = data;
        selects = new boolean[data.length];
    }

    //解决背包问题的方法
    public void doKnapsack(int aim, int index) {
        //边界条件
        if (aim != 0 && index >= data.length) {
            return;  //所有的组合都测试了，没有找到
        }

        if (aim == 0) { //找到了
            for (int i = 0; i < selects.length; i++) {
                if (selects[i]) {
                    System.out.print(data[i] + "  ");
                }
            }
            System.out.println();
            return;
        }

        selects[index] = true;
        doKnapsack(aim-data[index],index+1);
        selects[index] = false;
        doKnapsack(aim,index+1); //上面的数据放进背包里对应的所有的组合都不对，从下一个数据项重来
    }
}