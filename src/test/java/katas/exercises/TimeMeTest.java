package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimeMeTest {


    @Test
    public void testMeasureExecutionTime_SampleFunction() {
        Runnable sampleFunction = () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        long timeTaken = TimeMe.measureExecutionTime(sampleFunction);
        assertTrue(timeTaken >= 400 && timeTaken <= 600, "Execution time should be around 500ms");



    }

    @Test
    public void testMeasureExecutionTime_QuickFunction() {
        Runnable quickFunction = () -> System.out.println("Quick task done!");

        long timeTaken = TimeMe.measureExecutionTime(quickFunction);
        // Assert that the time taken is close to 0ms (since it's a quick task)
        assertTrue(timeTaken < 10, "Execution time should be close to 0ms");
    }



}
