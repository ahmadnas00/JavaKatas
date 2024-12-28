package katas.exercises;

import java.util.*;

public class TestCaseGrouping {

    /**
     * In software testing, a traceability matrix is used to map requirements to test cases, ensuring that all requirements are covered by corresponding test cases.
     *
     * You are given a list of group SIZES of each test case. For example:
     *
     * testCaseGroupSizes = [1, 2, 3, 3, 3, 2]
     *
     * - Test case num 0 belongs to a group of 1 test cases
     * - Test case num 1 belongs to a group of 2 test cases
     * - Test case num 2 belongs to a group of 3 test cases
     * - Test case num 3 belongs to a group of 3 test cases
     * - etc...
     *
     * Your task is to return a list of groups such that each test case i is in a group of size testCaseGroupSizes[i]:
     *
     * testCasesGroups = [[0], [1, 5], [2, 3, 4]]
     *
     * @param testCaseGroupSizes a list of integers, where each integer represents the size of the group for the corresponding test case
     * @return a list of groups, where each group contains the indices of test cases covering the same set of requirements
     */
    public static List<List<Integer>> groupTestCases(List<Integer> testCaseGroupSizes) {

        if ( testCaseGroupSizes == null || testCaseGroupSizes.isEmpty()){
            throw new IllegalArgumentException();
        }

        Map<Integer, List<Integer>> answer = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < testCaseGroupSizes.size(); i++) {
            int groupSize = testCaseGroupSizes.get(i);

            if (!answer.containsKey(groupSize)) {
                answer.put(groupSize, new ArrayList<>());
            }

            answer.get(groupSize).add(i);

            if (answer.get(groupSize).size() == groupSize) {
                result.add(answer.get(groupSize));
                answer.remove(groupSize);
            }
        }

        result.sort((group1, group2) -> Integer.compare(group1.get(0), group2.get(0)));

        return result;
    }




    public static void main(String[] args) {
        List<Integer> testCaseGroupSizes1 = List.of(1, 2, 3, 3, 3, 2);
        List<List<Integer>> testCaseGroups1 = groupTestCases(testCaseGroupSizes1);
        System.out.println(testCaseGroups1);
    }
}
