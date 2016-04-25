import bean.Person;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by admin on 20.04.2016.
 */
public class Main {
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


        Main main = new Main();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.M.yyyy");

        /* Add few persons records in database */
        Integer id1 = main.addPerson("Вилкин", 10000, sdf.parse("15.6.2011"));
        Integer id2 = main.addPerson("Сковородкин", 33033, sdf.parse("15.6.2001"));
        Integer id3 = main.addPerson("Печкин", 22000, sdf.parse("1.4.2016"));

        /* List down all the persons */
        main.listPerson();

        /* Update person's records */
        main.updatePerson(id1, 15000);

        /* Delete an person from the database */
        main.deletePerson(id2);

        /* List down new list of the persons */
        main.listPerson();

        main.getPersonByCriteria1();

        main.getPersonById(20);

        main.getPersonById2(27);
    }

    public Integer addPerson(String name, int salary, Date sinceDt) {
        Session session = getSession();
        Transaction tx = null;
        Integer newId = null;
        try {
            tx = session.beginTransaction();
            Person person = new Person(name, salary, sinceDt);
            newId = (Integer) session.save(person);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return newId;
    }

    public void listPerson() {
        Session session = getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List persons = session.createQuery("FROM bean.Person").list();
            for (Iterator iterator = persons.iterator(); iterator.hasNext(); ) {
                Person person = (Person) iterator.next();
                System.out.print("Name: " + person.getName() + "\t|\t");
                System.out.print("Salary: " + person.getSalary() + "\t|\t");
                System.out.println("Since date: " + person.getSinceDt() + "\n");
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

    public void updatePerson(Integer id, int salary) {
        Session session = getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Person person = (Person) session.get(Person.class, id);
            person.setSalary(salary);
            session.update(person);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deletePerson(Integer personId) {
        Session session = getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Person person = (Person) session.get(Person.class, personId);
            session.delete(person);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private void getPersonByCriteria1() {
        Session session = getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            List persons = session.createCriteria(Person.class)
                    .add(Restrictions.ge("salary", 15000))
                    .add(Restrictions.lt("salary", 30000))
                    .addOrder(Order.asc("sinceDt")).list();

            for (Iterator iterator = persons.iterator(); iterator.hasNext(); ) {
                Person person = (Person) iterator.next();
                System.out.print("Name: " + person.getName() + "\t|\t");
                System.out.print("Salary: " + person.getSalary() + "\t|\t");
                System.out.println("Since date: " + person.getSinceDt() + "\n");
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

    private void getPersonById(int id) {
        Session session = getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            List persons = session.getNamedQuery("bean.Person.findByPersonId")
                    .setInteger("personId", id)
                    .setMaxResults(10)
                    .list();

            for (Iterator iterator = persons.iterator(); iterator.hasNext(); ) {
                Person person = (Person) iterator.next();
                System.out.print("Name: " + person.getName() + "\t|\t");
                System.out.print("Salary: " + person.getSalary() + "\t|\t");
                System.out.println("Since date: " + person.getSinceDt() + "\n");
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

    private void getPersonById2(int id) {
        Session session = getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            List persons = session.getNamedQuery("bean.Person.findByPersonIdCdata")
                    .setInteger("personId", id)
                    .setMaxResults(10)
                    .list();

            for (Iterator iterator = persons.iterator(); iterator.hasNext(); ) {
                Person person = (Person) iterator.next();
                System.out.print("Name: " + person.getName() + "\t|\t");
                System.out.print("Salary: " + person.getSalary() + "\t|\t");
                System.out.println("Since date: " + person.getSinceDt() + "\n");
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
