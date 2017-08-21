package com.myprojects.thread;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Package: com.myprojects.thread
 * @Author: tangkj
 * @Daet: 2017/7/26 19:01
 * @Email: none@mail.com
 * @Desc:
 */
public class ThreadTest {

    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

    class User {
        String name;
        boolean status;
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                status = !status;
            }
        };

        User(String name) {
            this.name = name;
            service.scheduleAtFixedRate(runnable1, 0, 1, TimeUnit.SECONDS);
        }
    }

    public static void main(String[] args) {
        User U = new ThreadTest().new User(UUID.randomUUID().toString());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        U = null;
    }

    public static void main1(String[] args) {
        List<User> uu = new ArrayList<User>();
        List<User> list = Collections.synchronizedList(uu);

        final long timeInterval = 1000;
        Runnable runnable = new Runnable() {
            int count = 0;

            @Override
            public void run() {
                while (true) {
                    list.add(new ThreadTest().new User(UUID.randomUUID().toString()));
                    System.out.println("add count:" + (++count));
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t = new Thread(runnable);
        t.start();


        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                synchronized (list) {
                    List<User> falseUser = new ArrayList<>();
                    for (User user : list) {
                        if (!user.status) ;
                        falseUser.add(user);
                    }
                    for (User user : falseUser) {
                        System.out.println(user.name + ":" + user.status);
                    }
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, 2000);


    }
}
