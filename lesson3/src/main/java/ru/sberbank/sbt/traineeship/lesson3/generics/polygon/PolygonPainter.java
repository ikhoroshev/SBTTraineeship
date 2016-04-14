package ru.sberbank.sbt.traineeship.lesson3.generics.polygon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TODO: Добавить javdoc
 *
 * @version 1.0, 07.04.2016
 * @since 07.04.2016
 */
public class PolygonPainter<T extends Polygon> {


  public static void main(String[] args) {
    List<Polygon> rectangles = new ArrayList<>();
    Collections.sort(rectangles, new AreaComparer());
  }

}
