package com.awsDBdemo.db1Demo.repository;

import com.awsDBdemo.db1Demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
