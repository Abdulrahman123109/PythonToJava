/**
 * A minimal implementation of a binary search tree. See the python version for
 * additional documentation.
 * <p>
 * You can also see Chapter 6 of <a href="https://www.teach.cs.toronto.edu/~csc148h/winter/notes/">CSC148 Course Notes</a>
 * if you want a refresher on BSTs, but it is required to complete this assignment.
 *
 * @param <T>
 */
public class BST<T extends Comparable<T>> {
    //Note: the extends Comparable<T> above means we require T to implement the Comparable<T> interface,
    //      since a BST requires that we can compare its elements to determine the ordering.
    private T root;

    private BST<T> left;
    private BST<T> right;

    public BST(T root) {
        if (root != null) {
            this.root = root;
            this.left = new BST<>();
            this.right = new BST<>();
        }
    }

    public BST() {
        this.root = null;
        this.left = null;
        this.right = null;
    }

    public boolean isEmpty() {
        return (this.root == null);
    }

    public boolean contains(T item) {
        // provided
        if (this.isEmpty()) {
            return false;
        } else if (item.equals(this.root)) { // we need to use .equals and not == to properly compare values
            return true;
        } else if (item.compareTo(this.root) < 0) {
            return this.left.contains(item);
        }
        return this.right.contains(item);

    }


    public void insert(T item) {
        if (this.isEmpty()) {
            this.root = item;
            this.left = new BST<>();
            this.right = new BST<>();
        } else if (item.compareTo(this.root) <= 0) {
            this.left.insert(item);
        } else {
            this.right.insert(item);
        }
    }


    public void delete(T item) {
        if (this.isEmpty()) {
            ;
        } else if (this.root == item) {
            this.deleteRoot();
        } else if (item.compareTo(this.root) < 0) {
            this.left.delete(item);
        } else {
            this.right.delete(item);
        }

    }

    private void deleteRoot() {
        if (this.left == null || this.right == null) {
            ;
        } else if (this.left.isEmpty() && this.isEmpty()) {
            this.root = null;
        } else if (this.left.isEmpty()) {
            this.root = this.right.root;
            this.left = this.right.left;
            this.right = this.right.right;
        } else if (this.right.isEmpty()) {
            this.root = this.left.root;
            this.right = this.left.right;
            this.left = this.left.left;
        } else {
            this.root = this.left.extractMax();
        }
    }


    private T extractMax() {
        if (this.right.isEmpty()) {
            T max_item = this.root;
            this.deleteRoot();
            return (max_item);
        } else {
            return (this.right.extractMax());
        }
    }

    public int height() {
        if (this.isEmpty()) {
            return (0);
        } else {
            return (Math.max(this.left.height(), this.right.height()) + 1);
        }
    }

    public int count(T item) {
        if (this.isEmpty()) {
            return (0);
        } else if (this.root.compareTo(item) > 0) {
            return (this.left.count(item));
        } else if (this.root.equals(item)) {
            return (1 + this.left.count(item) + this.right.count(item));
        } else {
            return (this.right.count(item));
        }
    }

    public int getLength() {
        if (this.isEmpty()) {
            return (0);
        } else {
            return (1 + this.left.getLength() + this.right.getLength());
        }
    }

    public static void main(String[] args) {
        BST<Integer> tree1 = new BST<>(1);
        BST<Integer> tree2 = new BST<>(3);
        BST<Integer> tree3 = new BST<>(5);
        BST<Integer> tree4 = new BST<>(4);
        BST<Integer> tree5 = new BST<>(10);
        tree2.left = tree1;
        tree2.right = tree3;
        tree3.left = tree4;
        tree3.right = tree5;
        //        tree2(3)
        //   tree1(1)   tree3(5)
        //           tree4(4)  tree5(10)
        tree3.deleteRoot();
        System.out.println(tree3.root);
    }

}
