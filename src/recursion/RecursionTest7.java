package recursion;

import java.util.Stack;

public class RecursionTest7 {
    public static void main(String[] args) {
        System.out.println(addn(3));
        System.out.println(addn1(3));
    }

    //求1+2+3+...+n的值，递归
    public static int addn(int n) {
        if (n == 1) {
            return n;
        }else {
            return n + addn(n - 1);
        }
    }

    //消除递归，依靠栈来消除
    public static int addn1(int n) {
        Stack<Params> stack = new Stack<>();
        int currentReturnValue = 0;
        int currentReturnAddress = 1;
        Params params = null;

        boolean flag = true;
        while (flag ) {
            switch (currentReturnAddress) {
                //初始的参数封装为Params对象，压入栈，设置一下走的分支地址是第二分支
                case 1:
                    params = new Params(n, 6);
                    stack.push(params);
                    currentReturnAddress = 2;
                    break;
                //模拟递归算法的边界条件，满足边界条件，把值赋给currentReturnValur，设定下一跳为5，否则设定下一条为3
                case 2:
                    params = stack.peek();
                    if (params.getN() == 1) {
                        currentReturnValue = params.getN();
                        currentReturnAddress = 5;
                    }else {
                        currentReturnAddress = 3;
                    }
                    break;
                 //模拟递归，n-1作为新的参数压入栈，参数对象返回地址4，设置下一跳：2
                case 3:
                    params = stack.peek();
                    params = new Params(params.getN()-1,4);
                    stack.push(params);
                    currentReturnAddress = 2;
                    break;
                //将栈中的参数对象取出，将要获得的值做叠加操作，跳转步骤5
                case 4:
                    params = stack.peek();
                    currentReturnValue += params.getN();
                    currentReturnAddress = 5;
                    break;
                //把前面第四分支已经叠加过的参数，从栈中删除，如果栈中的参数删除完了，根据参数对象的返回地址，设定下一跳地址
                case 5:
                    params = stack.pop();
                    currentReturnAddress = params.getReturnAddress();
                    break;
                 //完成运算，结束while循环,等同于递归完毕
                case 6:
                    flag = false;
            }

        }
        return currentReturnValue;
    }
}

//写一个封装参数的类
class Params{
    private int n;
    private int returnAddress;  //返回地址

    public Params(int n, int address) {
        this.n = n;
        this.returnAddress = address;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setReturnAddress(int returnAddress) {
        this.returnAddress = returnAddress;
    }

    public int getN() {
        return n;
    }

    public int getReturnAddress() {
        return returnAddress;
    }
}