package com.matafe.javaexamples.concurrent;

import java.util.Collection;

/**
 * This is a simple task list.
 * 
 * @author matafe@gmail.com
 */
class MyTaskList implements Runnable {

  private final Collection<MyTask> tasks;

  public MyTaskList(Collection<MyTask> tasks) {
    this.tasks = tasks;
  }

  public void run() {

    for (MyTask myTask : getTasks()) {
      myTask.run();
    }

  }

  public Collection<MyTask> getTasks() {
    return tasks;
  }

}
