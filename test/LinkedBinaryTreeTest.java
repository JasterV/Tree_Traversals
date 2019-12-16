import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedBinaryTreeTest {

    private LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>(3,
            new LinkedBinaryTree<>(4,
                    new LinkedBinaryTree<>(34),
                    new LinkedBinaryTree<>()),
            new LinkedBinaryTree<>(5,
                    new LinkedBinaryTree<>(25),
                    new LinkedBinaryTree<>(53)
            )
    );

    private LinkedBinaryTree<Integer> bt2 = new LinkedBinaryTree<>(3,
            new LinkedBinaryTree<>(4,
                    new LinkedBinaryTree<>(34),
                    new LinkedBinaryTree<>()),
            new LinkedBinaryTree<>(5,
                    new LinkedBinaryTree<>(25),
                    new LinkedBinaryTree<>(53)
            )
    );

    private LinkedBinaryTree<Integer> bt3 = new LinkedBinaryTree<>(3,
            new LinkedBinaryTree<>(4,
                    new LinkedBinaryTree<>(34),
                    new LinkedBinaryTree<>(43)),
            new LinkedBinaryTree<>(5,
                    new LinkedBinaryTree<>(25),
                    new LinkedBinaryTree<>(53,
                            new LinkedBinaryTree<>(2),
                            new LinkedBinaryTree<>())
            )
    );

    @Test
    void test() {
        assertEquals(bt, bt2);
        assertNotEquals(bt, bt3);
        assertEquals(3, bt.elem());
        assertEquals(4, bt.left().elem());
        assertEquals(5, bt.right().elem());
    }
}