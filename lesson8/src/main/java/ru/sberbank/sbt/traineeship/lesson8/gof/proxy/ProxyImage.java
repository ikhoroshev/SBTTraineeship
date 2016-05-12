package ru.sberbank.sbt.traineeship.lesson8.gof.proxy;

import java.net.URL;

/**
 * Проксирует изображение.
 *
 * @version 1.0, 26.04.2016
 * @since 26.04.2016
 */
public class ProxyImage implements Image {
  private URL url;

  public ProxyImage(URL url) {
    this.url = url;
  }

  public void displayImage()   {
    Image real = RealImage.create(url);
    real.displayImage();
  }

}
