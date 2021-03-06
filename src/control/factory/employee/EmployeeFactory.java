/**
 * This Interface implements the Factory Method Pattern
 */

package control.factory.employee;

import models.employees.Employee;

public interface EmployeeFactory {
    Employee createEmployee(int id);
    Employee editEmployee(Employee employee);
}
