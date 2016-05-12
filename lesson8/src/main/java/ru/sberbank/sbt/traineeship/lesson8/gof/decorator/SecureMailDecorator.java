package ru.sberbank.sbt.traineeship.lesson8.gof.decorator;

/**
 * TODO: добавить javadoc
 * @version 1.0, 26.04.2016
 * @since 26.04.2016
 */
public class SecureMailDecorator extends MailDecorator {

  private String encryptedDescription;

  public SecureMailDecorator(Mail mail) {
    originalEmail = mail;
  }

  @Override public String getContentDescription() {
    if (encryptedDescription != null) {
      encryptedDescription = encrypt(originalEmail.getContentDescription());
    }
    return encryptedDescription;
  }

  private String encrypt(String originalDescription) {
    // Шифруем данные о посылке
    return "";
  }

}

