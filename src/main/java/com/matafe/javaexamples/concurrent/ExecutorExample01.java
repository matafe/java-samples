package com.matafe.javaexamples.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Simple Executor Example.
 * 
 * @author matafe@gmail.com
 */
public class ExecutorExample01 {

  public static void main(String[] args) {

    int nThreads = Runtime.getRuntime().availableProcessors();
    System.out.println("Number of threads = " + nThreads);

    ExecutorService executorService = Executors.newFixedThreadPool(nThreads);

    long init = System.currentTimeMillis();

    // create the tasks that need to execute...
    List<MyTask> tasks = new ArrayList<>();
    for (int i = 0; i < 1000; i++) {
      tasks.add(new MyTask(i));
    }

    System.out.println("Starting to send tasks...");
    // send them to execution...
    for (MyTask myTask : tasks) {
      executorService.submit(myTask);
    }

    System.out.println("All tasks was sent.");

    executorService.shutdown();

    // let's wait all finish here.
    while (!executorService.isTerminated()) {

    }

    long end = System.currentTimeMillis();

    long time = end - init;

    System.out.println("Done. " + time + "msec");
  }

}
