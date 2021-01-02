package linked;

import java.util.Iterator;

public class IteratorLinkTest {
    public static void main(String[] args) {
        LinkListWithIterator<Integer> link = new LinkListWithIterator<>();
        link.addHead(1);
        link.addHead(2);
        link.addHead(3);

        Iterator<Integer> iterator = link.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
