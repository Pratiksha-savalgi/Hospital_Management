package com.project2.PatientManagement.Repository;

import com.project2.PatientManagement.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}