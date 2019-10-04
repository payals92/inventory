package dataProvider;

import dataproviders.DevicesDataProvider;
import dataproviders.IDBDataProvider;
import models.Device;
import org.bson.Document;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DevicesDataProviderTest {
    @Test
    public void insertTest() {
        Device d = new Device();
        d.setName("IPhone");
        d.setBrand("Apple");
        d.setPrice(1000);
        d.setQuantity(1);

        DevicesDataProvider devicesDataProvider = new DevicesDataProvider(new MockDBDataProvider());
        devicesDataProvider.insert(d);
    }
}

class MockDBDataProvider implements IDBDataProvider {

    @Override
    public void insert(String collectionName, Document document) {
        assertEquals("devices", collectionName);
        assertEquals("IPhone", document.get("name"));
        assertEquals(1000, document.get("price"));
        assertEquals(1, document.get("quantity"));
        assertEquals("Apple", document.get("brand"));
    }
}

