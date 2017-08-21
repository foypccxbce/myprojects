package com.myprojects.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by root on 2017/7/21.
 */
public class Service2 extends ServiceChecker {

    public Service2(CountDownLatch _latch){
        super("Service2", _latch);
    }

    public Service2(String _serviceName, CountDownLatch _latch) {

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
