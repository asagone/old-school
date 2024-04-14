package app.back.springtemplate.models.repository;

import app.back.springtemplate.models.entity.Student;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Student repository.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
  public Optional<Student> findStudentByRegistration(int registration);

  public Optional<Student> findStudentByStudentName(String studentName);
}
