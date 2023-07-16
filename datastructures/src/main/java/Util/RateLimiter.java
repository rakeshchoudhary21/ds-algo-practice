package Util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

@Slf4j
public class RateLimiter {

    private RateLimiter(){}

    private Queue<Request> queue;
    private int capacity;
    private long windowSize;
    private long lastRequestTime;

    public RateLimiter(int capacity,long windowSize){
        this.queue = new LinkedList<>();
        this.capacity = capacity;
        this.windowSize = windowSize;
    }

    public Request process(Request request) {

        //if queue capacity is full then don't process anything at all.
        if(!queue.isEmpty() && (request.epoch - lastRequestTime < windowSize && queue.size()>=capacity)){
            System.out.println("Rate Limit applicable::"+(request.epoch - queue.peek().epoch));
            return null;
        }else{
            //Check queue size again. If exceeded then ignore the request.
            queue.add(request);
            lastRequestTime = request.epoch;
            doWork(request);
            return request;
        }
    }

    private void doWork(Request request) {
        new Thread(() -> {
            try {
                System.out.println("Processing the request::"+ request);
                Thread.sleep(2000);
                queue.remove(request);
                System.out.println("Done processing:"+ request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Data
    private static class Request{
        int reqId= new Random().nextInt(Integer.MAX_VALUE);
        long epoch = System.currentTimeMillis();
    }

    public static void main(String[] args) throws Exception{
        RateLimiter rateLimiter = new RateLimiter(2,1000);
        while (true){
            rateLimiter.process(new Request());
            Thread.sleep(500);
        }
    }
}
