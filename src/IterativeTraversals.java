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
            if (actualTree != null && !actualTree.isEmpty()) {
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
            if (current != null && !current.isEmpty()) {
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
        List<BinaryTree<E>> visited = new LinkedList<>();
        Stack<BinaryTree<E>> stack = new Stack<>();

        BinaryTree<E> current = tree;
        stack.push(current);
        while (!stack.isEmpty()) {
            if (current != null
                    && !current.isEmpty()
                    && !childsVisited(current, visited)) {
                if (current.right() != null) stack.push(current.right());
                if (current.left() != null) stack.push(current.left());
                current = current.left();
            } else {
                current = stack.pop();
                visited.add(current);
                if(!current.isEmpty()) list.add(current.elem());
                if (!stack.isEmpty()) current = stack.peek();
            }
        }
        return list;
    }

    private <E> boolean childsVisited(BinaryTree<E> tree, List<BinaryTree<E>> list) {
        if (tree.right() != null && tree.left() != null)
            return list.contains(tree.left()) && list.contains(tree.right());
        else if (tree.left() != null)
            return list.contains(tree.left());
        else
            return list.contains(tree.right());
    }
}
