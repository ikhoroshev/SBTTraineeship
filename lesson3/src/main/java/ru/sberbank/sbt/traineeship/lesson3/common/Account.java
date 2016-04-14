package ru.sberbank.sbt.traineeship.lesson3.common;


/**
 * Интерфейс счета.
 *
 * @version 1.0, 07.04.2016
 * @since        07.04.2016
 */
public class Account {


  private final int number;  // номер счёта


  public Account(final int number) {
    this.number = number;
  }

  @Override public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Account account = (Account) o;
    return number == account.number;
  }

  @Override public int hashCode() {
    return number;
  }

}