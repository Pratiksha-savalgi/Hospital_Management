package com.project2.PatientManagement.Entity;

import com.project2.PatientManagement.Entity.Type.bloodType;
import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@ToString (exclude = {"appointments", "insurance"})
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
  @OneToOne //Owning side
 private Insurance insurance;
@OneToMany(mappedBy = "patient") //Inverse side
private List<Appointment> appointments;


}
