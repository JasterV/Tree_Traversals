import java.util.NoSuchElementException;

public class LinkedBinaryTree<E> implements BinaryTree<E> {
    private Node<E> root;

    /**
     * This class represents the internal linked nodes that every LinkedBinaryTree will contains as root
     */
    private static class Node<E> {
        E elem;
        Node<E> left;
        Node<E> right;

        Node(E elem, Node<E> left, Node<E> right) {
            this.elem = elem;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Node<?>)) return false;
            Node<?> other = (Node<?>) obj;
            return recEquals(this, other);
        }

        /**
         * This method recursively checks if two nodes and all his child's are equals
         * @param root1 The first Node
         * @param root2 The second Node
         * @return True if equals, otherwise false
         */
        private static boolean recEquals(Node<?> root1, Node<?> root2) {
            if (root1 == null || root2 == null) return root1 == root2;
            return root1.elem.equals(root2.elem)
                    && recEquals(root1.left, root2.left)
                    && recEquals(root1.right, root2.right);
        }
    }


    /**
     * Empty LinkedBinaryTree constructor
     */
    public LinkedBinaryTree() {
        root = null;
    }

    /**
     * A constructor that initialize an instance
     * from the element that will be stored into the root
     * @param elem The element of the root
     */
    public LinkedBinaryTree(E elem) {
        root = new Node<E>(elem, null, null);
    }

    /**
     * A constructor that initialize an instance from an element, left tree and right tree
     * @param elem The element to store into the root
     * @param left The left binary tree
     * @param right The right binary tree
     */
    public LinkedBinaryTree(E elem, LinkedBinaryTree<E> left, LinkedBinaryTree<E> right) {
        Node<E> leftNode = (left == null) ? null : left.root;
        Node<E> rightNode = (right == null) ? null : right.root;
        root = new Node<E>(elem, leftNode, rightNode);
    }

    /**
     * A private constructor to initialize an instance from the root Node
     * @param root the root node
     */
    private LinkedBinaryTree(Node<E> root) {
        this.root = root;
    }

    /**
     * A getter for the element stored into the root.
     * @return An object of type E
     */
    @Override
    public E elem() {
        if (isEmpty())
            throw new NoSuchElementException();
        return root.elem;
    }

    /**
     * A getter for the left binary tree
     * @return A BinaryTree
     */
    @Override
    public BinaryTree<E> left() {
        if (isEmpty())
            throw new NoSuchElementException();
        return new LinkedBinaryTree<>(root.left);
    }

    /**
     * A getter for the right binary tree
     * @return A BinaryTree
     */
    @Override
    public BinaryTree<E> right() {
        if (isEmpty())
            throw new NoSuchElementException();
        return new LinkedBinaryTree<>(root.right);
    }

    /**
     * Checks if the tree is empty
     * @return True if empty, otherwise false
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Checks if two LinkedBinaryTrees are equals
     * @param obj The object to compare
     * @return True if equals, otherwise false
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (!(obj instanceof LinkedBinaryTree))
            return false;
        LinkedBinaryTree<E> lb = (LinkedBinaryTree<E>) obj;
        return Node.recEquals(root, lb.root);
    }
}
