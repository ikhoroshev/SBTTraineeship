package ru.sberbank.sbt.traineeship.lesson3.arrays;

import ru.sberbank.sbt.traineeship.lesson3.common.Student;

import java.util.Arrays;

/**
 * Сортировка массивов, коллекций.
 *
 * @version 1.0, 06.04.2016
 * @since        06.04.2016
 */
public class ArraySort {


  private Student[] students = (
    new Student[] {
    }
  );


  private ArraySort print() {
    return this;
  }

  private ArraySort sort() {
    return this;
  }

  public static void main(String[] args) {
    new ArraySort()
      .print()
      .sort()
      .print()
    ;
  }

}
