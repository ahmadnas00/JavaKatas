package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MedianFinderTest {


    @Test
    public void MedianFindertests() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        assertEquals(1.5, medianFinder.findMedian());
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        medianFinder.addNum(5);
        assertEquals(3, medianFinder.findMedian());
    }

    @Test
    public void MedianFindertestempty() {
        MedianFinder medianFinder = new MedianFinder();
        assertThrows(IllegalArgumentException.class, () -> medianFinder.findMedian());
    }
}

