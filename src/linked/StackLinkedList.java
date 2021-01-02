package linked;

/**
 * 链表实现栈
 */
public class StackLinkedList {
    public static void main(String[] args) {
        StackSingleLinkedList stackSingleLinkedList = new StackSingleLinkedList();
        stackSingleLinkedList.push(1);
        stackSingleLinkedList.push(2);
        stackSingleLinkedList.push(3);

        System.out.println(stackSingleLinkedList.pop());
    }
}

class StackSingleLinkedList {
    private SingleLinkedList link;

    public StackSingleLinkedList() {
        link = new SingleLinkedList();
    }

    //压栈
    public void push(Object data) {
        link.addHead(data);
    }

    //出栈
    public Object pop() {
        return link.deleteHead();
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return link.isEmpty();
    }

    //打印
    public void display() {
        link.display();
    }

}