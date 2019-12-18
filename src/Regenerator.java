import java.util.List;

public class Regenerator {
    /**
     *This function reconstructs a LinkedBinaryTree from its post-order and in-order sequences.
     * @param postOrder The post-order sequence of the tree
     * @param inOrder   The in-order sequence of the tree
     * @param <E> Generic type
     * @return the reconstructed binary tree
     */
    public static <E> LinkedBinaryTree<E> postAndIn(List<? extends E> postOrder, List<? extends E> inOrder) {
        int treeSize = postOrder.size();
        if (treeSize == 0)
            return new LinkedBinaryTree<>();
        else if (treeSize == 1) {
            E root = postOrder.get(treeSize - 1);
            return new LinkedBinaryTree<>(root);
        } else {
            E root = postOrder.get(treeSize - 1);
            int indexOfRoot = inOrder.indexOf(root);
            List<? extends E> inOrderLeft = inOrder.subList(0, indexOfRoot);
            List<? extends E> inOrderRight = inOrder.subList(indexOfRoot + 1, treeSize);
            List<? extends E> postOrderLeft = postOrder.subList(0, indexOfRoot);
            List<? extends E> postOrderRight = postOrder.subList(indexOfRoot, treeSize - 1);

            return new LinkedBinaryTree<>(root,
                    postAndIn(postOrderLeft, inOrderLeft),
                    postAndIn(postOrderRight, inOrderRight));
        }
    }
}
