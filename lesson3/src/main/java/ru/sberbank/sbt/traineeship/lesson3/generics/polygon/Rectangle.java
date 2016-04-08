package ru.sberbank.sbt.traineeship.lesson3.generics.polygon;

/**
 * TODO: Добавить javdoc
 *
 * @version 1.0, 07.04.2016
 * @since 07.04.2016
 */
public class Rectangle implements Polygon {


  public static final int NUMBER_OF_SIDES = 4;
  private double width;
  private double height;


  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  @Override
  public int getNumberOfSides() {
    return NUMBER_OF_SIDES;
  }

}
