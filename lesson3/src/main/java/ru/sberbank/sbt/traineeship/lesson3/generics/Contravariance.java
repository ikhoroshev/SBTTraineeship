package ru.sberbank.sbt.traineeship.lesson3.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Перенос наследования исходных типов на производные от них типы в обратном порядке.
 *
 * @version 1.0, 05.04.2016
 * @since        05.04.2016
 */
public class Contravariance {


  List<? super Number> playerNumbers = new ArrayList<Number>() // {{ add(1);}}
  ;


  private Contravariance doSomeInterestingThings() {
    // playerNumbers.add(0);
    // playerNumbers.add(null);
    // playerNumbers.add(-.1);
    return this;
  }

  private void print() {
    // final Number playerNumber = playerNumbers.get(0);
    // System.out.println(playerNumbers.get(0));
    // System.out.println(playerNumber);
  }

  public static void main(String[] args) {
    new Contravariance()
      .doSomeInterestingThings()
      .print()
    ;
  }

}
