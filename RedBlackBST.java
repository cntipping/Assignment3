public class RedBlackBST<Key extends Comparable<Key>, Value>{

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{
        String productID;
        Product product;
        Node left, right, parent;
        boolean color;

        Node(String productID, Product product){
            this.productID = productID;
            this.product = product;
            this.color = RED;
        }
    }

    private Node root;

    private boolean isRed(Node h);
    private Node rotateLeft(Node h) {}
    private Node rotateRight(Node h) {}
    private void flipColors(Node h) {}

    private int size();

    public void put(Key key, Value value) {
        /* Begins the insertion recursive call */
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value value) {
        /* Actual insertion and tree balance maintenance */
        if(h == null) return new Node(key, val, 1, RED);

        int cmp = key.compareTo(h.key);
        if(cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    private boolean isRed(Node h){
        /* returns true if red, false if black*/
        if(h == null) return false;
        return h.color == RED;
    }

    private Node rotateLeft(Node h){
        /* Rotate when there is a right red link
        * moves right child up, current node down left*/
       Node x = h.right;
       h.right = x.left;
       if(x.left != null) x.left.parent = h;
       x.left = h;
       x.color = h.color;
       h.color = RED;
       x.parent = h.parent;
       h.parent = x;
       return x;
    }

    private Node rotateRight(Node h){
        /* Rotate when there is a left red link (grandchild) following another left red link (child)
        * moves the left child up and current node down right*/
        Node x = h.left;
        h.left = x.right;
        if (x.right != null) x.right.parent = h;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.parent = h.parent;
        h.parent = x;
        return x;
    }

    private void flipcolors(Node h) {
        /* Used in the case of two red children */
        h.color = RED;
        if (h.left != null) h.left.color = BLACK;
        if (h.right != null) h.right.color = BLACK;
    }

    public Value get(Key key){
        /* Searches for key, return associated value */
        Node x = get(root, key);
        if(x == null) return null;
        return x.product;
    }

    private Node get(Node h, Key key){
        while (h != null) {
            int cmp = key.compareTo(h.productID);
            if(cmp < 0) h = h.left;
            else if(cmp > 0) h = h.right;
            else return h;
        }
        return null;
    }
}
