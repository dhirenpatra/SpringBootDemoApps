package org.dhiren.main.future.utils;

import java.util.concurrent.CompletableFuture;

public class ProcessPipeline {

    public static void executePipelineOne(CompletableFuture<Integer> future) {
        future.thenApply(integer -> integer * 5)
                .thenApply(integer -> integer + 100)
                .thenAccept(System.out::println);
    }

    public static void executePipelineTwo(CompletableFuture<String> future) {
        future.thenApply(String::trim)
                .thenApply(String::toUpperCase)
                .thenApply(String::length)
                .thenApply(length -> length * 10)
                .thenAccept(System.out::println);
    }
}
