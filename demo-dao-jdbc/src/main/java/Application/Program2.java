package Application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;

import java.util.List;

public class Program2 {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        System.out.println("\n=== TEST 1: department findById ===");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println("\n=== TEST 2: department findAll ===");
        List<Department> departmentList = departmentDao.findAll();

        for (Department department1 : departmentList) {
            System.out.println(department1);
        }
        System.out.println("\n=== TEST 3: seller insert ===");
        Department departmentNew = new Department(null, "Services");
        departmentDao.insert(departmentNew);
        System.out.println("Inserted! New id = " + departmentNew.getId());

        System.out.println("\n=== TEST 4: department update ===");
        department = departmentDao.findById(1);
        department.setName("Product");
        departmentDao.update(department);
        System.out.println("Update completed!");


    }
}
