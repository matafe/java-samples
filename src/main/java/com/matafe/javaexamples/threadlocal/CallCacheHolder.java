package com.matafe.javaexamples.threadlocal;

/**
 * Represents the object that hold the cache during the thread execution.
 * 
 * @author matafe@gmail.com
 */
public class CallCacheHolder {

	private static final ThreadLocal<CallCache> THREAD_LOCAL_CACHE = new ThreadLocal<>();

	public static CallCache getCache() {
		return THREAD_LOCAL_CACHE.get();
	}

	public static CallCache createCache() {
		THREAD_LOCAL_CACHE.set(new CallCache());
		return getCache();
	}
}
