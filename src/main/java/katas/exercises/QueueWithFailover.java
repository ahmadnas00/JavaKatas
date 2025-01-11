package katas.exercises;

import java.util.*;

public class QueueWithFailover {
    /**
     * A job queue data structure with failover support.
     *
     * A job queue is a messaging system used to manage the flow of work between components or applications.
     * In this system, jobs (or messages) are sent to the queue by PRODUCERS and retrieved by CONSUMERS for processing.
     *
     * When a job is consumed by a consumer, they have `jobTimeout` seconds to finish the job.
     * The job is not permanently deleted from the queue; instead, it is temporarily hidden.
     * If the consumer completes processing the job within the allocated time, they mark the job as done (jobDone()),
     * and the job should be permanently deleted.
     * Otherwise, if they fail to process the job and the job processing times out, the job should be returned
     * to the end of the queue (by the returnExpiredJobsToQueue()), allowing it to be consumed again.
     */

    private int jobTimeout;
    private Queue<String> jobs;
    private Map<String, Long> hiddenJobs;

    public QueueWithFailover(int jobTimeout) {
        this.jobTimeout = jobTimeout;
        this.jobs = new LinkedList<>();
        this.hiddenJobs = new HashMap<>();
    }

    public boolean isEmpty() {
        return jobs.isEmpty();
    }

    public void sendJob(String job) {
        jobs.add(job);
    }

    public String getJob() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("The job queue is empty.");
        }
        String job = jobs.poll();
        hiddenJobs.put(job, System.currentTimeMillis());  // Add the job to hiddenJobs with timestamp
        return job;
    }

    public void jobDone(String job) {
        if (!hiddenJobs.containsKey(job)) {
            throw new IllegalArgumentException("Job not found in the hidden jobs.");
        }
        hiddenJobs.remove(job);
    }

    public int size() {
        return jobs.size();
    }

    public int inFlightSize() {
        return hiddenJobs.size(); // Only the jobs being processed (hidden)
    }

    public void returnExpiredJobsToQueue() {
        long currentTime = System.currentTimeMillis();
        Iterator<Map.Entry<String, Long>> iterator = hiddenJobs.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Long> entry = iterator.next();
            String job = entry.getKey();
            long timestamp = entry.getValue();

            if (currentTime - timestamp > jobTimeout * 1000L) {
                jobs.add(job); // Return expired job to the queue
                iterator.remove(); // Remove from hiddenJobs as it is now back in the queue
            }
        }
    }

    public static void main(String[] args) {
        QueueWithFailover jobQueue = new QueueWithFailover(3);

        jobQueue.sendJob("Job 1");
        jobQueue.sendJob("Job 2");
        jobQueue.sendJob("Job 3");

        System.out.println("Job Queue Size: " + jobQueue.size());

        String currentJob = jobQueue.getJob();
        jobQueue.jobDone(currentJob);  // Job is processed successfully

        currentJob = jobQueue.getJob();
        try {
            Thread.sleep(4000); // Simulate time passing (more than 3 seconds)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        jobQueue.returnExpiredJobsToQueue();

        try {
            jobQueue.jobDone(currentJob);  // This will now not throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("Job not found as it was expired and returned to the main queue");
        }
    }

    static class EmptyQueueException extends RuntimeException {
        public EmptyQueueException(String message) {
            super(message);
        }
    }
}
