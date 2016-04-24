package ru.sberbank.sbt.traineeship.lesson8.issues;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.*;

/**
 * Демонстрация того, можно ли менять final поля у класса или объекта.
 *
 * @version 1.0, 24.04.2016
 * @since        24.04.2016
 */
public class FinalFieldIssue {

  private static final int CONST_INT_VALUE = 123456;

  private static final Integer shouldBeConstValue = 7890;


  public static void main(String[] args) throws Exception {
    updateFinalValue(
      FinalFieldIssue.class.getDeclaredField("CONST_INT_VALUE"),
      0
    );
    System.out.println(CONST_INT_VALUE);

    updateFinalValue(
      FinalFieldIssue.class.getDeclaredField("shouldBeConstValue"),
      0
    );
    System.out.println(shouldBeConstValue);
  }

  private static void updateFinalValue(Field field, Object newValue) throws Exception {
    field.setAccessible(true);

    Field modifiersField = Field.class.getDeclaredField("modifiers");
    modifiersField.setAccessible(true);
    modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

    field.set(null, newValue);
  }

}

