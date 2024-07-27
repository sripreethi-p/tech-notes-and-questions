//package com.dsa.algorithms.problems.debouncing;
//
//import com.dsa.algorithms.domain.clusterprofile.TgtGroup;
//import com.dsa.algorithms.repository.ClusterProfileRepository;
//
//import java.util.Map;
//import java.util.concurrent.*;
//
//public class ApiDebouncer {
//
//    private final ClusterProfileRepository clusterProfileRepository;
//    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//    private final Map<String, CompletableFuture<TgtGroup>> requestCache = new ConcurrentHashMap<>();
//    private final long debouncePeriod;
//
//    public ApiDebouncer(ClusterProfileRepository clusterProfileRepository, long debouncePeriodMillis) {
//        this.clusterProfileRepository = clusterProfileRepository;
//        this.debouncePeriod = debouncePeriodMillis;
//    }
//
//    public CompletableFuture<TgtGroup> debouncedApiCall(String param) {
//        CompletableFuture<TgtGroup> future = new CompletableFuture<>();
//
//        requestCache.compute(param, (key, existingFuture) -> {
//            if (existingFuture == null) {
//                // Schedule a new API call
//                scheduler.schedule(() -> {
//                    makeApiCall(param, future);
//                    requestCache.remove(param);
//                }, debouncePeriod, TimeUnit.MILLISECONDS);
//                return future;
//            } else {
//                // Use the existing future if within debounce period
//                return existingFuture;
//            }
//        });
//
//        return future;
//    }
//
//    private void makeApiCall(String param, CompletableFuture<TgtGroup> future) {
//        // Simulate an API call
//        try {
//            TgtGroup result = clusterProfileRepository.getTgtGroupById(param);
//            future.complete(result);
//        } catch (Exception e) {
//            future.completeExceptionally(e);
//        }
//    }
//
//    private String callExternalApi(String param) throws InterruptedException {
//        // Simulate the API call latency
//        Thread.sleep(1000);
//        return "Response for " + param;
//    }
//
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ApiDebouncer debouncer = new ApiDebouncer(new ClusterProfileRepository(), 3000);
//
//        CompletableFuture<TgtGroup> response1 = debouncer.debouncedApiCall("T1");
//        CompletableFuture<TgtGroup> response2 = debouncer.debouncedApiCall("T1");
//
//        System.out.println(response1.get()); // Only one API call is made
//        System.out.println(response2.get()); // Both futures will complete with the same result
//    }
//}
