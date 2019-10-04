package dataproviders;

import org.bson.Document;

public interface IDBDataProvider {
    public void insert(String collectionName, Document document);
}
