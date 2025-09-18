package com.denizozgun.hotel_booking_project.mapper;


import com.denizozgun.hotel_booking_project.dto.PackageDto;
import com.denizozgun.hotel_booking_project.entity.Package;

public class PackageMapper {

    public static PackageDto map(Package aPackage) {
        return PackageDto.builder()
                .id(aPackage.getId())
                .name(aPackage.getName())
                .build();
    }

    public static Package convertToEntity(PackageDto aPackage) {
        return Package.builder()
                .id(aPackage.getId())
                .name(aPackage.getName())
                .build();
    }
}
