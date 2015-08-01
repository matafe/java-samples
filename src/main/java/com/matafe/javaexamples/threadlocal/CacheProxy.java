package com.matafe.javaexamples.threadlocal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * This is a <strong>Proxy</strong> design pattern for the Cache.
 * 
 * @author matafe@gmail.com
 */
public class CacheProxy implements InvocationHandler {

	private Object obj;

	public static Object newInstance(Object obj) {
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
				.getClass().getInterfaces(), new CacheProxy(obj));
	}

	private CacheProxy(Object obj) {
		this.obj = obj;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		Object result = null;

		try {

			CallCache cache = CallCacheHolder.getCache();

			if (cache == null) {
				cache = CallCacheHolder.createCache();
			}

			CallCacheArgs cArgs = new CallCacheArgs(args);

			String methodName = method.getName();
			result = cache.get(methodName, cArgs);

			if (result != null) {
				return result;
			} else {
				result = method.invoke(obj, args);
				cache.put(methodName, cArgs, result);
			}
		} catch (InvocationTargetException e) {
			throw e.getTargetException();
		} catch (Exception e) {
			throw new RuntimeException("Unexpected invocation exception: ", e);

		}
		return result;
	}
}
