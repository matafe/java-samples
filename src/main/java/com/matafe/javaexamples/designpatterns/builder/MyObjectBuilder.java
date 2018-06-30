package com.matafe.javaexamples.designpatterns.builder;

/**
 * Simple Object Builder
 * 
 * @author matafe@gmail.com
 */
public class MyObjectBuilder {

	private final MyObject object;

	public MyObjectBuilder() {
		this.object = new MyObject();
	}

	public MyObjectBuilder addName(final String name) {
		this.object.setName(name);
		return this;
	}

	public MyObjectBuilder addAge(final int age) {
		this.object.setAge(age);
		return this;
	}

	public MyObjectBuilder addMarried(final boolean married) {
		this.object.setMarried(married);
		return this;
	}

	public MyObject build() {
		return this.object;
	}

}
