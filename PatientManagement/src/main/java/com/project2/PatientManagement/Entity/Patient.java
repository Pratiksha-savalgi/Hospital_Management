package com.project2.PatientManagement.Entity;

import com.project2.PatientManagement.Entity.Type.bloodType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
public class Patient {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
 public String name;
 @Column(unique = true,nullable = false)
 public String email;
 public LocalDate birthDate;

 @Enumerated(EnumType.STRING)
 public bloodType bloodGroup;

  @OneToOne (cascade = {CascadeType.MERGE,CascadeType.PERSIST})//Owning side
 private Insurance insurance;

@OneToMany(mappedBy = "patient",cascade = {CascadeType.REMOVE},orphanRemoval = true)//Inverse side
@ToString.Exclude
private List<Appointment> appointments;



}
