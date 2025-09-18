package com.denizozgun.hotel_booking_project.entity;

import com.denizozgun.hotel_booking_project.enumurate.Role;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;


    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

}