package recursion;

public class RecursionTest10 {
    public static void main(String[] args) {
        char[] arr = new char[]{'A', 'B', 'C', 'D', 'E'};
        Comb comb = new Comb(arr);
        comb.doComb(3,0);
    }
}

class Comb{
    private char[] persons;
    private boolean[] selects;

    public Comb(char[] data) {
        this.persons = data;
        selects = new boolean[data.length];
    }

    //具体实现组合的递归方法
    public void doComb(int selectNum, int index) {
        //边界
        if (selectNum == 0) { //找到
            for (int i = 0; i < selects.length; i++) {
                if (selects[i]) {
                    System.out.print(persons[i] + "  ");
                }
            }
            System.out.println();
            return;
        }

        if (index >= persons.length) {  //所有的组合都找完了
            return;
        }

        selects[index] = true;
        doComb(selectNum - 1, index + 1);
        selects[index] = false;
        doComb(selectNum,index+1);
    }
}
