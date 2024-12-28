package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.List;

import static katas.exercises.TestCaseGrouping.groupTestCases;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCaseGroupingTest {


    @Test
    public void TestCaseGroupingtest(){

        List<List<Integer>> expected = List.of(
                List.of(0),
                List.of(1, 5),
                List.of(2, 3, 4)
        );
        List<Integer> testCaseGroupSizes1 = List.of(1, 2, 3, 3, 3, 2);
        List<List<Integer>> actual = TestCaseGrouping.groupTestCases(testCaseGroupSizes1);

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }

    }


    @Test
    public void TestCaseGroupingnull(){
        assertThrows(IllegalArgumentException.class, () -> TestCaseGrouping.groupTestCases(null));

    }
}
