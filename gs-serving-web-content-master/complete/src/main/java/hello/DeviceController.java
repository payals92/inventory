package hello;

import dataproviders.DevicesDataProvider;
import dataproviders.IDBDataProvider;
import dataproviders.MongoDBDataProvider;
import models.Device;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class DeviceController {
    DevicesDataProvider devicesDataProvider;
    public DeviceController(DevicesDataProvider devicesDataProvider) {
       this.devicesDataProvider = devicesDataProvider;
    }

    @PostMapping("/devices")
    public Device addDevice(@RequestBody Device device) {
        device.setDeviceId(UUID.randomUUID().toString());

        this.devicesDataProvider.insert(device);

        return  device;
    }
}
