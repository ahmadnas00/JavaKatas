package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixRotateTest {


    @Test
    public void testMatrixRotate(){
        int[][] input1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] expected1 = {
                {7,4,1},
                {8,5,2},
                {9,6,3}
        };
        MatrixRotate.rotateMatrix(input1);
        assertArrayEquals(expected1,input1);

        int[][] input2 = {
                {1,2},
                {3,4}
        };
        int[][] expexted2 = {
                {3,1},
                {4,2}
        };
        MatrixRotate.rotateMatrix(input2);
        assertArrayEquals(expexted2,input2);

        int[][] input3 = {
                {0}
        };

        int[][] expected3 = {
                {0}
        };
        MatrixRotate.rotateMatrix(input3);
        assertArrayEquals(expected3,input3);


    }

    @Test
    public void testMatrixRotatenullorempty(){
        assertThrows(IllegalArgumentException.class, () -> MatrixRotate.rotateMatrix(null));
        int[][] input4 = {
                {}
        };
        assertThrows(IllegalArgumentException.class, () -> MatrixRotate.rotateMatrix(input4));
    }








}
