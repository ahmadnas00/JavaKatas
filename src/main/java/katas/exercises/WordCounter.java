package katas.exercises;

public class WordCounter {

    /**
     * Counts the number of words in a given sentence.
     *
     * @param sentence the input string (a sentence)
     * @return the number of words in the sentence
     */
    public static int countWords(String sentence) {
        if (sentence == null){
            throw new IllegalArgumentException("Sentence Can't Be Null");
        } else if (sentence.isEmpty()) {
            return 0;
        }

        String[] splited = sentence.split("\\s+");


        return splited.length;
    }

    public static void main(String[] args) {
        String sentence = "  ";
        int wordCount = countWords(sentence);
        System.out.println(wordCount);

    }
}

