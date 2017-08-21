package com.myprojects.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch¡¢J
 */
public abstract class ServiceChecker implements Runnable {
    private CountDownLatch latch;
    private String serviceName;
    private boolean isUp;

    public ServiceChecker(String _serviceName, CountDownLatch _latch) {
        super();
        this.latch = _latch;
        this.serviceName = _serviceName;
        this.isUp = false;
    }

    public void run() {
        try {
            serviceVerify();
            isUp = true;
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            isUp = false;
        } finally {
            if (null != latch)
                latch.countDown();
        }
    }

    public String getServiceName() {
        return serviceName;
    }

    public boolean isUp() {
        return isUp;
    }

    protected abstract void serviceVerify();

}
