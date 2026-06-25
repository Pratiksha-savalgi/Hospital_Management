package com.project2.PatientManagement.Repository;

import com.project2.PatientManagement.Entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}