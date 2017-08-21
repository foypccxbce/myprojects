package com.myprojects.lang;

/**
 * Created by root on 2017/7/24.
 */
public class ObjectInit {
    private static String obj1 = "类的静态字段";
    private String obj2 = "类的变量";

    static {
        System.out.println(obj1);
        System.out.println("类的静态初始化");
    }

    {
        System.out.println(obj2);
        System.out.println("类初始化");
    }

    public ObjectInit() {
        System.out.println("构造函数");
    }

    public static void main(String[] args) {
       ObjectInit.C c = new ObjectInit().new C();
    }

    class P{
        public P(){
            System.out.println("P .init");
        }
        public P(String a){
            System.out.println("P .init" + a);
        }
    }
    class C extends  P{
        public C(){
            super("initd");
            System.out.println("C .init");
        }

    }
}
