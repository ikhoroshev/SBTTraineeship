package ru.sberbank.sbt.traineeship.lesson8.issues;


/**
 * Исключения в конструкторах нефинализованных классов.
 *
 * @version 1.0, 24.04.2016
 * @since 24.04.2016
 */
public class ExceptionInConstructorIssue {

  public static void main(String[] args) {
    BankOperation operation;
    try {
      operation = new BankOperation();
    } catch (SecurityException e) {
      System.out.println(e.getMessage());
      operation = null;
    }
    Storage.store(operation);
    System.out.println("Обычный ход выполнения");
  }
}


class BankOperation {

  public BankOperation() {
    if (!checkAccess()) {
      throw new SecurityException("Доступ запрещен!");
    }
  }

  /** Возвращает {@code true}, если есть право на перевод денежных средств. */
  public boolean checkAccess() {
    // представим, что проверка не пройдена,
    // злономеренный пользовать указывает неверные данные и т.п.
    return false;
  }

  public void makeMoneyTransfer() {
    System.out.println("Деньги успешно переведены");
  }
}


class Storage {
  private static BankOperation operation;

  public static void store(BankOperation value) {
    // Храним только проинициализированный объект
    if (operation == null) {
      if (value == null) {
        System.out.println("Объект не проинициализирован");
        System.exit(1);
      }
      operation = value;
    }
  }
}


class MaliciousCode extends BankOperation {

  private static MaliciousCode stealInstance = null;

  public static MaliciousCode get() {
    try {
      new MaliciousCode();
    } catch (Exception ex) {
      /* Игнорируем исключение в конструкторе */
    }
    try {
      synchronized (MaliciousCode.class) {
        while (stealInstance == null) {
          System.gc();
          MaliciousCode.class.wait(10);
        }
      }
    } catch (InterruptedException ex) {
      return null;
    }
    return stealInstance;
  }

  @Override
  protected void finalize() throws Throwable {
    synchronized (MaliciousCode.class) {
      stealInstance = this;
      MaliciousCode.class.notify();
    }
    System.out.println("Получили недосозданный объект" + this);
  }

}


class AttackerApplication {
  public static void main(String[] args) {
    MaliciousCode exploited = MaliciousCode.get(); // получаем недосозданный объект
    // прихраниваем его
    Storage.store(exploited);

    // выполняем вывод средств
    exploited.makeMoneyTransfer();

    // запускаем обычный сценарий выполнения, который выдаст ошибку доступа и т.п.
    ExceptionInConstructorIssue.main(args);
  }

}
