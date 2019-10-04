package dataproviders;

import models.Device;
import org.bson.Document;

public class DevicesDataProvider {
    private IDBDataProvider dbDataProvider;
    public DevicesDataProvider(IDBDataProvider dbDataProvider) {
        this.dbDataProvider = dbDataProvider;
    }

    public void insert(Device device){
        Document document = new Document();
        document.append("deviceId", device.getDeviceId());
        document.append("name", device.getName());
        document.append("brand", device.getBrand());
        document.append("price", device.getPrice());
        document.append("quantity", device.getQuantity());

        this.dbDataProvider.insert("devices", document);
    }
}
