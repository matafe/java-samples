package com.matafe.javaexamples.exception;

/**
 * Validation Exception
 * 
 * @author matafe@gmail.com
 */
public class ValidationException extends ApplicationException implements IQuiteException {

  private static final long serialVersionUID = 1L;

  public ValidationException(final int errorCode) {
    super(DEFAULT_ERROR_FILE, errorCode);
  }

  public ValidationException(final int errorCode, final Object... args) {
    super(DEFAULT_ERROR_FILE, errorCode, args);
  }

  public ValidationException(final int errorCode, Throwable throwable) {
    super(DEFAULT_ERROR_FILE, errorCode, throwable);
  }

  public ValidationException(final int errorCode, Throwable throwable, final Object... args) {
    super(DEFAULT_ERROR_FILE, errorCode, throwable, args);
  }

}
