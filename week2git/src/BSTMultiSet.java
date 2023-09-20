public class BSTMultiSet<T extends Comparable<T>> implements MultiSet<T>{

    // a multiset always starts empty, so we can directly instantiate our private attribute
    // here; no need to explicitly write a new constructor.
    private final BST<T> bst = new BST<>();

    @Override
    public void add(T item) {

    }

    @Override
    public void remove(T item) {

    }

    @Override
    public boolean contains(T item) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int count(T item) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    // TODO Task 1: hover the red squiggly on the first line and select 'Implement methods'.
    //              All listed methods should be selected. Press okay and then implement each
    //              method. As with the python version, this shouldn't require a lot of code to write.
    //              Hint: autocomplete will help as you look for the right bst methods to call.

}
