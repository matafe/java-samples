package com.matafe.javaexamples.designpatterns.builder;

/**
 * Simple Object
 * 
 * @author matafe@gmail.com
 */
public class MyObject {

	private String name;

	private int age;

	private boolean married;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	@Override
	public String toString() {
		return "MyObject [name=" + name + ", age=" + age + ", married=" + married + "]";
	}

}
