package app.back.springtemplate.services;

import app.back.springtemplate.exception.NotFoundStudent;
import app.back.springtemplate.exception.NotFoundStudents;
import app.back.springtemplate.models.entity.Student;
import app.back.springtemplate.models.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Student service.
 */
@Service
public class StudentService {
  private final StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  /**
   * Method that returns to controller all students
   * 
   * @return
   */
  public List<Student> getAllStudents() {
    List<Student> students = studentRepository.findAll();

    if (students.isEmpty()) {
      throw new NotFoundStudents();
    }

    return students;
  }

  public Student registerStudent(Student student) {
    return studentRepository.save(student);
  }

  /**
   * Method that update student grades and return to controller updated student.
   * Registration id @param registration
   * Student @param updatedStudent
   * Updated Student @return
   */
  public Student updateStudentByRegistration(int registration, Student updatedStudent) {
    Optional<Student> stu = studentRepository.findStudentByRegistration(registration);

    if (stu.isEmpty()) {
      throw new NotFoundStudent(registration);
    }

    Student student = stu.get();

    if (updatedStudent.getEnglishGrade() != null) {
      student.setEnglishGrade(updatedStudent.getEnglishGrade());
    }
    if (updatedStudent.getPortugueseGrade() != null) {
      student.setPortugueseGrade(updatedStudent.getPortugueseGrade());
    }
    if (updatedStudent.getJapaneseGrade() != null) {
      student.setJapaneseGrade(updatedStudent.getJapaneseGrade());
    }

    return studentRepository.save(student);
  }

  /**
   * Method that delete a student by credentials.
   * Registration id @param registration
   * Student name @param studentName
   * Deleted student @return
   */
  public Student deleteStudentByRegistration(int registration, String studentName) {
    Optional<Student> stu = studentRepository.findStudentByStudentName(studentName);

    if (stu.isEmpty()) {
      throw new NotFoundStudent(registration);
    }

    if (stu.get().getRegistration() != registration) {
      throw new IllegalArgumentException("credentials don't match.");
    }

    Student student = stu.get();
    studentRepository.delete(student);

    return student;
  }
}
