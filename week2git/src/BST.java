import static sun.swing.MenuItemLayoutHelper.max;

/**
 * A minimal implementation of a binary search tree. See the python version for
 * additional documentation.
 *
 * You can also see Chapter 6 of <a href="https://www.teach.cs.toronto.edu/~csc148h/winter/notes/">CSC148 Course Notes</a>
 * if you want a refresher on BSTs, but it is required to complete this assignment.
 * @param <T>
 */
public class BST<T extends Comparable<T>> {
    //Note: the extends Comparable<T> above means we require T to implement the Comparable<T> interface,
    //      since a BST requires that we can compare its elements to determine the ordering.
    private T root;

    private BST<T> left;
    private BST<T> right;

    public BST(T root) {
        if (root != null) { // check to ensure we don't accidentally try to store null at the root!
            this.root = root;
            this.left = new BST<>();
            this.right = new BST<>();
        }
        // Note: each of the attributes will default to null
    }

    /**
     * Alternate constructor, so we don't have to explicitly pass in null.
     */
    public BST() {
        this(null);
    }


    // TODO Task 2: Implement the BST methods.

    public boolean isEmpty() {
        // TODO implement me!
        return this.root == null;
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
        // TODO implement me!
        if (this.isEmpty()){
            BST<T> Newroot = new BST<>();
            BST<T> Newright = new BST<>();
            BST<T> Newleft = new BST<>();
            Newroot = (BST<T>) item;
            Newright = null;
            Newleft = null;
            this.root = (T) Newroot;
            this.left = null;
            this.right = null;
        } else if (item.compareTo(this.root) <= 0){
            this.left.insert(item);
        }
        else{
            this.right.insert(item);
        }
    }


    public void delete(T item) {
        // TODO implement me!
        if (this.isEmpty()){
            ;
        }
        else if(this.root == item){
            this.deleteRoot();
        } else if (item.compareTo(this.root) < 0) {
            this.left.delete(item);
        }else{
            this.right.delete(item);
        }
    }

    private void deleteRoot() {
        // TODO implement me!
        if (this.left.isEmpty() && this.right.isEmpty()){
            this.root = null;
            this.right = null;
            this.left = null;
        }else if (this.left.isEmpty()){
            BST<T> Newroot = new BST<>();
            BST<T> Newright = new BST<>();
            BST<T> Newleft = new BST<>();
            Newroot = (BST<T>) this.right.root;
            Newright = this.right.right;
            Newleft = this.right.left;
            this.root = (T) Newroot;
            this.right = Newright;
            this.left = Newleft;
        } else if (this.right.isEmpty()) {
            BST<T> Newroot = new BST<>();
            BST<T> Newright = new BST<>();
            BST<T> Newleft = new BST<>();
            Newroot = (BST<T>) this.left.root;
            Newright = this.left.right;
            Newleft = this.left.left;
            this.root = (T) Newroot;
            this.right = Newright;
            this.left = Newleft;
        }else{
            this.root = this.left.extractMax();
        }
    }


    private T extractMax() {
        // TODO implement me!
        if (this.right.isEmpty()){
            BST<T> max_item = new BST<>();
            max_item = (BST<T>) this.root;
            BST<T> Newroot = new BST<>();
            BST<T> Newright = new BST<>();
            BST<T> Newleft = new BST<>();
            Newroot = (BST<T>) this.left.root;
            Newright = this.left.right;
            Newleft = this.left.left;
            this.root = (T) Newroot;
            this.right = Newright;
            this.left = Newleft;
            return (T) max_item;
        }else{
            return this.right.extractMax();
        }
        // dummy code; replace with correct code when you implement this.
    }

    public int height() {
        // TODO implement me!
        if(this.isEmpty()){
            return 0;
        }else{
            return max(this.left.height(), this.right.height()) + 1;
        }
    }

    public int count(T item) {
        // TODO implement me!
        if (this.isEmpty()){
            return 0;
        } else if (this.root.compareTo(item)>0) {
            return this.left.count(item);
        } else if ( this.root == item) {
            return 1 + this.left.count(item) + this.right.count(item);
        }else{
            return this.right.count(item);
        }

    }

    public int getLength() {
        // TODO implement me!
        if(this.isEmpty()){
            return 0;
        }
        else{
            return 1 + this.left.getLength() + this.right.getLength();
        }
    }

    public static void main(String[] args) {
        // TODO you can write any code you want here and run this file to confirm that
        //      your code is working as it should. We will not run this when testing your code.
    }

}
