package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RequirementsCoverageTest {

    @Test
    public void RequirementsCoveragetest(){

        List<List<Integer>> testCases1 = List.of(
                List.of(1, 2, 3),
                List.of(1, 4),
                List.of(2, 3, 4),
                List.of(1, 5),
                List.of(3, 5)
        );
        List<Integer> Expectedoutput1 = List.of(2, 3);
        assertEquals(Expectedoutput1,RequirementsCoverage.selectMinimalTestCases(testCases1));

        List<List<Integer>> testCases2 = List.of(
                List.of(1, 2),
                List.of(2, 3),
                List.of(1, 3),
                List.of(4, 5),
                List.of(5, 6)
        );

        List<Integer> Expectedoutput2 = List.of(0, 1, 3, 4);
        assertEquals(Expectedoutput2,RequirementsCoverage.selectMinimalTestCases(testCases2));




    }

    @Test
    public void RequirementsCoverageTestNull(){

        assertThrows(IllegalArgumentException.class, () -> RequirementsCoverage.selectMinimalTestCases(null));
        assertThrows(IllegalArgumentException.class, () -> RequirementsCoverage.selectMinimalTestCases(new ArrayList<>()));

    }

}
