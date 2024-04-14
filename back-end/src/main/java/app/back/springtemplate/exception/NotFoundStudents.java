package app.back.springtemplate.exception;

public class NotFoundStudents extends RuntimeException {
  public NotFoundStudents() {
    super("0 students registered.");
  }
}
