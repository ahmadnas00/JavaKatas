package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderedMapTest {

    @Test
    public void testsize(){
        OrderedMap<String, Integer> orderedMap = new OrderedMap<>();
        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        orderedMap.put("Three", 3);
        assertEquals(3,orderedMap.size());
        orderedMap.remove("One");
        assertEquals(2,orderedMap.size());
    }

    @Test
    public void testclear(){
        OrderedMap<String, Integer> orderedMap = new OrderedMap<>();
        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        orderedMap.put("Three", 3);
        orderedMap.clear();
        assertEquals(0,orderedMap.size());
    }

    @Test
    public void updatekey(){
        OrderedMap<String, Integer> orderedMap = new OrderedMap<>();
        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        orderedMap.put("Three", 3);
        orderedMap.put("Two", 22);
        assertEquals(orderedMap.get("Two"),22);
    }
}
