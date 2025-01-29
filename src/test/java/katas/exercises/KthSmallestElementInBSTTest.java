package katas.exercises;

import org.junit.jupiter.api.Test;

import static katas.exercises.KthSmallestElementInBST.kthSmallest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthSmallestElementInBSTTest {

    @Test
    public void KthSmallestElementInBSTtest1(){
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(10);
        root.left = new KthSmallestElementInBST.TreeNode(5);
        root.right = new KthSmallestElementInBST.TreeNode(15);
        root.left.left = new KthSmallestElementInBST.TreeNode(1);
        root.left.right = new KthSmallestElementInBST.TreeNode(6);

        assertEquals(1, kthSmallest(root, 1));
        assertEquals(5, kthSmallest(root, 2));
        assertEquals(6, kthSmallest(root, 3));
        assertEquals(10, kthSmallest(root, 4));
        assertEquals(15, kthSmallest(root, 5));
    }
}
