package com.denizozgun.hotel_booking_project.mapper;

import com.denizozgun.hotel_booking_project.dto.UserDto;
import com.denizozgun.hotel_booking_project.entity.User;

public class UserMapper {

    public static UserDto map(User entity) {
        return UserDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .role(entity.getRole())
                .build();
    }

    public static User convertToEntity(UserDto dto) {
        return User.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .role(dto.getRole())
                .build();
    }
}
