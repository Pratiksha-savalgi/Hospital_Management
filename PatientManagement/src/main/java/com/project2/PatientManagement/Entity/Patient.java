package com.project2.PatientManagement.Entity;

import com.project2.PatientManagement.Entity.Type.bloodType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Patient {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(nullable = false)
 private String name;

 @Column(unique = true, nullable = false)
 private String email;

 private LocalDate birthDate;

 @Enumerated(EnumType.STRING)
 private bloodType bloodGroup;

 @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
 @JoinColumn(name = "insurance_id")
 private Insurance insurance;

 @OneToMany(
         mappedBy = "patient",
         cascade = CascadeType.REMOVE,
         orphanRemoval = true
 )
 @ToString.Exclude
 private List<Appointment> appointments = new ArrayList<>();
}




