package katas.exercises;

import java.util.*;

public class QueueWithFailover {
    private int jobTimeout;
    private Queue<String> jobs;
    private Map<String, Long> hiddenJobs;

    public QueueWithFailover(int jobTimeout) {
        this.jobTimeout = jobTimeout;
        this.jobs = new LinkedList<>();
        this.hiddenJobs = new HashMap<>();
    }

    public boolean isEmpty() {
        return jobs.isEmpty() && hiddenJobs.isEmpty();
    }

    public void sendJob(String job) {
        jobs.offer(job);
    }

    public String getJob() throws EmptyQueueException {
        if (jobs.isEmpty()) {
            throw new EmptyQueueException("Queue is empty.");
        }
        String job = jobs.poll();
        hiddenJobs.put(job, System.currentTimeMillis());
        return job;
    }

    public void jobDone(String job) {
        if (!hiddenJobs.containsKey(job)) {
            throw new IllegalArgumentException("Job not found in hidden jobs.");
        }
        hiddenJobs.remove(job);
    }

    public int size() {
        return jobs.size();
    }

    public int inFlightSize() {
        return hiddenJobs.size();
    }

    public void returnExpiredJobsToQueue() {
        long currentTime = System.currentTimeMillis();
        Iterator<Map.Entry<String, Long>> iterator = hiddenJobs.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Long> entry = iterator.next();
            if (currentTime - entry.getValue() > jobTimeout * 1000) {
                jobs.offer(entry.getKey());
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        QueueWithFailover jobQueue = new QueueWithFailover(3);

        jobQueue.sendJob("Job 1");
        jobQueue.sendJob("Job 2");
        jobQueue.sendJob("Job 3");

        System.out.println("Job Queue Size: " + jobQueue.size());

        try {
            String currentJob = jobQueue.getJob();
            System.out.println("Got job: " + currentJob);
            jobQueue.jobDone(currentJob);

            currentJob = jobQueue.getJob();
            System.out.println("Got job: " + currentJob);
            Thread.sleep(4000);
            jobQueue.returnExpiredJobsToQueue();

            jobQueue.jobDone(currentJob);
        } catch (InterruptedException | EmptyQueueException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    static class EmptyQueueException extends RuntimeException {
        public EmptyQueueException(String message) {
            super(message);
        }
    }
}
