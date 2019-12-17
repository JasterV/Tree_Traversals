import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegeneratorTest {
    private final LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>(3,
            new LinkedBinaryTree<>(4,
                    new LinkedBinaryTree<>(34),
                    null),
            new LinkedBinaryTree<>(5,
                    new LinkedBinaryTree<>(25),
                    new LinkedBinaryTree<>(53,
                            new LinkedBinaryTree<>(2),
                            new LinkedBinaryTree<>())
            )
    );

    private final IterativeTraversals it = new IterativeTraversals();

    @Test
    void test_regenerator_integer_tree() {
        List<Integer> postOrder = it.postOrder(bt);
        List<Integer> inOrder = it.inOrder(bt);
        LinkedBinaryTree<Integer> regeneratedTree = Regenerator.postAndIn(postOrder, inOrder);
        assertEquals(postOrder, it.postOrder(regeneratedTree));
        assertEquals(inOrder, it.inOrder(regeneratedTree));
    }

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
    void test_regenerator_string_tree(){
        List<String> postOrder = it.postOrder(bt2);
        List<String> inOrder = it.inOrder(bt2);
        LinkedBinaryTree<String> regeneratedTree = Regenerator.postAndIn(postOrder, inOrder);
        assertEquals(postOrder, it.postOrder(regeneratedTree));
        assertEquals(inOrder, it.inOrder(regeneratedTree));
    }

    private final LinkedBinaryTree<Double> bt3 = new LinkedBinaryTree<>(3.5465423,
            new LinkedBinaryTree<>(4.5465),
            new LinkedBinaryTree<>(2.5431)
    );

    @Test
    void test_regenerator_double_tree(){
        List<Double> postOrder = it.postOrder(bt3);
        List<Double> inOrder = it.inOrder(bt3);
        LinkedBinaryTree<Double> regeneratedTree = Regenerator.postAndIn(postOrder, inOrder);
        assertEquals(postOrder, it.postOrder(regeneratedTree));
        assertEquals(inOrder, it.inOrder(regeneratedTree));
    }

}