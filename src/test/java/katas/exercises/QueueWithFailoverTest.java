package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueWithFailoverTest {

    @Test
    void testSendAndGetJob() {
        QueueWithFailover queue = new QueueWithFailover(3);
        queue.sendJob("Job 1");
        queue.sendJob("Job 2");

        assertEquals(2, queue.size());
        String job = queue.getJob();
        assertEquals("Job 1", job);
        assertEquals(1, queue.size());
    }

    @Test
    void testJobDone() {
        QueueWithFailover queue = new QueueWithFailover(3);
        queue.sendJob("Job 1");
        String job = queue.getJob();

        queue.jobDone(job);

        assertEquals(0, queue.inFlightSize());
    }

    @Test
    void testReturnExpiredJobs() throws InterruptedException {
        QueueWithFailover queue = new QueueWithFailover(3);
        String job = queue.getJob();

        Thread.sleep(4000); // 4 seconds

        queue.returnExpiredJobsToQueue();

        assertEquals(1, queue.size());
    }

    }

