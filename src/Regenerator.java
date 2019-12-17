import java.util.List;

public class Regenerator {
    public static <E> LinkedBinaryTree<E> postAndIn(List<? extends E> postOrder, List<? extends E> inOrder) {
        int treeSize = postOrder.size();
        if (treeSize == 0) {
            return null;
        } else {
            E root = postOrder.get(treeSize - 1);
            int indexOfRoot = inOrder.indexOf(root);
            List<? extends E> subInLeft =  inOrder.subList(0, indexOfRoot);
            List<? extends E> subInRight =  inOrder.subList(indexOfRoot + 1, treeSize);
            List<? extends E> subPosLeft = postOrder.subList(0, indexOfRoot);
            List<? extends E> subPosRight = postOrder.subList(indexOfRoot, treeSize - 1);

            return new LinkedBinaryTree<>(root,
                    postAndIn(subPosLeft,subInLeft),
                    postAndIn(subPosRight,subInRight));
        }
    }
}
