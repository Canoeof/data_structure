package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackTest2 {
    public static void main(String[] args) {
        SeniorStack seniorStack = new SeniorStack();
        seniorStack.push(1);
        seniorStack.push(2);
        seniorStack.push(3);
        seniorStack.push(4);
        seniorStack.push(5);
        seniorStack.push(6);
        seniorStack.push(7);
        seniorStack.push(8);
        seniorStack.push(9);
        seniorStack.push(10);
        seniorStack.push(11);
        seniorStack.push(12);
        seniorStack.push(13);
        seniorStack.push(14);
        seniorStack.push(15);
        seniorStack.push(16);

        System.out.println(seniorStack.peek());

        while(!seniorStack.isEmpty()) {
            System.out.print(seniorStack.pop() + "  ");
        }
    }
}

class SeniorStack{
    private Object[] elemData;
    private int maxSize;
    private int top;

    //初始化
    public SeniorStack() {
        elemData = new Object[10];
        this.maxSize = 10;
        top = -1;
    }

    //压栈
    public void push(Object data) {
        if((top+1) == maxSize) { //栈满
            if((maxSize << 1) - Integer.MAX_VALUE > 0) {
                maxSize = Integer.MAX_VALUE;
            }else {
                maxSize = maxSize << 1;
            }

            //扩容
            elemData = Arrays.copyOf(elemData, maxSize);
        }

        elemData[++top] = data;
    }

    //获取栈顶元素值
    public Object peek() {
        if(top == -1) {
            throw new EmptyStackException();
        }
        return elemData[top];
    }

    //出栈
    public Object pop() {
        Object object = peek();
        elemData[top] = null;
        this.top--;
        return object;
    }

    //判断是不是空栈
    public boolean isEmpty() {
        return (top == -1);
    }

    //判断是不是满栈
    public boolean isFull() {
        return (top == (maxSize - 1));
    }

}
