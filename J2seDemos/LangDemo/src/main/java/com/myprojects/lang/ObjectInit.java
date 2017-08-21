package com.myprojects.lang;

/**
 * Created by root on 2017/7/24.
 */
public class ObjectInit {
    private static String obj1 = "��ľ�̬�ֶ�";
    private String obj2 = "��ı���";

    static {
        System.out.println(obj1);
        System.out.println("��ľ�̬��ʼ��");
    }

    {
        System.out.println(obj2);
        System.out.println("���ʼ��");
    }

    public ObjectInit() {
        System.out.println("���캯��");
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
