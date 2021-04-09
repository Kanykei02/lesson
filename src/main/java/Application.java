import entity.Employee;
import entity.Pizza;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.Query;
import java.util.List;


public class Application {
    public static void main(String[] args) {
//        Employee employee = new Employee(1, "Alex", 30);
//        Employee employee1 = new Employee(2, "Alexx", 35);
//        Employee employee2 = new Employee(3, "Alexx", 33);

//        create(employee);
//        create(employee1);
//        create(employee2);

//        List<Employee> employeeList = getAll();
//        System.out.println(employeeList);

//        Pizza pizza = new Pizza(1, "Margherita", 400, 3);
        Pizza pizza2 = new Pizza(2, "Marinara", 325, 2);
//        Pizza pizza3 = new Pizza(3, "Carbonara", 650, 4);
//        Pizza pizza4 = new Pizza(4, "Crudo", 230, 2);
          //Pizza pizza5 = new Pizza(5, "Pugliese", 198, 1);
//
//        create(pizza);
//        create(pizza2);
//        create(pizza3);
//        create(pizza4);
//        create(pizza5);

        delete(2);
        deleteAll();

        List<Pizza> pizzaList = getAll();
        System.out.println(pizzaList);

//        pizza5.setName("Tasty");
//
//        update(pizza5);




    }
    public static Integer create(Pizza pizza) {
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        hibernateSession.save(pizza);
        hibernateSession.getTransaction().commit();
        hibernateSession.close();
        System.out.println("Успешно создан " + pizza.toString());
        return pizza.getId();
    }

    public static List<Pizza> getAll() {
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        @SuppressWarnings("uncheked")
        List<Pizza> pizzas = hibernateSession.createQuery("FROM Pizza WHERE price < 350").list();
        hibernateSession.close();
        return pizzas;
    }

    public static void update(Pizza pizza) {
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        Pizza pizaaFromBase = hibernateSession.load(Pizza.class, pizza.getId());
        pizaaFromBase.setName(pizza.getName());
        pizaaFromBase.setPrice(pizza.getPrice());
        hibernateSession.getTransaction().commit();
        hibernateSession.close();
        System.out.println("Успешно изменено " + pizaaFromBase.toString());
    }

    public static Pizza findByID(Integer id) {
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Pizza pizza = hibernateSession.load(Pizza.class, id);
        hibernateSession.close();
        return pizza;
    }

    public static void delete(Integer id) {
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        Pizza pizza = findByID(id);
        //create(pizza);
        hibernateSession.delete(pizza);
        //update(pizza);
        hibernateSession.getTransaction().commit();
        hibernateSession.close();
        System.out.println("успешно удалено " + pizza.toString());
    }

    public static void deleteAll() {
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        Query hibernateQuery = hibernateSession.createQuery("DELETE FROM Pizza");
        hibernateQuery.executeUpdate();
        hibernateSession.getTransaction().commit();
        hibernateSession.close();
        System.out.println("Успешно удалены все записи в Pizza.");
    }
}
