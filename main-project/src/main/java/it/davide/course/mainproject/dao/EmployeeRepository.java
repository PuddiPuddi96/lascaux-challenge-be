package it.davide.course.mainproject.dao;

import it.davide.course.mainproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "employees") //employees is default value
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
