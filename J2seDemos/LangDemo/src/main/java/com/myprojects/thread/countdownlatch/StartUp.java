package com.myprojects.thread.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by root on 2017/7/21.
 */
public class StartUp {
    private List<ServiceChecker> serviceCheckers;
    private CountDownLatch latch;

    private static StartUp INSTANCE = new StartUp();

    public static StartUp getInstance() {
        return INSTANCE;
    }

    public boolean executeServices() throws Exception {
        latch = new CountDownLatch(3);

        serviceCheckers = new ArrayList<ServiceChecker>();
        serviceCheckers.add(new Service1(latch));
        serviceCheckers.add(new Service2(latch));
        serviceCheckers.add(new Service3(latch));

        ExecutorService executors = Executors.newFixedThreadPool(serviceCheckers.size(), new ThreadFactory() {
            public Thread newThread(Runnable r) {
                ServiceChecker checker = (ServiceChecker) r;
                return  new Thread(r,checker.getServiceName());
            }
        });
        for (int i = 0; i < serviceCheckers.size(); i++) {
            executors.execute(serviceCheckers.get(i));
        }
        latch.await();
        for (ServiceChecker serviceChecker : serviceCheckers) {
            if (!serviceChecker.isUp())
                return false;
        }
        return true;
    }
}
