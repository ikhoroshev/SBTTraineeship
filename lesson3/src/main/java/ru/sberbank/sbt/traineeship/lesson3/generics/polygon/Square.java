package ru.sberbank.sbt.traineeship.lesson3.generics.polygon;

import java.util.Collections;

/**
 * Created by Alex on 07.04.2016.
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
