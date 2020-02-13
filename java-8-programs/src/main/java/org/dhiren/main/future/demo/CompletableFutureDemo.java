package org.dhiren.main.future.demo;

import org.dhiren.main.future.utils.CallExternal;

import java.util.concurrent.CompletableFuture;

import static org.dhiren.main.future.utils.CallExternal.getTheNumber;
import static org.dhiren.main.future.utils.CallExternal.sleepForSometime;

public class CompletableFutureDemo {
    public static void main(String[] args) {

        //basicGetTheNumber();
        //basicRunTheProceess();
        chainingMultipleCalls();

    }

    private static void basicRunTheProceess() {
        System.out.println("Process Started...");
        CompletableFuture.runAsync(CallExternal::longRunningProcess);
        System.out.println("Sleeping for sometime..");
        sleepForSometime(5000);
        System.out.println("Process Completed...");
    }

    private static void chainingMultipleCalls() {
        System.out.println("Process Started...");
        CompletableFuture.supplyAsync(() -> getTheNumber(7))
                .thenApplyAsync(CallExternal::doFirst)
                .thenApplyAsync(CallExternal::doSecond)
                .thenApplyAsync(CallExternal::doFinally)
                .thenAccept(System.out::println);
        System.out.println("Sleeping for sometime..");
        sleepForSometime(5000);
        System.out.println("Process Completed...");
    }

    private static void basicGetTheNumber() {
        System.out.println("Process Started...");

        CompletableFuture.supplyAsync(() -> getTheNumber(10))
                .thenAccept(System.out::println);

        System.out.println("Sleeping for sometime..");
        sleepForSometime(3000);
        System.out.println("Process Completed...");
    }

}
