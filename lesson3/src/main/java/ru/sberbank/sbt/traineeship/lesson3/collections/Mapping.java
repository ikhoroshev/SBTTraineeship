package ru.sberbank.sbt.traineeship.lesson3.collections;

import ru.sberbank.sbt.traineeship.lesson3.common.Student;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Map.
 *
 * @version 1.0, 07.04.2016
 * @since        07.04.2016
 */
public class Mapping {

  private Map<Student, String> studentUniversities = new TreeMap<>();
  {
    studentUniversities.put(Student.create("1"), "OmGU");
    studentUniversities.put(Student.create("2"), "OmGMA");
    studentUniversities.put(Student.create("4"), "OmGTU");
    studentUniversities.put(Student.create("3"), "OmGIS");
  }

  private StudentService studentService;

  private void iterationOverMapViaKeySet() {
    for(Student student : studentUniversities.keySet()) {
      studentService.print(student);
      System.out.println(studentUniversities.get(student));
    }
  }

  private void iterationOverMapViaEntrySet() {
    for (
      Map.Entry<Student, String> entry
      : studentUniversities.entrySet()
    ) {
      studentService.print(entry.getKey());
      System.out.println(entry.getValue());
    }
  }


  public static void main(String[] args) {
    Mapping mainClass = new Mapping();
    mainClass.studentService = new StudentService();
    mainClass.iterationOverMapViaEntrySet();
  }

}
