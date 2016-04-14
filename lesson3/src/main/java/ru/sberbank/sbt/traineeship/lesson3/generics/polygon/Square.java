package ru.sberbank.sbt.traineeship.lesson3.generics.polygon;


/**
 * Квадрат.
 *
 * @version 1.0, 07.04.2016
 * @since        07.04.2016
 */
public class Square extends Rectangle {

  @Override
  public void setWidth(double width) {
    super.setWidth(width);
    setHeight(width);
  }

  @Override
  public void setHeight(double height) {
    super.setHeight(height);
    setWidth(height);
  }

}
