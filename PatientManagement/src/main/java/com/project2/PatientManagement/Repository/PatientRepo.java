package com.project2.PatientManagement.Repository;

import com.project2.PatientManagement.Entity.Patient;
import com.project2.PatientManagement.Entity.Type.bloodType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Long> {
    Patient findByName(String name);



    List<Patient> findByBirthDateOrEmail(LocalDate date,String email);
    @Query("select p from Patient p where p.bloodGroup =?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") bloodType bloodGroup);
    @Query("select p.bloodGroup ,count(p) from Patient p group by p.bloodGroup")
    List<Object[]> CountEachBloodGroupType();

    @Query(value = "select * from patient" , nativeQuery = true)
    Page<Patient> findAllPatients(Pageable pageable);

    @Transactional
    @Modifying
    @Query("update Patient p set p.name=:name where p.id= :id")
    int updateNameWithId(@Param("name") String name,@Param("id") Long id);
}
