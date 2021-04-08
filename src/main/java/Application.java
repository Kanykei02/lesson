import entity.Employee;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;


public class Application {
    public static void main(String[] args) {
//        Employee employee = new Employee(1, "Alex", 30);
//        Employee employee1 = new Employee(2, "Alexx", 35);
//        Employee employee2 = new Employee(3, "Alexx", 33);

//        create(employee);
//        create(employee1);
//        create(employee2);

        List<Employee> employeeList = getAll();
        System.out.println(employeeList);
    }
    public static Integer create(Employee employee) {
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        hibernateSession.save(employee);
        hibernateSession.getTransaction().commit();
        hibernateSession.close();
        System.out.println("Успешно создан " + employee.toString());
        return employee.getId();
    }

    public static List<Employee> getAll() {
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        @SuppressWarnings("uncheked")
        List<Employee> employees = hibernateSession.createQuery("FROM Employee").list();
        hibernateSession.close();
        return employees;
    }
}
