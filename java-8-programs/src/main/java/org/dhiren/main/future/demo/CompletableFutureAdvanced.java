package org.dhiren.main.future.demo;

import org.dhiren.main.future.utils.ProcessPipeline;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureAdvanced {

    public static void main(String[] args) {
        executePipelineTwo(" DHIREN ");
        executePipelineOne(2);
    }

    private static void executePipelineOne(int value) {
        CompletableFuture<Integer> integerCompletableFuture =
                new CompletableFuture<>();
        ProcessPipeline.executePipelineOne(integerCompletableFuture);
        integerCompletableFuture.complete(value);
    }

    private static void executePipelineTwo(String value) {
        CompletableFuture<String> integerCompletableFuture =
                new CompletableFuture<>();
        ProcessPipeline.executePipelineTwo(integerCompletableFuture);
        integerCompletableFuture.complete(value);
    }

}
