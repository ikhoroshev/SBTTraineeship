package ru.sberbank.sbt.traineeship.lesson3.arrays;

import org.openjdk.jmh.annotations.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/**
 * Создание копии элементов массива.
 *
 * @version 1.0, 05.04.2016
 * @since        05.04.2016
 */
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1, jvmArgsAppend = {"-XX:+UseParallelGC", "-Xms1g", "-Xmx1g"})
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class ToArrayIssue {


  /** Интерфейс счета. */
  private static class Account {
    private final int        number;  // номер счёта
    private final BigDecimal balance; // остаток

    public Account(final int number, final BigDecimal balance) {
      this.number = number;
      this.balance = balance;
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


  @Param({"0", "1", "10", "100", "1000"})
  private int size;

  @Param({"arraylist", "hashset"})
  private String type;

  private Collection<Account> accounts;


  @Setup
  public void setup() {
    switch (type) {
      case "arraylist":
        accounts = new ArrayList<>();
        break;
      case "hashset":
        accounts = new HashSet<>();
        break;
      default:
        throw new IllegalStateException("Не поддерживаемый тип коллекции: " + type);
    }
    for (int i = 0; i < size; i++) {
      accounts.add(new Account(i, BigDecimal.valueOf(i % 20)));
    }
  }


  @Benchmark
  public Object[] simpleCopy() {
    return accounts.toArray();
  }

  @Benchmark
  public Account[] zeroCopy() {
    return accounts.toArray(new Account[0]);
  }

  @Benchmark
  public Account[] sizedCopy() {
    return accounts.toArray(new Account[accounts.size()]);
  }

}
