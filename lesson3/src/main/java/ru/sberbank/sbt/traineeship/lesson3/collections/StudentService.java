package ru.sberbank.sbt.traineeship.lesson3.collections;

import ru.sberbank.sbt.traineeship.lesson3.common.Student;

/**
 * TODO: Добавить javdoc
 *
 * @version 1.0, 08.04.2016
 * @since 08.04.2016
 */
public class StudentService {


  public void print(Student student) {
    System.out.println(
      String.format(
        "Номер студенческого: %s\n"
        + "ФИО: %s\n"
        + "Номер группы: %s",
        student.getCardId(),
        student.getFio(),
        student.getGroupNumber()
      )
    );
  }


}
