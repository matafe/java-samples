package com.matafe.javaexamples.designpatterns.builder;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Simple Map Builder
 * 
 * @author matafe@gmail.com
 */
public class MapBuilder {

  private final Map<String, Object> map;

  public MapBuilder() {
    this.map = new HashMap<>();
  }

  public MapBuilder put(final String key, final Object value) {
    this.map.put(key, value);
    return this;
  }

  public Map<String, Object> build() {
    return this.map;
  }

  public static void main(String[] args) {
    MapBuilder mapBuilder = new MapBuilder();
    Map<String, Object> map =
        mapBuilder.put("name", "My name").put("age", 30).put("married", true).build();
    for (Entry<String, Object> entry : map.entrySet()) {
      System.out.println(entry);
    }
  }

}
