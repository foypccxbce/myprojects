package com.myprojects.collection;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by root on 2017/7/25.
 */
public class Compare {
    static class User {
        private int id;
        private String name;

        public User(int id, String name){
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("id:%d,name:%s", id, name);
        }
    }
    public static void main(String[] args) {
        ArrayList<User> u = new ArrayList<User>();
        u.add(new User(1, "user1"));
        u.add(new User(18, "user2"));
        u.add(new User(51, "user3"));
        u.add(new User(12, "user4"));
        u.add(new User(34, "user5"));

        u.sort(new Comparator<User>() {
            public int compare(User o1, User o2) {
                return  o2.id<o1.id?-1:(o1.id==o2.id?0:1);
            }
        });

        for (User user : u) {
            System.out.println(user);
        }
    }
}
