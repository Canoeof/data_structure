package linked;

public class QueueDoublelinkedListTest {
    public static void main(String[] args) {
        QueueDoubleLinkedList queueDoubleLinkedList = new QueueDoubleLinkedList();
        queueDoubleLinkedList.insert(1);
        queueDoubleLinkedList.insert(2);
        queueDoubleLinkedList.insert(3);
        System.out.println(queueDoubleLinkedList.delete());
        queueDoubleLinkedList.display();
    }
}

class QueueDoubleLinkedList{
    private DoubleLinkedList doubleLinkedList;

    public QueueDoubleLinkedList() {
        doubleLinkedList = new DoubleLinkedList();
    }

    public void insert(Object data) {
        doubleLinkedList.addTail(data);
    }

    public Object delete() {
        return doubleLinkedList.deleteHead();
    }

    public boolean isEmpty() {
        return doubleLinkedList.isEmpty();
    }

    public int getSize() {
        return doubleLinkedList.getSize();
    }

    public void display() {
        doubleLinkedList.display();
    }
}