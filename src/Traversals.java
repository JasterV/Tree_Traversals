import java.util.List;

public interface Traversals {
    <E> List<E> preOrder(BinaryTree<E> tree);
    <E> List<E> inOrder(BinaryTree<E> tree);
    <E> List<E> postOrder(BinaryTree<E> tree);
}
