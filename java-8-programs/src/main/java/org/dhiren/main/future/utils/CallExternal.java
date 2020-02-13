package org.dhiren.main.future.utils;

public class CallExternal {

    public static int getTheNumber(int number) {
        sleepForSometime(3000);
        return number * 10;
    }

    public static int doFirst(int number) {
        System.out.println("doFirst() called.. on thread - "+Thread.currentThread().getName());
        if(number % 2 == 0)
            return number / 2;
        else
            return number + 1;
    }

    public static int doSecond(int number) {
        System.out.println("doSecond() called.. on thread - "+Thread.currentThread().getName());
        return number * 3;
    }

    public static String doFinally(int number) {
        System.out.println("doFinally() called.. on thread - "+Thread.currentThread().getName());
        return String.valueOf(number * 10).concat(" DONE");
    }

    public static void sleepForSometime(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void longRunningProcess() {
        sleepForSometime(5000);
        System.out.println("Completed the long running process...");
    }

}
