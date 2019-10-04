package dataproviders;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class MongoDBDataProvider implements IDBDataProvider{
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;

    public MongoDBDataProvider(String databasename) {
        CodecRegistry pojoCodecRegistry = org.bson.codecs.configuration.CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), org.bson.codecs.configuration.CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        this.mongoClient = MongoClients.create("mongodb://plessentials:fqe9Tq7bo6M5YnKs3ygo5BhAEAqo8NcMoqEqh05RaW6f9KgVbGCgQWD5aHUrlzbVvjFLlgyEZmtpT5CIxZ0okw==@plessentials.documents.azure.com:10255/?ssl=true&replicaSet=globaldb");
        this.mongoDatabase = mongoClient.getDatabase(databasename).withCodecRegistry(pojoCodecRegistry);
    }

    public void insert(String collectionName, Document document) {
        MongoCollection<Document> collection = this.mongoDatabase.getCollection(collectionName);
        collection.insertOne(document);
    }
}
