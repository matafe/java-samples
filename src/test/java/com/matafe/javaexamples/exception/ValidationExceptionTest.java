package com.matafe.javaexamples.exception;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class ValidationExceptionTest {

  @Before
  public void setUp() throws Exception {}

  @Test(expected = ValidationException.class)
  public void testThrowValidationExceptionSimpleMessage() {
    int errorCode = 1002;
    try {
      throw new ValidationException(errorCode, new IOException("File Read Error"));
    } catch (ValidationException e) {
      assertThat(e.getErrorCode(), equalTo(errorCode));
      assertThat(e.getMessage(), equalTo("Something very bad happened!"));
      throw e;
    }
  }


}
