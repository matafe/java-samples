package com.matafe.javaexamples.concurrent;

/**
 * This is a simple task.
 * 
 * @author matafe@gmail.com
 */
class MyTask implements Runnable {

	private final int n;

	public MyTask(int n) {
		this.n = n;
	}

	public void run() {

		try {
			// each task spent 100 msec to execute.
			Thread.sleep(100);
			System.out.println("Task = " + n + " executed!");
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}