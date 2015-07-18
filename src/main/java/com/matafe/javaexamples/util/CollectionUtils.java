package com.matafe.javaexamples.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Collection Utility.
 * 
 * @author matafe@gmail.com
 */
public abstract class CollectionUtils {

	/**
	 * Returns a new list with inner lists with max elements on the inner list
	 * as defined on parameter <code>maxsize</code>.
	 * 
	 * @param collection
	 *            The collection to be splitted.
	 * @param maxsize
	 *            The max size of element on each inner list.
	 * 
	 * @return The list of lists.
	 */
	public static <T> Collection<Collection<T>> split(
			final Collection<T> collection, final int maxsize) {

		Collection<Collection<T>> ncol = new ArrayList<Collection<T>>();
		Collection<T> c = null;

		int i = 0;
		for (Iterator<T> iterator = collection.iterator(); iterator.hasNext(); i++) {
			if ((i % maxsize) == 0) {
				ncol.add(c = new ArrayList<T>(maxsize));
			}
			c.add(iterator.next());
		}

		return ncol;
	}

}
