package app.back.springtemplate.exception;

public class NotFoundStudent extends RuntimeException {
  public NotFoundStudent(int registration) {
    super("Student not found: " + registration);
  }
}
