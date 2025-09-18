package com.denizozgun.hotel_booking_project.dto;

import com.denizozgun.hotel_booking_project.enumurate.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;

}
