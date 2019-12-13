import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

class IterativeTraversalsTest {
    private LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>(3,
            new LinkedBinaryTree<Integer>(4,
                    new LinkedBinaryTree<Integer>(34),
                    new LinkedBinaryTree<Integer>(43)),
            new LinkedBinaryTree<Integer>(5,
                    new LinkedBinaryTree<Integer>(25),
                    new LinkedBinaryTree<Integer>(53,
                            new LinkedBinaryTree<Integer>(2),
                            new LinkedBinaryTree<>())
            )
    );

    @Test
    void test() {
        List<Integer> preOrder = new LinkedList<>(List.of(3, 4, 34, 43, 5, 25, 53, 2));
        List<Integer> inOrder = new LinkedList<>(List.of(34, 4, 43, 3, 25, 5, 2, 53));
        List<Integer> postOrder = new LinkedList<>(List.of(34, 43, 4, 25, 2, 53, 5, 3));
        IterativeTraversals it = new IterativeTraversals();
        assertEquals(it.preOrder(bt), preOrder);
        assertEquals(it.inOrder(bt), inOrder);
        assertEquals(it.postOrder(bt), postOrder);
    }

}