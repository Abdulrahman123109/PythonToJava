public class BSTMultiSet<T extends Comparable<T>> implements MultiSet<T>{

    // a multiset always starts empty, so we can directly instantiate our private attribute
    // here; no need to explicitly write a new constructor.
    private final BST<T> bst = new BST<>();

    @Override
    public void add(T item) {
        this.bst.insert(item);
    }

    @Override
    public void remove(T item) {
        this.bst.delete(item);
    }

    @Override
    public boolean contains(T item) {
        return this.bst.contains(item);
    }

    @Override
    public boolean isEmpty() {
        return this.bst.isEmpty();
    }

    @Override
    public int count(T item) {
        return this.bst.count(item);
    }

    @Override
    public int size() {
        return this.bst.getLength();
    }

    // TODO Task 1: hover the red squiggly on the first line and select 'Implement methods'.
    //              All listed methods should be selected. Press okay and then implement each
    //              method. As with the python version, this shouldn't require a lot of code to write.
    //              Hint: autocomplete will help as you look for the right bst methods to call.

}
