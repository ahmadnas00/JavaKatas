package katas.exercises;

import java.util.*;

public class ValidGitTree {

    /**
     * Determines if a given tree structure represents a valid Git tree.
     * <p>
     * A valid Git tree should:
     * 1. Have exactly one root (no parent).
     * 2. Contain no cycles.
     *
     * @param treeMap a map representing the Git tree (commit ID to list of child commit IDs)
     * @return true if the tree is a valid Git tree, false otherwise
     */
    public static boolean isValidGitTree(Map<String, List<String>> treeMap) {
        if (treeMap == null ){
            throw new IllegalArgumentException("Tree Map Can't Be Null");
        }


        Set<String> allnodes = treeMap.keySet();
        Set<String> childNodes = new HashSet<>();

        for (List<String> children : treeMap.values()) {
            childNodes.addAll(children);
        }

        Set<String> rootNodes = new HashSet<>(allnodes);
        rootNodes.removeAll(childNodes);

        if (rootNodes.size() != 1) {
            return false;
        }

        Set<String> visited = new HashSet<>();
        Set<String> visiting = new HashSet<>();

        String root = rootNodes.iterator().next();

        if (hasCycleDFS(root, treeMap, visited, visiting)) {
            return false;
        }
        return true;
    }

    private static boolean hasCycleDFS(String node, Map<String, List<String>> treeMap, Set<String> visited, Set<String> visiting) {
        if (visiting.contains(node)) {
            return true;
        }
        if (visited.contains(node)) {
            return false;
        }

            visiting.add(node);
            for (String child : treeMap.getOrDefault(node, Collections.emptyList())) {
                if (hasCycleDFS(child, treeMap, visited, visiting)) {
                    return true;
                }
            }
            visiting.remove(node);
            visited.add(node);

            return false;
        }


        public static void main(String[] args) {
            Map<String, List<String>> validTree = new HashMap<>();
            validTree.put("A", List.of("B", "C"));
            validTree.put("B", List.of("D"));
            validTree.put("C", List.of());
            validTree.put("D", List.of());

            Map<String, List<String>> invalidTree = new HashMap<>();
            invalidTree.put("A", List.of("B"));
            invalidTree.put("B", List.of("C"));
            invalidTree.put("C", List.of("A")); // cycle

            System.out.println("Is valid tree: " + isValidGitTree(validTree));   // Should return true
            System.out.println("Is valid tree: " + isValidGitTree(invalidTree)); // Should return false
        }

}




