import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedBinaryTreeTest {

    private final LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>(3,
            new LinkedBinaryTree<>(4,
                    new LinkedBinaryTree<>(34),
                    new LinkedBinaryTree<>()),
            new LinkedBinaryTree<>(5,
                    new LinkedBinaryTree<>(25),
                    new LinkedBinaryTree<>(53)
            )
    );

    private final LinkedBinaryTree<Integer> bt2 = new LinkedBinaryTree<>(3,
            new LinkedBinaryTree<>(4,
                    new LinkedBinaryTree<>(34),
                    new LinkedBinaryTree<>()),
            new LinkedBinaryTree<>(5,
                    new LinkedBinaryTree<>(25),
                    new LinkedBinaryTree<>(53)
            )
    );

    private final LinkedBinaryTree<String> bt3 = new LinkedBinaryTree<>("Hi!",
            new LinkedBinaryTree<>("Bye!",
                    new LinkedBinaryTree<>("Stre!"),
                    new LinkedBinaryTree<>("Oui!",
                            null,
                            new LinkedBinaryTree<>("Uala!"))),
            new LinkedBinaryTree<>("Ecs!",
                    new LinkedBinaryTree<>("Lolo"),
                    new LinkedBinaryTree<>("lala",
                            new LinkedBinaryTree<>("Ei!",
                                    new LinkedBinaryTree<>("Prra!"),
                                    null),
                            new LinkedBinaryTree<>())
            )
    );

    private final LinkedBinaryTree<String> emptyBt = new LinkedBinaryTree<>();

    @Test
    void test_equals() {
        assertEquals(bt, bt2);
        assertNotEquals(bt, bt3);
        assertEquals(bt.left(), bt2.left());
        assertEquals(bt.right(), bt2.right());
    }

    @Test
    void test_elem(){
        assertEquals(3, bt.elem());
        assertEquals(4, bt.left().elem());
        assertEquals(5, bt.right().elem());
        assertEquals("Hi!", bt3.elem());
        assertEquals("Bye!", bt3.left().elem());
        assertEquals("Ecs!", bt3.right().elem());
    }

    @Test
    void test_empty(){
        assertFalse(bt.isEmpty());
        assertFalse(bt3.isEmpty());
        assertFalse(bt.right().isEmpty());
        assertTrue(emptyBt.isEmpty());
    }
}