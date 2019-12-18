import java.util.List;

public class Regenerator {
    public static <E> LinkedBinaryTree<E> postAndIn(List<? extends E> postOrder, List<? extends E> inOrder) {
        int treeSize = postOrder.size();
        if (treeSize == 0)
            return null;
        else {
            E root = postOrder.get(treeSize - 1);
            int indexOfRoot = inOrder.indexOf(root);
            return new LinkedBinaryTree<>(root,
                    postAndIn(postOrder.subList(0, indexOfRoot), inOrder.subList(0, indexOfRoot)),
                    postAndIn(postOrder.subList(indexOfRoot, treeSize - 1), inOrder.subList(indexOfRoot + 1, treeSize))
            );
        }
    }
}
