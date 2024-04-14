package app.back.springtemplate.controllers;

import app.back.springtemplate.controllers.Dto.ResponseDto;
import app.back.springtemplate.models.entity.Student;
import app.back.springtemplate.services.StudentService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Students rest controller.
 */
@RestController
@RequestMapping("")
public class StudentController {
  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  /**
   * Method that takes student object and sends it to the service. 
   * Object Student @param stu
   * Student object created @return
   */
  @PostMapping("/students")
  public ResponseEntity<ResponseDto<Student>> createStudent(@RequestBody Student stu) {
    try {
      Student student = studentService.registerStudent(stu);

      ResponseDto<Student> res = new ResponseDto<Student>("registered sucessfully.", student);

      return ResponseEntity.status(HttpStatus.CREATED).body(res);
    } catch (Exception e) {
      ResponseDto<Student> res = new ResponseDto<Student>(e.getMessage(), null);

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
    }
  }

  /**
   * Method that returns a list of all students.
   * Students object @return
   */
  @GetMapping("/students")
  public ResponseEntity<ResponseDto<List<Student>>> readAllStudents() {
    try {
      List<Student> students = studentService.getAllStudents();

      ResponseDto<List<Student>> res = new ResponseDto<List<Student>>("found sucessfully.", students);

      return ResponseEntity.status(HttpStatus.OK).body(res);
    } catch (Exception e) {
      ResponseDto<List<Student>> res = new ResponseDto<List<Student>>(e.getMessage(), null);

      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
    }
  }

  /**
   * Method that take a updated student object and registration for check
   * credentials.
   * Registration id @param registration
   * Student object updated @param stu
   * Student updated @return
   */
  @PutMapping("/students/update/{registration}")
  public ResponseEntity<ResponseDto<Student>> updateStudentByRegistration(@PathVariable int registration,
      @RequestBody Student stu) {
    try {
      Student student = studentService.updateStudentByRegistration(registration, stu);

      ResponseDto<Student> res = new ResponseDto<Student>("student updated sucessfully.", student);

      return ResponseEntity.status(HttpStatus.OK).body(res);
    } catch (Exception e) {
      ResponseDto<Student> res = new ResponseDto<Student>(e.getMessage(), null);

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }
  }
  
  /**
   * Method that delete a user by credentials.
   * Registration id @param registration
   * Request @param req
   * Student deleted @return
   */
  @DeleteMapping("/students/delete/{registration}")
  public ResponseEntity<ResponseDto<Student>> deleteStudentByRegistration(@PathVariable int registration,
      @RequestBody Map<String, String> req) {
    try {
      String studentName = req.get("studentName");

      Student student = studentService.deleteStudentByRegistration(registration, studentName);

      ResponseDto<Student> res = new ResponseDto<Student>("user deleted sucessfully.", student);

      return ResponseEntity.status(HttpStatus.OK).body(res);
    } catch (Exception e) {
      ResponseDto<Student> res = new ResponseDto<Student>(e.getMessage(), null);

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }
  }
}
