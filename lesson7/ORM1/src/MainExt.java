import bean.PersonExt;
import bean.Task;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.text.SimpleDateFormat;
import java.util.*;

public class MainExt {
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {

        MainExt main = new MainExt();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.M.yyyy");

        /* Add few persons records in database */
        Set tasks = new HashSet<Task>();
        tasks.add(new Task("срочное дело", 2));
        tasks.add(new Task("не срочное дело", 5));

        Integer id = main.addPerson("Скалкин", 10000, sdf.parse("12.8.2015"), tasks);

        System.out.println("new id = " + id);

        main.getPersonByTasks(1);
    }

    public Integer addPerson(String name, int salary, Date sinceDt, Set<Task> tasks) {
        Session session = getSession();
        Transaction tx = null;
        Integer newId = null;
        try {
            tx = session.beginTransaction();
            PersonExt person = new PersonExt(name, salary, sinceDt);
            person.setTasks(tasks);
            newId = (Integer) session.save(person);

            for (Task task : tasks) {
                task.setPerson(person);
                session.save(task);
            }

            person.getTasks().addAll(tasks);
            session.save(person);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return newId;
    }

    private void getPersonByTasks(int tasksNumber) {
        Session session = getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            List<Object[]> persons = session.getNamedQuery("bean.PersonExt.getHardWorkingPersons")
                    .setInteger("tasksNumberAtLeast", tasksNumber)
                    .setMaxResults(10)
                    .list();

            for (Object[] obj : persons) {
                System.out.print("Name: " + obj[0] + "\t|\t");
                System.out.print("Salary: " + obj[1] + "\t|\t");
                System.out.println("Hours: " + obj[2] + "\n");
            }
            System.out.println("===============================");
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
