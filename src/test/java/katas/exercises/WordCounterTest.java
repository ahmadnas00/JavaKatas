package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordCounterTest {

    @Test
    public void testWordCounter(){
        assertEquals(4,WordCounter.countWords("Hi how are you?"));
        assertEquals(5,WordCounter.countWords("hello mark how are you?"));
        assertEquals(0,WordCounter.countWords(""));
    }

    @Test
    public void testWordCounterNull(){
        assertThrows(IllegalArgumentException.class, () ->WordCounter.countWords(null));
    }

}
