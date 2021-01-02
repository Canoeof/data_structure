package linked;

import java.util.Iterator;

public interface LIstWithIteratorInterface<T> extends ListInterface<T> {
    //获取迭代器的方法
    public Iterator<T> getIterator();
}
