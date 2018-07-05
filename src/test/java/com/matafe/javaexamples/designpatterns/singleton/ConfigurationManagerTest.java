package com.matafe.javaexamples.designpatterns.singleton;

import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import mockit.integration.junit4.JMockit;

/**
 * Unit Test for <code>ConfigurationManager</code>.
 * 
 * @author matafe@gmail.com
 */
@RunWith(JMockit.class)
public class ConfigurationManagerTest {

  @Before
  public void setUp() throws Exception {}

  @Test
  public void test() {
    
    System.out.println(
        "database.url => " + ConfigurationManager.getInstance().getProperty("database.url"));

    Map<String, Object> properties = ConfigurationManager.getInstance().getProperties();
    
    System.out.println(properties);
  }

}
