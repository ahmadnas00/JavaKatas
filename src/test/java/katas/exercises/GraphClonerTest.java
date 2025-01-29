package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static katas.exercises.GraphCloner.cloneGraph;
import static katas.exercises.GraphCloner.printGraph;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GraphClonerTest {

    @Test
    public void GraphClonerTestnull(){
        assertThrows(IllegalArgumentException.class, () -> cloneGraph(null));
    }

    @Test
    public void GraphClonerTest() {
        GraphCloner.Node node1 = new GraphCloner.Node(1);
        GraphCloner.Node node2 = new GraphCloner.Node(2);
        GraphCloner.Node node3 = new GraphCloner.Node(3);
        GraphCloner.Node node4 = new GraphCloner.Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node3);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);

        GraphCloner.Node clonedNode1 = GraphCloner.cloneGraph(node1);

        assertEquals(1, clonedNode1.val);
        assertEquals(2, clonedNode1.neighbors.size());
        assertEquals(2, clonedNode1.neighbors.get(0).val);
        assertEquals(4, clonedNode1.neighbors.get(1).val);

        GraphCloner.Node clonedNode2 = clonedNode1.neighbors.get(0);
        assertEquals(2, clonedNode2.val);
        assertEquals(1, clonedNode2.neighbors.size());
        assertEquals(3, clonedNode2.neighbors.get(0).val);

        GraphCloner.Node clonedNode4 = clonedNode1.neighbors.get(1);
        assertEquals(4, clonedNode4.val);
        assertEquals(1, clonedNode4.neighbors.size());
        assertEquals(1, clonedNode4.neighbors.get(0).val);
    }
}
