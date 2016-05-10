package ru.sberbank.sbt.traineeship.lesson3.arrays;

import ru.sberbank.sbt.traineeship.lesson3.generics.polygon.Shape;
import ru.sberbank.sbt.traineeship.lesson3.generics.polygon.Triangle;

import java.util.Collections;
import java.util.List;

/**
 * Ковариантность массивов.
 *
 * @version 1.0, 08.04.2016
 * @since        08.04.2016
 */
public class ArrayCovariance {

  static Shape[] createShapes(Triangle[] triangles) {
    return new Shape[0]; // ?
  }

  static List<Shape> createShapes(List<Triangle> triangles) {
    return Collections.emptyList(); // ?
  }

  public static void main(String[] args) {
  }

}
