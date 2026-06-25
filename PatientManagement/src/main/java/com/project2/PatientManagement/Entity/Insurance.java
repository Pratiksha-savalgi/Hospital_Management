package com.project2.PatientManagement.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true,length = 50)
    private String policyNumber;

    @Column(nullable = false,length = 100)
    private String provider;

    @Column(nullable = false)
    private LocalDate validDate;
    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime created_at;
    @OneToOne(mappedBy = "insurance")//Inverse side

     //nullable is not set to false bcoz patient may not have insuranc
    private Patient patient;
}
