package app.back.springtemplate.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Student entity.
 */
@Entity
@Table(name = "students")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(unique = true, name = "registration", nullable = false)
  private int registration;

  @Column(name = "student_name", nullable = false)
  private String studentName;

  @Column(name = "average_grade")
  private Double averageGrade;

  @Column(name = "english_grade")
  private Double englishGrade;

  @Column(name = "portuguese_grade")
  private Double portugueseGrade;

  @Column(name = "japanese_grade")
  private Double japaneseGrade;

  /**
   * Constructor.
   * Student id @param id
   * Student registration @param registration
   * Student name @param studentName
   * Student grade @param averageGrade
   * English grade @param englishGrade
   * Portuguese grade @param portugueseGrade
   * Japanese grade @param japaneseGrade
   */
  public Student(Integer id, int registration, String studentName, Double averageGrade, Double englishGrade,
      Double portugueseGrade, Double japaneseGrade) {
    this.id = id;
    this.registration = registration;
    this.studentName = studentName;
    this.averageGrade = averageGrade;
    this.englishGrade = englishGrade;
    this.portugueseGrade = portugueseGrade;
    this.japaneseGrade = japaneseGrade;
  }

  public Student() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getRegistration() {
    return registration;
  }

  public void setRegistration(int registration) {
    this.registration = registration;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public void setAverageGrade(Double averageGrade) {
    this.averageGrade = averageGrade;
  }

  public Double getAverageGrade() {
    return this.averageGrade;
  }

  public Double getEnglishGrade() {
    return englishGrade;
  }

  public void setEnglishGrade(Double englishGrade) {
    this.englishGrade = englishGrade;
    this.calculateAverageGrade();
  }

  public Double getPortugueseGrade() {
    return portugueseGrade;
  }

  public void setPortugueseGrade(Double portugueseGrade) {
    this.portugueseGrade = portugueseGrade;
    this.calculateAverageGrade();
  }

  public Double getJapaneseGrade() {
    return japaneseGrade;
  }

  public void setJapaneseGrade(Double japaneseGrade) {
    this.japaneseGrade = japaneseGrade;
    this.calculateAverageGrade();
  }

  private void calculateAverageGrade() {
    double totalGrades = 0.0;
    int count = 0;

    if (englishGrade != null) {
      totalGrades += englishGrade;
      count++;
    }
    if (portugueseGrade != null) {
      totalGrades += portugueseGrade;
      count++;
    }
    if (japaneseGrade != null) {
      totalGrades += japaneseGrade;
      count++;
    }

    if (count > 0) {
      this.averageGrade = totalGrades / count;
    } else {
      this.averageGrade = 0.0;
    }
  }
}
