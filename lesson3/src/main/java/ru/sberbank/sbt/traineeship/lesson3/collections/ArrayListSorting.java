package ru.sberbank.sbt.traineeship.lesson3.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Сортировка массивов и коллекций.
 *
 * @version 1.0, 07.04.2016
 * @since        07.04.2016
 */
public class ArrayListSorting {


  private static final String[] studentArray = {"Clara", "Alice", "Diana", "Bob"};

  private static final List<String> students = Arrays.asList(studentArray);

  private static final List<String> studentsAsArrayList = (
    new ArrayList<>(Arrays.asList(studentArray))
  );


  public static void main(String[] args) {
    System.out.println("Несортированный массив: " + Arrays.asList(studentArray));
    new ArrayListSorting()
      .sortStudentArray()
      .print(studentArray, "studentArray")
      .print(students, "students")
      .print(studentsAsArrayList, "studentsAsArrayList")
      //.sortStudents()
      //.sortStudentsAsArrayList()
      //.print(students, "students")
      //.print(studentsAsArrayList, "studentsAsArrayList")
    ;
  }

  private ArrayListSorting sortStudentArray() {
    Arrays.sort(studentArray);
    return this;
  }

  private ArrayListSorting sortStudents() {
    Collections.sort(students);
    return this;
  }

  private ArrayListSorting sortStudentsAsArrayList() {
    Collections.sort(studentsAsArrayList);
    return this;
  }

  private ArrayListSorting print(List list, String name) {
    System.out.println("Отсортированный '" + name + "': "  + list);
    return this;
  }

  private ArrayListSorting print(String[] list, String name) {
    return print(Arrays.asList(list), name);
  }

}
