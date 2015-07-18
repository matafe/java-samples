package com.matafe.javaexamples.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.matafe.javaexamples.util.CollectionUtils;

/**
 * Simple Executor Example 02.
 * 
 * @author matafe@gmail.com
 */
public class ExecutorExample02 {

	public static void main(String[] args) {

		int nThreads = Runtime.getRuntime().availableProcessors();
		System.out.println("Number of threads = " + nThreads);

		ExecutorService executorService = Executors
				.newFixedThreadPool(nThreads);

		long init = System.currentTimeMillis();

		// create the tasks that need to execute...
		List<MyTask> tasks = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			tasks.add(new MyTask(i));
		}

		// Will hold 10 list with 100 elements each.
		Collection<Collection<MyTask>> splitList = CollectionUtils.split(tasks,
				100);

		System.out.println("Starting to send tasks...");

		for (Collection<MyTask> innerList : splitList) {

			// send them to execution...in batch
			executorService.submit(new MyTaskList(innerList));
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
