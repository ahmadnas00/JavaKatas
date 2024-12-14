package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListFlattenTest {
    @Test
    public void testListFlatten(){

        List<Object> nestedList = List.of(
                1,
                List.of(2, 3),
                List.of(4, List.of(5, 6)),
                7
        );
        List<Integer> resultList = ListFlatten.flattenList(nestedList);
        int[] resultArray = resultList.stream().mapToInt(Integer::intValue).toArray();
        int[] expected = {1, 2, 3, 4, 5, 6, 7};
        assertArrayEquals(expected, resultArray);
    }
    @Test
    public void testListFlattennull(){
        assertThrows(IllegalArgumentException.class, () -> ListFlatten.flattenList(null));

    }

}
