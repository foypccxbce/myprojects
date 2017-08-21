package com.myprojects.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by root on 2017/7/21.
 */
public class Service1 extends ServiceChecker {

    public Service1(CountDownLatch _latch){
        super("Service1", _latch);
    }

    public Service1(String _serviceName, CountDownLatch _latch) {

        super(_serviceName, _latch);
    }

    @Override
    protected void serviceVerify() {
        System.out.println("Checking " + this.getServiceName());
        try
        {
            Thread.sleep(7000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }
}
