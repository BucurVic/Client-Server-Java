package Inot.Services;

public class InotException extends Exception{
  public InotException() {
  }

  public InotException(String message) {
    super(message);
  }

  public InotException(String message, Throwable cause) {
    super(message, cause);
  }
}