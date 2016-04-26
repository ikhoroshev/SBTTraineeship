package ru.sberbank.sbt.traineeship.lesson8.gof.proxy;

import java.net.URL;

/**
 * TODO: добавить javadoc
 * @version 1.0, 26.04.2016
 * @since 26.04.2016
 */
public class RealImage implements Image {

  private RealImage() { }

  public static Image create(URL url) {
    return (
      new RealImage()
        .loadImage(url)
    );
  }

  @Override public void displayImage() {
  }

  /** Выполняет загрузку изображения. */
  private RealImage loadImage(URL url)  {
    return this;
  }

}
