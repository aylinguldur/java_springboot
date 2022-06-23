package com.example.backend.MobileDevice;


import org.springframework.http.ResponseEntity;

public interface IMobileDeviceService {

    void saveMobileDevice(MobileDevice mobileDevice);

    MobileDevice getMobileDeviceById(int id);

    void deleteMobileDevice(int id);

    void updateMobileDeviceById(Integer id, MobileDevice mobileDevice);
}
