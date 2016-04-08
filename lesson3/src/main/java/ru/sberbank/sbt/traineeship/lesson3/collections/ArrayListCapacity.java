package ru.sberbank.sbt.traineeship.lesson3.collections;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Вместимость {@code ArrayList}.
 * @version 1.0, 07.04.2016
 * @since 07.04.2016
 */
public class ArrayListCapacity {


  private static final ArrayList<String> students = (
    new ArrayList<>(Arrays.asList("Clara", "Alice", "Diana", "Bob"))
  );

  private static final ArrayList<String> teachers = new ArrayList<String>() {{
      add("Helen");
      add("Ben");
      add("Donal");
      add("Maria");
    }}
  ;


  public static void main(String[] args) throws Exception {
    System.out.println("Изначальная вместимость 'students': " + getCapacity(students));
    System.out.println("Изначальная вместимость 'teachers': " + getCapacity(teachers));
    students.trimToSize();
    teachers.trimToSize();
    System.out.println(
      String.format(
        "Конечная вместимость 'students': %s, 'teachers': %s",
        getCapacity(students),
        getCapacity(teachers)
      )
    );
    printCapacityGrowing();
  }

  private static void printCapacityGrowing() {
    ArrayList<Integer> list = new ArrayList<Integer>(3);
    for (int i = 0; i < 13; i++) {
      list.add(i);
      System.out.format("Size: %2d, Capacity: %2d%n",
        list.size(), getCapacity(list));
    }
  }


  private static int getCapacity(final ArrayList arrayList) {
    try {
      final Field dataField = ArrayList.class.getDeclaredField("elementData");
      dataField.setAccessible(true);
      return ((Object[]) dataField.get(arrayList)).length;
    } catch (IllegalAccessException | NoSuchFieldException e) {
      throw new IllegalArgumentException(e);
    }
  }

}
