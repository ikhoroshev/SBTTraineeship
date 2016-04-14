package ru.sberbank.sbt.traineeship.lesson3.collections;

import ru.sberbank.sbt.traineeship.lesson3.common.Student;

/**
 * TODO: Добавить javdoc
 *
 * @version 1.0, 08.04.2016
 * @since 08.04.2016
 */
public class StudentController {

  private StudentService studentService;

  public void process(String cardId, String fio, String groupNumber) {
    studentService.print(
      Student
        .create(cardId)
        .setFio(fio)
        .setGroupNumber(groupNumber)
    );
  }

}
