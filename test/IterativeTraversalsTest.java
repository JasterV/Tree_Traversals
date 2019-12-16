import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

class IterativeTraversalsTest {
    private LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>(3,
            new LinkedBinaryTree<Integer>(4,
                    null,
                    new LinkedBinaryTree<Integer>(43)),
            new LinkedBinaryTree<Integer>(5,
                    new LinkedBinaryTree<Integer>(25),
                    new LinkedBinaryTree<Integer>(53,
                            new LinkedBinaryTree<Integer>(2),
                            null)
            )
    );

    @Test
    void test() {
        List<Integer> preOrder = new LinkedList<>(List.of(3, 4, 43, 5, 25, 53, 2));
        List<Integer> inOrder = new LinkedList<>(List.of(4, 43, 3, 25, 5, 2, 53));
        List<Integer> postOrder = new LinkedList<>(List.of(43, 4, 25, 2, 53, 5, 3));
        IterativeTraversals it = new IterativeTraversals();
        assertEquals(preOrder, it.preOrder(bt));
        assertEquals(inOrder, it.inOrder(bt));
        assertEquals(postOrder, it.postOrder(bt));
    }

}