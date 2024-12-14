package katas.exercises;

public class TrueCounter {

    /**
     * Counts the number of true values in the given boolean array.
     *
     * @param array the boolean array to check
     * @return the count of true values in the array
     */
    public static int countTrueValues(boolean[] array) {

        if (array == null ){
            throw new IllegalArgumentException("Array Can't be Null!");
        }

        int counter = 0;
        for (boolean b : array) {
            if (b) {
                counter++;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        boolean[] sampleArray = {true, false, true, true, false};
        int trueCount = countTrueValues(sampleArray);
        System.out.println(trueCount);
    }
}
