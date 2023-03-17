public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    public Node<Key, Value> root;

    public BinarySearchTree() {

    }

    public int size() {
        return size(root);
    }

    //use Node's recursive size
    private int size(Node x) {
        if (x == null){ //if node is null, search has reached a leaf
            return 0;
        } else {
            return (1 + size(x.getLeft()) + size(x.getRight())); //add one to account for curr node and add size of its right/left branch
        }
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    //recursive put wrapper
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    //recursive put
    //sets left/right or creates a new node appropriately, returns the
    //modified node n
    private Node<Key, Value> put(Node<Key, Value> n, Key key, Value val) {
        if (n == null) { //if the current node doesn't exist, assign the key and val to a new node at the right location
            n = new Node<>(key, val, 1);
        } else {
            if (n.getKey().compareTo(key) >= 1){ //if current key is greater than key, move to the left
                n.setLeft(put(n.getLeft(), key, val)); //return left node, traverse left
            } else { //if current key is less than or equal to key, move to the right
                n.setRight(put(n.getRight(), key, val)); //return right node, traverse right
            }
        }
        return n;
    }

    //recursive get wrapper
    public Value get(Key key) {
        return get(root, key);
    }

    //recursive get
    //returns null if the key does not exist
    private Value get(Node<Key, Value> n, Key key) {
        if (isEmpty() || n == null){ //if the tree is empty or the search has ended at a leaf, return null b/c key doesn't exist
            return null;
        } else if (key == n.getKey()){ //when n's key matches up, return the value at that node
            return n.getValue();
        } else if (n.getKey().compareTo(key) >= 1) { //if current key is greater than key, move to the left
            return get(n.getLeft(), key);
        } else { //otherwise, current key is less than or equal to the key, move right
            return get(n.getRight(), key);
        }
    }

    public boolean contains(Key key) {
        return (get(key) != null);
    }

    public Value remove(Key key) {
        Value v = get(key);
        root = remove(root, key);
        return v;
    }

    private Node remove(Node<Key, Value> n, Key key) {
        if (n == null) return null;
        int i = key.compareTo(n.getKey());
        if (i < 0) {
            n.setLeft(remove(n.getLeft(), key));
        } else if (i > 0) {
            n.setRight(remove(n.getRight(), key));
        } else {
            if (n.getRight() == null) return n.getLeft();
            if (n.getLeft() == null) return n.getRight();
            Node min = min(n.getRight());
            min.setLeft(n.getLeft());
            n = n.getRight();
        }
        n.setSize(size(n.getRight()) + size(n.getLeft()) + 1);
        return n;
    }

    public Key min() {
        return min(root).getKey();
    }

    //returns the node at the left most left branch of n
    private Node<Key, Value> min(Node<Key, Value> n) {
        if (n.getLeft() == null){
            return n;
        } else {
            return min(n.getLeft());
        }
    }

    public Key max() {
        return max(root).getKey();
    }

    //returns the node at the right most right branch of n
    private Node<Key, Value> max(Node<Key, Value> n) {
        if (n.getRight() == null){
            return n;
        } else {
            return max(n.getRight());
        }
    }

    public String toString() {
        String temp = toString(root);
        temp = temp.substring(0, temp.length() - 2);
        return "{" + temp + "}";
    }

    private String toString(Node<Key, Value> n) {
        if (n == null) return "";
        return toString(n.getLeft()) +
                n.getKey() + "=" + n.getValue() + ", " +
                toString(n.getRight());

    }
}