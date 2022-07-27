package com.example.backend.MobileDevice;

import java.util.List;

public interface IMobileDeviceService {

    void saveMobileDevice(MobileDevice mobileDevice);

    MobileDevice getMobileDeviceById(int id);

    void deleteMobileDevice(int id);

    void updateMobileDeviceById(Integer id, MobileDevice mobileDevice);

    List<MobileDevice> getAllDevices(int pageNo, int pageSize);
}
