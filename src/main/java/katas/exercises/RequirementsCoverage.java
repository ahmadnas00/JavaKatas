package katas.exercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RequirementsCoverage {

    /**
     * In software testing, it's often required to select a minimal set of test cases that cover all the requirements.
     * You are given a set of test cases and their associated covered requirements.
     * Your task is to select the minimal subset of test cases such that all requirements are covered.
     *
     * For example, you have the following test cases and requirements they cover:
     *
     * testCases = [
     *   [1, 2, 3],   // Test case 0 covers requirements 1, 2, 3
     *   [1, 4],      // Test case 1 covers requirements 1, 4
     *   [2, 3, 4],   // Test case 2 covers requirements 2, 3, 4
     *   [1, 5],      // Test case 3 covers requirements 1, 5
     *   [3, 5]       // Test case 4 covers requirements 3, 5
     * ]
     *
     * @param testCases a list of test cases, where each test case is a list of requirements it covers
     * @return a list of indices of the minimal subset of test cases that covers all requirements
     */
    public static List<Integer> selectMinimalTestCases(List<List<Integer>> testCases) {
        if ( testCases == null || testCases.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Set<Integer> allRequirements = new HashSet<>();
        for (List<Integer> testCase : testCases) {
            allRequirements.addAll(testCase);
        }

        List<Integer> result = new ArrayList<>();
        findMinimalSubset(testCases, allRequirements, new ArrayList<>(), result, 0);

        return result;
    }

    private static void findMinimalSubset(List<List<Integer>> testCases, Set<Integer> uncovered, List<Integer> currentSelection, List<Integer> bestResult, int index) {
        if (uncovered.isEmpty()) {
            if (bestResult.isEmpty() || currentSelection.size() < bestResult.size()) {
                bestResult.clear();
                bestResult.addAll(currentSelection);
            }
            return;
        }

        if (index >= testCases.size()) {
            return;
        }

        List<Integer> currentTestCase = testCases.get(index);
        Set<Integer> newUncovered = new HashSet<>(uncovered);
        newUncovered.removeAll(currentTestCase);

        currentSelection.add(index);
        findMinimalSubset(testCases, newUncovered, currentSelection, bestResult, index + 1);
        currentSelection.remove(currentSelection.size() - 1);

        findMinimalSubset(testCases, uncovered, currentSelection, bestResult, index + 1);
    }



    public static void main(String[] args) {
        List<List<Integer>> testCases = List.of(
                List.of(1, 2, 3),
                List.of(1, 4),
                List.of(2, 3, 4),
                List.of(1, 5),
                List.of(3, 5)
        );

        List<Integer> result = selectMinimalTestCases(testCases);
        System.out.println(result); // Expected output: [2, 3]
    }
}
