package com.matafe.javaexamples.exception;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class GenericExceptionTest {

  @Before
  public void setUp() throws Exception {}

  @Test(expected = GenericException.class)
  public void testThrowGenericExceptionSimpleMessage() {
    int errorCode = 1002;
    try {
      throw new GenericException(errorCode, new IOException("File Read Error"));
    } catch (GenericException e) {
      assertThat(e.getErrorCode(), equalTo(errorCode));
      assertThat(e.getMessage(), equalTo("Algo muito ruim aconteceu!"));
      throw e;
    }
  }

  @Test(expected = GenericException.class)
  public void testThrowGenericExceptionNoErrorCode() {
    int errorCode = 0;
    try {
      throw new GenericException(errorCode, new IOException());
    } catch (GenericException e) {
      assertThat(e.getErrorCode(), equalTo(errorCode));
      assertThat(e.getMessage(),
          equalTo("Can't find resource for bundle java.util.PropertyResourceBundle, key 0"));
      throw e;
    }
  }

  @Test(expected = GenericException.class)
  public void testThrowGenericExceptionSingleArg() {
    int errorCode = 1000;
    try {
      throw new GenericException(errorCode, new IOException());
    } catch (GenericException e) {
      assertThat(e.getErrorCode(), equalTo(errorCode));
      assertThat(e.getMessage(), equalTo("{0}"));
      throw e;
    }
  }

  @Test(expected = GenericException.class)
  public void testThrowGenericExceptionMessageWithOneArg() {
    int errorCode = 1001;
    try {
      throw new GenericException(errorCode, new IOException(), "file.txt");
    } catch (GenericException e) {
      assertThat(e.getErrorCode(), equalTo(errorCode));
      assertThat(e.getMessage(), equalTo("Generic Error: file.txt"));
      throw e;
    }
  }

  @Test(expected = GenericException.class)
  public void testThrowGenericExceptionMessageWithNoException() {
    int errorCode = 1002;
    try {
      throw new GenericException(errorCode);
    } catch (GenericException e) {
      assertThat(e.getErrorCode(), equalTo(errorCode));
      assertThat(e.getMessage(), equalTo("Algo muito ruim aconteceu!"));
      throw e;
    }
  }

}
