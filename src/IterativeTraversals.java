import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IterativeTraversals implements Traversals {

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

    @Override
    public <E> List<E> postOrder(BinaryTree<E> tree) {
        List<E> list = new LinkedList<>();
        Stack<BinaryTree<E>> stack = new Stack<>();
        stack.push(tree);
        while (!stack.isEmpty()) {
            BinaryTree<E> current = stack.pop();
            if (!current.isEmpty()) {
                list.add(0, current.elem());
                if (current.right() != null) stack.push(current.left());
                if (current.left() != null) stack.push(current.right());
            }
        }
        return list;
    }
}
