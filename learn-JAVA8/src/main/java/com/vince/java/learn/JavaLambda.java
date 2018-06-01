package com.vince.java.learn;

/**
 * lambda Expressions
 *
 * @author vince_zh  2018/5/30
 */
public class JavaLambda {
    public static void main(String[] args) {

    }

    private void codingInJava7() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("HI jdk1.7");
            }
        };
        new Thread(runnable).start();
    }

    private void codingInJava8() {
        new Thread(() -> System.out.println("HI jdk1.8")).start();
    }

}
