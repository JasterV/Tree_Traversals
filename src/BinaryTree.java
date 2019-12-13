public interface BinaryTree<E> {
    E elem();
    BinaryTree<E> left();
    BinaryTree<E> right();
    boolean isEmpty();
}
