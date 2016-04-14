package ru.sberbank.sbt.traineeship.lesson3.common;

/**
 * Студент ВУЗа.
 *
 * @version 1.0, 08.04.2016
 * @since        08.04.2016
 */
public class Student implements Comparable<Student> {

  /** Номер студенческого билета. */
  private final String cardId;
  public  String getCardId() { return cardId; }

  private String fio;
  public  String getFio() { return fio; }

  private String groupNumber;
  public  String getGroupNumber() { return groupNumber; }


  public static Student create(String cardId) {
    if (cardId == null) {
      throw (
        new NullPointerException(
          "номер студенческого должен быть определен"
        )
      );
    }
    return new Student(cardId); // cardId != null
  }


  private Student(String cardId) {
    this.cardId = cardId;
  }


  public Student setFio(String fio) {
    this.fio = fio;
    return this;
  }

  public Student setGroupNumber(String groupNumber) {
    this.groupNumber = groupNumber;
    return this;
  }


  @Override public int compareTo(final Student o) {
    return cardId.compareTo(o.cardId);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Student student = (Student) o;

    return cardId.equals(student.cardId);

  }

  @Override
  public int hashCode() {
    return cardId.hashCode();
  }

}
