package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static katas.exercises.ValidGitTree.isValidGitTree;
import static org.junit.jupiter.api.Assertions.*;

public class ValidGitTreeTest {


    @Test
    public void ValidGitTreetest(){
        Map<String, List<String>> validTree = new HashMap<>();
        validTree.put("A", List.of("B", "C"));
        validTree.put("B", List.of("D"));
        validTree.put("C", List.of());
        validTree.put("D", List.of());

        Map<String, List<String>> invalidTree = new HashMap<>();
        invalidTree.put("A", List.of("B"));
        invalidTree.put("B", List.of("C"));
        invalidTree.put("C", List.of("A"));


        assertTrue(ValidGitTree.isValidGitTree(validTree));
        assertFalse(ValidGitTree.isValidGitTree(invalidTree));
    }

    @Test
    public void ValidGitTreenull(){
        assertThrows(IllegalArgumentException.class, () -> ValidGitTree.isValidGitTree(null));


    }


}
