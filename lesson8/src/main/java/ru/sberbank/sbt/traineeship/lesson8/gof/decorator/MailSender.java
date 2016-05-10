package ru.sberbank.sbt.traineeship.lesson8.gof.decorator;

/**
 * Сервис отправки почтовых сообщений.
 *
 * @version 1.0, 26.04.2016
 * @since        26.04.2016
 */
public class MailSender {

  public void sendEmail(Mail mail)   {
    // Если почтовое отправление с грифом "секретно",
    // то шифруем информацию от отправителе/получателе
    mail = new SecureMailDecorator(mail);

    // Отправка посылки
  }

}
