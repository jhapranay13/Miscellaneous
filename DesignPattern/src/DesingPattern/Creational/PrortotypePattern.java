package DesingPattern.Creational;

/**
 *
 * Create Object by cloning
 * Dynamically change object creation
 *
 * The main advantages of prototype pattern are as follows:
 *
 * It reduces the need of sub-classing.
 * It hides complexities of creating objects.
 * The clients can get new objects without knowing which type of object it will be.
 * It lets you add or remove objects at runtime.
 * Usage of Prototype Pattern
 * When the classes are instantiated at runtime.
 * When the cost of creating an object is expensive or complicated.
 * When you want to keep the number of classes in an application minimum.
 * When the client application needs to be unaware of object creation and representation.
 *
 *
 * clone method
 *
 */

interface Prototype {
    Prototype getClone();
}

class Employee implements Prototype {
    private String empId;
    private String name;
    private int salary;
    private String designation;

    public Employee(String empId, String name, int salary, String designation) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", designation='" + designation + '\'' +
                '}';
    }

    @Override
    public Prototype getClone() {
        return new Employee(empId, name, salary, designation);
    }
}

public class PrortotypePattern {

    public static void main(String args[]) {
        Employee obj1 = new Employee("12345", "Name", 3456, "Designation");
        System.out.println(obj1);
        Employee obj2 = (Employee) obj1.getClone();
        System.out.println(obj2);
    }
}
