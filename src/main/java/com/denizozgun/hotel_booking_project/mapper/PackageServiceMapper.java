package com.denizozgun.hotel_booking_project.mapper;

import com.denizozgun.hotel_booking_project.dto.PackageServiceDto;
import com.denizozgun.hotel_booking_project.entity.PackageService;

public class PackageServiceMapper {

    public static PackageServiceDto map(PackageService packageService) {

        return PackageServiceDto.builder()
                .id(packageService.getId())
                .packageDto(PackageMapper.map(packageService.getAPackage()))
                .serviceDto(ServiceMapper.map(packageService.getService()))
                .build();
    }

    public static PackageService convertToEntity(PackageServiceDto packageService) {

        return PackageService.builder()
                .id(packageService.getId())
                .aPackage(PackageMapper.convertToEntity(packageService.getPackageDto()))
                .service(ServiceMapper.convertToEntity(packageService.getServiceDto()))
                .build();
    }

}
