package com.example.backend.MobileDevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MobileDeviceServiceImpl implements IMobileDeviceService {

    @Autowired
    MobileDeviceRepository mobileDeviceRepository;

    public void saveMobileDevice(MobileDevice mobileDevice) {
        mobileDeviceRepository.save(mobileDevice);
    }


    public MobileDevice getMobileDeviceById(int id) {

        Optional<MobileDevice> mobileDevice = mobileDeviceRepository.findById(id);
        return mobileDevice.get();
    }

    public void deleteMobileDevice(int id) {

        mobileDeviceRepository.deleteById(id);
    }

    public void updateMobileDeviceById(Integer id, MobileDevice mobileDevice) {

        MobileDevice existingMobileDevice = mobileDeviceRepository.findById(id).get();

        String brand = mobileDevice.getBrand();
        String model = mobileDevice.getModel();
        String os = mobileDevice.getOs();
        String osVersion = mobileDevice.getOsVersion();

        System.out.println(model.isEmpty());

        if (brand != null && brand.isEmpty() != true) {
            existingMobileDevice.setBrand(mobileDevice.getBrand());
        }
        if (model != null && model.isEmpty() != true) {
            existingMobileDevice.setModel(mobileDevice.getModel());
        }
        if (os != null && os.isEmpty() != true) {
            existingMobileDevice.setOs(mobileDevice.getOs());
        }
        if (osVersion != null && osVersion.isEmpty() != true) {
            existingMobileDevice.setOsVersion(mobileDevice.getOsVersion());
        }

        mobileDeviceRepository.save(existingMobileDevice);

    }

    @Override
    public List<MobileDevice> getAllDevices(int pageNo, int pageSize) {

        Pageable paging = PageRequest.of(pageNo, pageSize);

        Page<MobileDevice> pagedResult = mobileDeviceRepository.findAll(paging);

        return pagedResult.toList();

    }
}
