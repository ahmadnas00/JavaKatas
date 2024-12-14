package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UniqueStringTest {


    @Test
    public void testUniqueString(){
        String test1 = "Hello";
        String test2 = "jeff";
        String test3 = "Name";
        String test4 = "abcdefghijklmnopqrstuvwxyz";
        assertFalse(UniqueString.isUnique(test1));
        assertFalse(UniqueString.isUnique(test2));
        assertTrue(UniqueString.isUnique(test3));
        assertTrue(UniqueString.isUnique(test4));
    }

    @Test
    public void testUniqueStringnull(){
        assertThrows(IllegalArgumentException.class, () -> UniqueString.isUnique(null));
        assertThrows(IllegalArgumentException.class, () -> UniqueString.isUnique(""));
    }

}
