package ru.sberbank.sbt.traineeship.lesson3.generics;


/**
 * Сокрытие типа любого объекта за общим типом.
 *
 * @version 1.0, 05.04.2016
 * @since        05.04.2016
 */
public class TypeErasure {


  private static final String HELLO = "Hello";
  private static final Number PI    = 3.14;


  private static final class KeyValueHolder<K, V> {
    K key;
    V value;

    void print() {
      System.out.println("Key: " + key);
      System.out.println("Value: " + value);
    }
  }


  @SuppressWarnings("unchecked")
  private static <S, U> KeyValueHolder<S, U> create(Object key, Object value) {

    KeyValueHolder<S, U> result = new KeyValueHolder<>();

    result.key   = (S) key;
    result.value = (U) value;

    return result;
  }


  private static <S, U> KeyValueHolder<S, U> createWithGenerics(S key, U value) {

    KeyValueHolder<S, U> result = new KeyValueHolder<>();

    result.key   = key;
    result.value = value;

    return result;
  }


  private void doSomeInterestingThings() {
/*    KeyValueHolder<String, Double> stringDoublePair;
    stringDoublePair = create(HELLO, PI);
    stringDoublePair.print();

    KeyValueHolder<String, String> stringPairs;
    stringPairs = create(HELLO, PI);
    stringPairs.print();

    KeyValueHolder<Double, Integer> doubleIntegerPairs;
    doubleIntegerPairs = create(HELLO, PI);
    doubleIntegerPairs.print();*/

    KeyValueHolder<String, Number> stringNumberPair;
    stringNumberPair = createWithGenerics(HELLO, PI);
    stringNumberPair.print();
  }


  public static void main(String[] args) {
    new TypeErasure().doSomeInterestingThings();
  }

}
