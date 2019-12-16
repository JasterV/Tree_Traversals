import java.util.NoSuchElementException;

public class LinkedBinaryTree<E> implements BinaryTree<E> {
    private Node<E> root;

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
        @SuppressWarnings("unchecked")
        public boolean equals(Object obj) {
            Node other = (Node) obj;
            return recEquals(this, other);
        }

        private boolean recEquals(Node<E> root1, Node<E> root2){
            if(root1 == null || root2 == null) return root1 == root2;
            return root1.elem.equals(root2.elem)
                    && recEquals(root1.left, root2.left)
                    && recEquals(root1.right, root2.right);
        }
    }

    public LinkedBinaryTree() {
        root = null;
    }

    public LinkedBinaryTree(E elem) {
        root = new Node<E>(elem, null, null);
    }

    public LinkedBinaryTree(E elem, LinkedBinaryTree<E> left, LinkedBinaryTree<E> right) {
        Node<E> leftNode = (left == null) ? null : left.root;
        Node<E> rightNode = (right == null) ? null : right.root;
        root = new Node<E>(elem, leftNode, rightNode);
    }

    private LinkedBinaryTree(Node<E> root) {
        this.root = root;
    }

    @Override
    public E elem() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return root.elem;
    }

    @Override
    public BinaryTree<E> left() {
        if (isEmpty())
            throw new NoSuchElementException();
        return new LinkedBinaryTree<>(root.left);
    }

    @Override
    public BinaryTree<E> right() {
        if (isEmpty())
            throw new NoSuchElementException();
        return new LinkedBinaryTree<>(root.right);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (!(obj instanceof LinkedBinaryTree))
            return false;
        LinkedBinaryTree<E> lb = (LinkedBinaryTree<E>) obj;
        if(root == null || lb.root == null) return root == lb.root;
        return root.equals(lb.root);
    }
}
