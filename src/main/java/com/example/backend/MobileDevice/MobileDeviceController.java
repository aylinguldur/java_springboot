package com.example.backend.MobileDevice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MobileDeviceController {

    @Autowired
    IMobileDeviceService mobileDeviceService;

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveMobileDevice(@RequestBody List<MobileDevice> mobileDevice)
    {
        for(int i=0;i<mobileDevice.size();i++) {
            MobileDevice mobileDeviceObject = mobileDevice.get(i);
            String os = mobileDeviceObject.getOs();
            System.out.println(os);
            if (os.equals("Android") || os.equals("iOS")) {
                mobileDeviceService.saveMobileDevice(mobileDeviceObject);
            }
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<MobileDevice> getMobileDeviceById(@PathVariable("id") Integer id) {

        MobileDevice device = mobileDeviceService.getMobileDeviceById(id);
        return new ResponseEntity<>(device, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteMobileDevice(@PathVariable("id") Integer id){
        mobileDeviceService.deleteMobileDevice(id);

    }

    @PutMapping("/updateById/{id}")
    public void updateMobileDevice(@PathVariable("id") Integer id, @RequestBody MobileDevice mobileDevice){
        mobileDeviceService.updateMobileDeviceById(id,mobileDevice);
    }
}
