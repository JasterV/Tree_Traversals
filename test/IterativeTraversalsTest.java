import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

class IterativeTraversalsTest {
    private final LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>(3,
            new LinkedBinaryTree<>(4,
                    null,
                    new LinkedBinaryTree<>(43)),
            new LinkedBinaryTree<>(5,
                    new LinkedBinaryTree<>(25),
                    new LinkedBinaryTree<>(53,
                            new LinkedBinaryTree<>(2),
                            null)
            )
    );

    private final LinkedBinaryTree<String> bt2 = new LinkedBinaryTree<>("Hi!",
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

    @Test
    void test_traversals_integer_tree() {
        List<Integer> preOrder = new LinkedList<>(List.of(3, 4, 43, 5, 25, 53, 2));
        List<Integer> inOrder = new LinkedList<>(List.of(4, 43, 3, 25, 5, 2, 53));
        List<Integer> postOrder = new LinkedList<>(List.of(43, 4, 25, 2, 53, 5, 3));
        IterativeTraversals it = new IterativeTraversals();
        assertEquals(preOrder, it.preOrder(bt));
        assertEquals(inOrder, it.inOrder(bt));
        assertEquals(postOrder, it.postOrder(bt));
    }

    @Test
    void test_traversals_string_tree(){
        List<String> preOrder = new LinkedList<>(List.of("Hi!", "Bye!", "Stre!", "Oui!", "Uala!", "Ecs!", "Lolo", "lala", "Ei!", "Prra!"));
        List<String> inOrder = new LinkedList<>(List.of("Stre!", "Bye!", "Oui!", "Uala!", "Hi!", "Lolo", "Ecs!", "Prra!", "Ei!", "lala"));
        List<String> postOrder = new LinkedList<>(List.of("Stre!", "Uala!", "Oui!", "Bye!", "Lolo", "Prra!", "Ei!", "lala", "Ecs!", "Hi!"));
        IterativeTraversals it = new IterativeTraversals();
        assertEquals(preOrder, it.preOrder(bt2));
        assertEquals(inOrder, it.inOrder(bt2));
        assertEquals(postOrder, it.postOrder(bt2));
    }

}