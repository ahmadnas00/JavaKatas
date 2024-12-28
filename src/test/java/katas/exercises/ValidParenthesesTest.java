package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidParenthesesTest {


    @Test
    public void testValidParentheses(){
        assertTrue(ValidParentheses.isValidParentheses("{[()]}"));
        assertTrue(ValidParentheses.isValidParentheses("()[]{}"));
        assertTrue(ValidParentheses.isValidParentheses(""));
        assertFalse(ValidParentheses.isValidParentheses("({[}])"));
        assertFalse(ValidParentheses.isValidParentheses("((((}}}}{{{{(((("));
        assertFalse(ValidParentheses.isValidParentheses("[[[[[[[[[[[[[))))))))))))"));
        assertFalse(ValidParentheses.isValidParentheses("asd"));
    }

    @Test
    public void testValidParethesesnull(){
        assertThrows(IllegalArgumentException.class, () -> ValidParentheses.isValidParentheses(null));


    }

}
