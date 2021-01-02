package stack;

public class StackTest1 {
    public static void main(String[] args) {
        LowerStack lowerStack = new LowerStack(3);
        lowerStack.push(1);
        lowerStack.push(2);
        lowerStack.push(3);

        while(!lowerStack.isEmpty()) {
            System.out.println(lowerStack.pop());
        }
    }
}

//模拟栈的数据结构
class LowerStack{
    private long[] elemData;  //栈内部封装的数组，用来存储压入栈内的元素
    private int maxSize;   //栈的长度
    private int top;   //栈顶指针，始终指向栈顶上第一个元素，栈是空栈，默认为-1

    //初始化栈
    public LowerStack(int size) {
        this.maxSize = size;
        elemData = new long[size];
        top = -1;
    }

    //实现压栈
    public void push(long data) {
        //判断栈满
        if(top != (maxSize - 1)) {
            elemData[++top] = data;
        }
    }

    //出栈
    public long pop() {
        return elemData[top--];
    }

    //读取栈顶元素
    public long peek() {
        return elemData[top];
    }

    //判断栈是否是空栈
    public boolean isEmpty() {
        return (top == -1);
    }

    //判断栈是否是满栈
    public boolean isFull() {
        return (top == (maxSize - 1));
    }
}
