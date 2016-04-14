package ru.sberbank.sbt.traineeship.lesson3.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Перенос наследования исходных типов на производные от них типы в прямом порядке.
 *
 * @version 1.0, 05.04.2016
 * @since        05.04.2016
 */
public class Covariance {


  List<? extends Number> playerNumbers = new ArrayList<Integer>() {{ add(1);}}
  ;
  List<? extends Number> weights       = new ArrayList<Float>()   {{ add(2f);}}
  ;
  List<? extends Number> rates         = new ArrayList<Double>()  {{ add(0.);}}
  ;


  private Covariance doSomeInterestingThings() {
    //playerNumbers.add(1);
    playerNumbers.add(null);
    return this;
  }

  private void print() {
    System.out.println(playerNumbers.get(0));
  }

  public static void main(String[] args) {
    new Covariance()
      .doSomeInterestingThings()
      .print()
    ;
  }

}
