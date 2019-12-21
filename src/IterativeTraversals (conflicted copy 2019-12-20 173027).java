import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IterativeTraversals implements Traversals {

    /**
     * This method traverses a binary tree in a pre-order way
     * @param tree the tree its going to be traversed
     * @param <E> Generic type
     * @return A list with the pre-order traversal elements of the tree
     */
    @Override
    public <E> List<E> preOrder(BinaryTree<E> tree) {
        List<E> list = new LinkedList<>();
        Stack<BinaryTree<E>> stack = new Stack<>();
        stack.push(tree);
        while (!stack.isEmpty()) {
            BinaryTree<E> actualTree = stack.pop();
            if (!actualTree.isEmpty()) {
                list.add(actualTree.elem());
                stack.push(actualTree.right());
                stack.push(actualTree.left());
            }
        }
        return list;
    }

    /**
     * This method traverses a binary tree in a post-order way
     * @param tree the tree its going to be traversed
     * @param <E> Generic type
     * @return A list with the post-order traversal elements of the tree
     */
    @Override
    public <E> List<E> postOrder(BinaryTree<E> tree) {
        List<E> list = new LinkedList<>();
        Stack<BinaryTree<E>> stack = new Stack<>();
        stack.push(tree);
        while (!stack.isEmpty()) {
            BinaryTree<E> current = stack.pop();
            if (!current.isEmpty()) {
                stack.push(current.left());
                stack.push(current.right());
                list.add(0, current.elem());
            }
        }
        return list;
    }

    /**
     * This method traverses a binary tree in a in-order way
     * @param tree the tree its going to be traversed
     * @param <E> Generic type
     * @return A list with the in-order traversal elements of the tree
     */
    @Override
    public <E> List<E> inOrder(BinaryTree<E> tree) {
        List<E> list = new LinkedList<>();
        Stack<BinaryTree<E>> stack = new Stack<>();
        stack.push(tree);
        BinaryTree<E> current = tree.left();
        while (!stack.isEmpty() || !current.isEmpty()) {
            if (!current.isEmpty()) {
                stack.push(current);
                current = current.left();
            } else {
                current = stack.pop();
                list.add(current.elem());
                current = current.right();
            }
        }
        return list;
    }
}
